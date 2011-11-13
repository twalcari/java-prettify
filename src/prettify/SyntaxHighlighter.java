/**
 * This is part of the Java Prettify.
 * 
 * It is distributed under MIT license. See the file 'readme.txt' for
 * information on usage and redistribution of this file, and for a
 * DISCLAIMER OF ALL WARRANTIES.
 * 
 * @author Chan Wai Shing <cws1989@gmail.com>
 */
package prettify;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;

/**
 * The syntax highlighter.
 * @author Chan Wai Shing <cws1989@gmail.com>
 */
public class SyntaxHighlighter extends JScrollPane {

    static {
        // set debug mode
        System.setProperty("PrettifyDebugMode", "false");
    }
    private static final long serialVersionUID = 1L;
    /**
     * The script text panel.
     */
    protected SyntaxHighlighterPane highlighter;
    /**
     * The gutter panel (line number).
     */
    protected JTextComponentRowHeader highlighterRowHeader;
    /**
     * The theme.
     */
    protected Theme theme;
    /**
     * The content of the syntax highlighter, null if there is no content so far.
     */
    protected String content;

    /**
     * Constructor.
     * @param theme the theme for the syntax highlighter
     */
    public SyntaxHighlighter(Theme theme) {
        this(theme, new SyntaxHighlighterPane());
    }

    /**
     * Constructor.
     * @param theme the theme for the syntax highlighter
     * @param highlighterPane the script text pane of the syntax highlighter
     */
    public SyntaxHighlighter(Theme theme, SyntaxHighlighterPane highlighterPane) {
        super();

        if (theme == null) {
            throw new NullPointerException("argument 'theme' cannot be null");
        }
        if (highlighterPane == null) {
            throw new NullPointerException("argument 'highlighterPane' cannot be null");
        }

        this.theme = theme;

        setBorder(null);

        highlighter = highlighterPane;
        highlighter.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        highlighter.setTheme(theme);
        setViewportView(highlighter);

        highlighterRowHeader = new JTextComponentRowHeader(this, highlighter);
        theme.setTheme(highlighterRowHeader);
        setRowHeaderView(highlighterRowHeader);
    }

    /**
     * Re-render the script text pane. Invoke this when any change of setting that affect the rendering was made.
     * This will re-parse the content and set the style.
     */
    protected void render() {
//        if (content != null) {
//            Parser parser = new Parser();
//            // stop the change listener on the row header to speed up rendering
//            highlighterRowHeader.setListenToDocumentUpdate(false);
//            highlighter.setStyle(parser.parse(brush, htmlScript, content.toCharArray(), 0, content.length()));
//            // resume the change listener on the row header
//            highlighterRowHeader.setListenToDocumentUpdate(true);
//            // notify the row header to update its information related to the SyntaxHighlighterPane
//            // need to call this because we have stopped the change listener of the row header in previous code
//            highlighterRowHeader.checkPanelSize();
//        }
    }

    /**
     * Get the SyntaxHighlighterPane (the script text panel).
     * <p><b>Note: Normally should not operate on the SyntaxHighlighterPane directly.</b></p>
     * @return the SyntaxHighlighterPane
     */
    public SyntaxHighlighterPane getHighlighter() {
        return highlighter;
    }

    /**
     * Get the JTextComponentRowHeader, the line number panel.
     * <p><b>Note: Normally should not operate on the JTextComponentRowHeader directly.</b></p>
     * @return the JTextComponentRowHeader
     */
    public JTextComponentRowHeader getHighlighterRowHeader() {
        return highlighterRowHeader;
    }

    /**
     * Get current theme.
     * @return the current theme
     */
    public Theme getTheme() {
        return theme;
    }

    /**
     * Set the theme.
     * <p>
     * Setting the theme will not re-parse the content, but will clear and apply the new theme on the script text pane.
     * </p>
     * @param theme the theme
     */
    public void setTheme(Theme theme) {
        if (theme == null) {
            throw new NullPointerException("argument 'theme' cannot be null");
        }
        if (!this.theme.equals(theme)) {
            this.theme = theme;
            highlighter.setTheme(theme);
            theme.setTheme(highlighterRowHeader);
        }
    }

    /**
     * Set the line number of the first line. E.g. if set 10, the line number will start count from 10 instead of 1.
     * @param firstLine the line number of the first line
     */
    public void setFirstLine(int firstLine) {
        highlighterRowHeader.setLineNumberOffset(firstLine - 1);
        highlighter.setLineNumberOffset(firstLine - 1);
    }

    /**
     * Get the list of highlighted lines.
     * @return a copy of the list
     */
    public List<Integer> getHighlightedLineList() {
        return highlighter.getHighlightedLineList();
    }

    /**
     * Set highlighted lines. Note that this will clear all previous recorded highlighted lines.
     * @param highlightedLineList the list that contain the highlighted lines
     */
    public void setHighlightedLineList(List<Integer> highlightedLineList) {
        highlighterRowHeader.setHighlightedLineList(highlightedLineList);
        highlighter.setHighlightedLineList(highlightedLineList);
    }

    /**
     * Add highlighted line.
     * @param lineNumber the line number to highlight
     */
    public void addHighlightedLine(int lineNumber) {
        highlighterRowHeader.addHighlightedLine(lineNumber);
        highlighter.addHighlightedLine(lineNumber);
    }

    /**
     * Get the visibility of the gutter.
     * @return true if the gutter is visible, false if not
     */
    public boolean isGutterVisible() {
        return getRowHeader() != null && getRowHeader().getView() != null;
    }

    /**
     * Set the visibility of the gutter.
     * @param visible true to make visible, false to hide it
     */
    public void setGutterVisible(boolean visible) {
        if (visible) {
            setRowHeaderView(highlighterRowHeader);
            highlighter.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        } else {
            setRowHeaderView(null);
            highlighter.setBorder(null);
        }
    }

    /**
     * Get the status of the mouse-over highlight effect. Default is on.
     * @return true if turned on, false if turned off
     */
    public boolean isHighlightOnMouseOver() {
        return highlighter.isHighlightOnMouseOver();
    }

    /**
     * Set turn on the mouse-over highlight effect or not.
     * If set true, there will be a highlight effect on the line that the mouse cursor currently is pointing on (on the script text panel only, not on the line number panel).
     * @param highlightWhenMouseOver true to turn on, false to turn off
     */
    public void setHighlightOnMouseOver(boolean highlightWhenMouseOver) {
        highlighter.setHighlightOnMouseOver(highlightWhenMouseOver);
    }

    /**
     * Set the content of the syntax highlighter. Better set it last after setting all other settings.
     * @param file the file to read 
     */
    public void setContent(File file) throws IOException {
        setContent(readFile(file));
    }

    /**
     * Set the content of the syntax highlighter. It is better to set other settings first and set this the last.
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
        highlighter.setContent(content);
        render();
    }

    /**
     * Get the string content of a file.
     * @param file the file to retrieve the content from
     * @return the string content
     * @throws IOException error occured, either it is not a valid file or failed to read the file
     */
    protected static String readFile(File file) throws IOException {
        if (file == null) {
            throw new IOException("argument 'file' cannot be null");
        }
        if (!file.isFile()) {
            throw new IOException("It is not a file.");
        }

        byte[] buffer = new byte[(int) file.length()];

        FileInputStream fileIn = new FileInputStream(file);
        fileIn.read(buffer);
        fileIn.close();

        return new String(buffer);
    }
}
