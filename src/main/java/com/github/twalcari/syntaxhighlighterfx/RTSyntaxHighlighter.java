package com.github.twalcari.syntaxhighlighterfx;

import javafx.application.Platform;
import org.fxmisc.richtext.StyleClassedTextArea;
import prettify.PrettifyParser;
import syntaxhighlight.ParseResult;

import java.util.List;

/**
 * User: twalcari
 * Date: 6/12/2015
 * Time: 15:11
 */
public class RTSyntaxHighlighter {

    private static final PrettifyParser prettifyParser = new PrettifyParser();

    private final StyleClassedTextArea textArea;
    private final String inputType;

    public RTSyntaxHighlighter(StyleClassedTextArea textArea, String inputType) {
        this.textArea = textArea;
        this.inputType = inputType;

        textArea.getStylesheets().add(RTSyntaxHighlighter.class.getResource("code-highlighter.css").toExternalForm());

        textArea.textProperty().addListener((obs, oldText, newText) -> {
            Platform.runLater(() -> computeAndApplyHighlighting(newText));
        });

        computeAndApplyHighlighting(textArea.getText());
    }


    public void computeAndApplyHighlighting(String text) {
        List<ParseResult> parseResults = prettifyParser.parse(inputType, text);

        try {
            for (ParseResult parseResult : parseResults) {
                textArea.setStyle(parseResult.getOffset(), parseResult.getOffset() + parseResult.getLength(), parseResult.getStyleKeys());
            }
        } catch (IllegalArgumentException ignored) {
            /*
            When the text has already changed by the time we apply the style,
            an  "IllegalArgumentException: end is greater than length" can occur.

            Fail fast in that case.
            */
        }
    }
}
