package com.github.twalcari.prettify;

import javafx.concurrent.Task;
import org.fxmisc.richtext.PlainTextChange;
import org.fxmisc.richtext.StyleClassedTextArea;
import org.reactfx.EventStream;
import org.reactfx.util.Try;
import prettify.PrettifyParser;
import syntaxhighlight.ParseResult;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: twalcari
 * Date: 6/12/2015
 * Time: 15:11
 */
public class RTAsyncSyntaxHighlighter {

    private static final PrettifyParser prettifyParser = new PrettifyParser();

    private ExecutorService executor = Executors.newSingleThreadExecutor();

    private final StyleClassedTextArea textArea;
    private final String inputType;

    public RTAsyncSyntaxHighlighter(StyleClassedTextArea textArea, String inputType) {
        this.textArea = textArea;
        this.inputType = inputType;

        textArea.getStylesheets().add(RTSyntaxHighlighter.class.getResource("code-highlighter.css").toExternalForm());

        EventStream<PlainTextChange> textChanges = textArea.plainTextChanges();
        textChanges
                .successionEnds(Duration.ofMillis(100))
                .supplyTask(this::computeHighlightingAsync)
                .awaitLatest(textChanges)
                .map(Try::get)
                .subscribe(this::applyHighlighting);


        try {
            applyHighlighting(computeHighlightingAsync().get());
        } catch (InterruptedException | ExecutionException ignored) {
        }

    }

    private void applyHighlighting(List<ParseResult> parseResults) {
        for (ParseResult parseResult : parseResults) {
            textArea.setStyle(parseResult.getOffset(), parseResult.getOffset() +  parseResult.getLength(), parseResult.getStyleKeys());
        }
    }

    private Task<List<ParseResult>> computeHighlightingAsync() {
        final String text = textArea.getText();

        Task<List<ParseResult>> task = new Task<List<ParseResult>>() {
            @Override
            protected List<ParseResult> call() throws Exception {
                return prettifyParser.parse(inputType, text);
            }
        };

        executor.execute(task);
        return task;
    }

    public void stop(){
        executor.shutdown();
    }


}
