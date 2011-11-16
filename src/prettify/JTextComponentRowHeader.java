// Copyright (C) 2011 Chan Wai Shing
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package prettify;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;

/**
 * A row header panel for JScrollPane.
 * It is used with JTextComponent for line number displaying.<br />
 * Currently it only accept fixed-height line.<br />
 * <b>The usage is not limited to this syntax highlighter, it can be used on all JTextComponent.</b>
 * @author Chan Wai Shing <cws1989@gmail.com>
 */
public class JTextComponentRowHeader extends JPanel {

    /**
     * Indicate whether it is in debug mode or not.
     */
    protected final static boolean debug;

    static {
        String debugMode = System.getProperty("PrettifyDebugMode");
        debug = debugMode == null || !debugMode.equals("true") ? false : true;
    }
    private static final long serialVersionUID = 1L;
    /**
     * The anti-aliasing setting of the line number text. See {@link java.awt.RenderingHints}.
     */
    private Object textAntiAliasing = RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT;
    /**
     * The color of the border that joint the gutter and the script text panel.
     */
    private Color borderColor = new Color(184, 184, 184);
    /**
     * The background of the row when it is highlighted.
     */
    private Color highlightedColor = Color.black;
    /**
     * The minimum padding from 'the leftmost of the line number text' to 'the left margin'.
     */
    private int paddingLeft = 7;
    /**
     * The minimum padding from 'the rightmost of the line number text' to 'the right margin' (not to the gutter border).
     */
    private int paddingRight = 2;
    /**
     * The width of the border that joint the gutter and the script text panel.
     */
    private int borderWidth = 1;
    /**
     * The JScrollPane that it be added into.
     */
    protected JScrollPane scrollPane;
    /**
     * The text component to listen the change events on.
     */
    protected JTextComponent textComponent;
    /**
     * The document of the text component.
     */
    protected Document document;
    /**
     * The document listener for {@link #document}.
     */
    protected DocumentListener documentListener;
    /**
     * The cached panel width.
     */
    protected int panelWidth;
    /**
     * The cached largest row number (for determine panel width {@link #panelWidth}).
     */
    protected int largestRowNumber;
    /**
     * The cached text component height, for determine panel height.
     */
    protected int textComponentHeight;
    /**
     * The line number offset. E.g. set offset to 9 will make the first line number to appear at line 1 + 9 = 10
     */
    private int lineNumberOffset;
    /**
     * The list of line numbers that indicate which lines are needed to be highlighted.
     */
    private final List<Integer> highlightedLineList;
    /**
     * Indicator indicate whether it is listening to the document change events or not.
     */
    private boolean listenToDocumentUpdate;

    /**
     * Constructor.
     * @param scrollPane the JScrollPane that it be added into
     * @param textComponent the text component to listen the change events on
     */
    public JTextComponentRowHeader(JScrollPane scrollPane, JTextComponent textComponent) {
        super();

        if (scrollPane == null) {
            throw new NullPointerException("argument 'scrollPane' cannot be null");
        }
        if (textComponent == null) {
            throw new NullPointerException("argument 'textComponent' cannot be null");
        }

        setFont(new Font("Verdana", Font.PLAIN, 10));
        setForeground(Color.black);
        setBackground(new Color(233, 232, 226));

        this.scrollPane = scrollPane;
        this.textComponent = textComponent;

        panelWidth = 0;
        largestRowNumber = 1;
        textComponentHeight = 0;

        lineNumberOffset = 0;
        highlightedLineList = Collections.synchronizedList(new ArrayList<Integer>());

        listenToDocumentUpdate = true;

        document = textComponent.getDocument();
        documentListener = new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                handleEvent(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                handleEvent(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                handleEvent(e);
            }

            public void handleEvent(DocumentEvent e) {
                if (!listenToDocumentUpdate) {
                    return;
                }
                Document _document = e.getDocument();
                if (document == _document) {
                    checkPanelSize();
                } else {
                    _document.removeDocumentListener(this);
                }
            }
        };

        document.addDocumentListener(documentListener);

        checkPanelSize();
    }

    /**
     * Check if the 'document of the textComponent' has changed to another document or not.
     */
    protected void validateTextComponentDocument() {
        Document _currentDocument = textComponent.getDocument();
        if (document != _currentDocument) {
            document.removeDocumentListener(documentListener);
            document = _currentDocument;
            _currentDocument.addDocumentListener(documentListener);
        }
    }

    /**
     * Check whether the height of the row header panel match with the height of the text component or not.
     * If not, it will invoke {@link #updatePanelSize()}.
     */
    protected void checkPanelSize() {
        validateTextComponentDocument();
        int _largestRowNumber = document.getDefaultRootElement().getElementCount() + lineNumberOffset;
        int _panelWidth = getFontMetrics(getFont()).stringWidth(Integer.toString(_largestRowNumber)) + paddingLeft + paddingRight;
        if (panelWidth != _panelWidth || largestRowNumber != _largestRowNumber) {
            panelWidth = _panelWidth;
            largestRowNumber = _largestRowNumber;
            updatePanelSize();
        }
    }

    /**
     * Update the panel size.
     */
    protected void updatePanelSize() {
        Container parent = getParent();
        if (parent != null) {
            parent.doLayout();
            scrollPane.doLayout();
            parent.repaint();
        }
    }

    /**
     * The font of the line number.
     */
    @Override
    public void setFont(Font font) {
        super.setFont(font);
    }

    /**
     * The color of the line number.
     */
    @Override
    public void setForeground(Color foreground) {
        super.setForeground(foreground);
    }

    /**
     * The background of the panel.
     */
    @Override
    public void setBackground(Color background) {
        super.setBackground(background);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dimension getPreferredSize() {
        textComponentHeight = textComponent.getPreferredSize().height;
        return new Dimension(panelWidth, textComponentHeight);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // check whether the height of this panel matches the height of the text component or not
        Dimension textComponentPreferredSize = textComponent.getPreferredSize();
        if (textComponentHeight != textComponentPreferredSize.height) {
            textComponentHeight = textComponentPreferredSize.height;
            updatePanelSize();
        }

        JViewport viewport = scrollPane.getViewport();
        Point viewPosition = viewport.getViewPosition();
        Dimension viewportSize = viewport.getSize();

        validateTextComponentDocument();
        Element defaultRootElement = document.getDefaultRootElement();


        // maybe able to get the value when font changed and cache them
        // however i'm not sure if there is any condition which will make the java.awt.FontMetrics get by getFontMetrics() from java.awt.Graphics is different from getFontMetrics() from java.awt.Component
        FontMetrics fontMetrics = g.getFontMetrics(getFont());
        int fontHeight = fontMetrics.getHeight();
        int fontAscent = fontMetrics.getAscent();
        int fontLeading = fontMetrics.getLeading();

        FontMetrics textPaneFontMetrics = g.getFontMetrics(textComponent.getFont());
        int textPaneFontHeight = textPaneFontMetrics.getHeight();


        // get the location of the document of the left top and right bottom point of the visible part of the text component
        int documentOffsetStart = textComponent.viewToModel(viewPosition);
        int documentOffsetEnd = textComponent.viewToModel(new Point(viewPosition.x + viewportSize.width, viewPosition.y + viewportSize.height));

        // convert the location to line number
        int startLine = defaultRootElement.getElementIndex(documentOffsetStart) + 1 + lineNumberOffset;
        int endLine = defaultRootElement.getElementIndex(documentOffsetEnd) + 1 + lineNumberOffset;


        // draw right border
        g.setColor(borderColor);
        g.fillRect(panelWidth - borderWidth, viewPosition.y, borderWidth, viewportSize.height);

        // draw line number
        int startY = -1, baselineOffset = -1;
        try {
            startY = textComponent.modelToView(documentOffsetStart).y;
            baselineOffset = (textPaneFontHeight / 2) + fontAscent - (fontHeight / 2) + fontLeading;
        } catch (BadLocationException ex) {
            if (debug) {
                Logger.getLogger(JTextComponentRowHeader.class.getName()).log(Level.WARNING, null, ex);
            }
            return;
        }

        // text anti-aliasing
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, textAntiAliasing);
        // preserve the foreground color (for recover the color after highlighing the line)
        Color foregroundColor = getForeground();

        g.setColor(foregroundColor);
        g.setFont(getFont());

        for (int i = startLine, y = startY + baselineOffset; i <= endLine; y += textPaneFontHeight, i++) {
            boolean highlighted = false;
            if (highlightedLineList.indexOf((Integer) i) != -1) {
                // highlight this line
                g.setColor(borderColor);
                g.fillRect(0, y - baselineOffset, panelWidth - borderWidth, textPaneFontHeight);
                g.setColor(highlightedColor);
                highlighted = true;
            }

            // draw the line number
            String lineNumberString = Integer.toString(i);
            int lineNumberStringWidth = fontMetrics.stringWidth(lineNumberString);
            g.drawString(lineNumberString, panelWidth - lineNumberStringWidth - paddingRight, y);

            // restore the line number text color
            if (highlighted) {
                g.setColor(foregroundColor);
            }
        }
    }

    /**
     * The anti-aliasing setting of the line number text. See {@link java.awt.RenderingHints}.
     */
    public Object getTextAntiAliasing() {
        return textAntiAliasing;
    }

    /**
     * The anti-aliasing setting of the line number text. See {@link java.awt.RenderingHints}.
     */
    public void setTextAntiAliasing(Object textAntiAliasing) {
        if (textAntiAliasing == null) {
            throw new NullPointerException("argument 'textAntiAliasing' cannot be null");
        }
        this.textAntiAliasing = textAntiAliasing;
        repaint();
    }

    /**
     * The color of the border that joint the gutter and the script text panel.
     */
    public Color getBorderColor() {
        return borderColor;
    }

    /**
     * The color of the border that joint the gutter and the script text panel.
     */
    public void setBorderColor(Color borderColor) {
        if (borderColor == null) {
            throw new NullPointerException("argument 'borderColor' cannot be null");
        }
        this.borderColor = borderColor;
        repaint();
    }

    /**
     * The background of the highlighted row.
     */
    public Color getHighlightedColor() {
        return highlightedColor;
    }

    /**
     * The background of the highlighted row.
     */
    public void setHighlightedColor(Color highlightedColor) {
        if (highlightedColor == null) {
            throw new NullPointerException("argument 'highlightedColor' cannot be null");
        }
        this.highlightedColor = highlightedColor;
        repaint();
    }

    /**
     * The minimum padding from the 'leftmost of the line number text' to the 'left margin'.
     */
    public int getPaddingLeft() {
        return paddingLeft;
    }

    /**
     * The minimum padding from 'the leftmost of the line number text' to the 'left margin'.
     */
    public void setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
        checkPanelSize();
    }

    /**
     * The minimum padding from the 'rightmost of the line number text' to the 'right margin' (not to the gutter border).
     */
    public int getPaddingRight() {
        return paddingRight;
    }

    /**
     * The minimum padding from the 'rightmost of the line number text' to the 'right margin' (not to the gutter border).
     */
    public void setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
        checkPanelSize();
    }

    /**
     * The width of the border that joint the gutter and the script text panel.
     */
    public int getBorderWidth() {
        return borderWidth;
    }

    /**
     * The width of the border that joint the gutter and the script text panel.
     */
    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        repaint();
    }

    /**
     * Get the line number offset
     * @return the offset
     */
    public int getLineNumberOffset() {
        return lineNumberOffset;
    }

    /**
     * Set the line number offset. E.g. set offset to 9 will make the first line number to appear at line 1 + 9 = 10
     * @param offset the offset
     */
    public void setLineNumberOffset(int offset) {
        lineNumberOffset = Math.max(lineNumberOffset, offset);
        checkPanelSize();
        repaint();
    }

    /**
     * Get the list of highlighted lines.
     * @return a copy of the list
     */
    public List<Integer> getHighlightedLineList() {
        List<Integer> returnList;
        synchronized (highlightedLineList) {
            returnList = new ArrayList<Integer>(highlightedLineList);
        }
        return returnList;
    }

    /**
     * Set highlighted lines. Note that this will clear all previous recorded highlighted lines.
     * @param highlightedLineList the list that contain the highlighted lines
     */
    public void setHighlightedLineList(List<Integer> highlightedLineList) {
        synchronized (this.highlightedLineList) {
            this.highlightedLineList.clear();
            if (highlightedLineList != null) {
                this.highlightedLineList.addAll(highlightedLineList);
            }
        }
        repaint();
    }

    /**
     * Add highlighted line.
     * @param lineNumber the line number to highlight
     */
    public void addHighlightedLine(int lineNumber) {
        highlightedLineList.add(lineNumber);
        repaint();
    }

    /**
     * Check if it is listening to the document change events.
     * @return true if it is listening, false if not 
     */
    public boolean isListenToDocumentUpdate() {
        return listenToDocumentUpdate;
    }

    /**
     * Set to listen to document change events or not. It is useful when a number of updates are needed to be done to the text component.
     * May invoke {@link #updatePanelSize()}.
     * @param listenToDocumentUpdate true to listen on document change, false not
     */
    public void setListenToDocumentUpdate(boolean listenToDocumentUpdate) {
        this.listenToDocumentUpdate = listenToDocumentUpdate;
    }
}
