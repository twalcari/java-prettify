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

import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 * Theme for the Java Prettify.
 * <p>To make a new theme, either extending this class of initiate this class and set the parameter by the setter.
 * For the default value, please refer to the constructor.</p>
 * @author Chan Wai Shing <cws1989@gmail.com>
 */
public class Theme {

    /**
     * Indicate whether it is in debug mode or not.
     */
    protected final static boolean debug;

    static {
        String debugMode = System.getProperty("PrettifyDebugMode");
        debug = debugMode == null || !debugMode.equals("true") ? false : true;
    }
    /**
     * The font of the script text.
     */
    protected Font font;
    /**
     * The background color of the script text area.
     */
    protected Color background;
    /**
     * The background color of the highlighted line of script text.
     */
    protected Color highlightedBackground;
    /**
     * Gutter (line number column on the left)
     */
    /**
     * The color of the gutter text.
     */
    protected Color gutterText;
    /**
     * The color of the border that joint the gutter and the script text panel.
     */
    protected Color gutterBorderColor;
    /**
     * The width of the border that joint the gutter and the script text panel.
     */
    protected int gutterBorderWidth;
    /**
     * The font of the gutter text.
     */
    protected Font gutterTextFont;
    /**
     * The minimum padding from 'the leftmost of the line number text' to 'the left margin'.
     */
    protected int gutterTextPaddingLeft;
    /**
     * The minimum padding from 'the rightmost of the line number text' to 'the right margin' (not to the gutter border).
     */
    protected int gutterTextPaddingRight;
    protected Style string;
    protected Style keyword;
    protected Style comment;
    protected Style type;
    protected Style literal;
    protected Style punctuation;
    protected Style plain;
    protected Style tag;
    protected Style declaration;
    protected Style source;
    protected Style attributeName;
    protected Style attributeValue;
    protected Style noCode;
    protected Style openBracket;
    protected Style closeBracket;
    protected Style variable;
    protected Style function;

    /**
     * Constructor.<br />
     * <p>
     * <b>Default value:</b><br />
     * <ul>
     * <li>font: Consolas 12pt</li>
     * <li>background: white</li>
     * <li>gutter text: black</li>
     * <li>gutter border: R: 184, G: 184, B: 184</li>
     * <li>gutter border width: 3px</li>
     * <li>gutter text font: Consolas 12pt</li>
     * <li>gutter text padding-left: 7px</li>
     * <li>gutter text padding-right: 7px</li>
     * <li>plain, comments, string, keyword, preprocessor, variable, value, functions, constants, script, scriptBackground, color1, color2, color3: no style set</li>
     * </ul>
     * </p>
     */
    public Theme() {
        font = new Font("Consolas", Font.PLAIN, 12);
        background = Color.white;

        highlightedBackground = Color.gray;

        gutterText = Color.black;
        gutterBorderColor = new Color(184, 184, 184);
        gutterBorderWidth = 3;
        gutterTextFont = new Font("Consolas", Font.PLAIN, 12);
        gutterTextPaddingLeft = 7;
        gutterTextPaddingRight = 7;

        string = new Style();
        keyword = new Style();
        comment = new Style();
        type = new Style();
        literal = new Style();
        punctuation = new Style();
        plain = new Style();
        tag = new Style();
        declaration = new Style();
        source = new Style();
        attributeName = new Style();
        attributeValue = new Style();
        noCode = new Style();
        openBracket = new Style();
        closeBracket = new Style();
        variable = new Style();
        function = new Style();
    }

    /**
     * Apply the theme to the row header panel.
     * @param rowHeader the row header to apply theme on
     */
    public void setTheme(JTextComponentRowHeader rowHeader) {
        rowHeader.setBackground(background);
        rowHeader.setHighlightedColor(background);

        rowHeader.setForeground(gutterText);
        rowHeader.setBorderColor(gutterBorderColor);
        rowHeader.setBorderWidth(gutterBorderWidth);
        rowHeader.setFont(gutterTextFont);
        rowHeader.setPaddingLeft(gutterTextPaddingLeft);
        rowHeader.setPaddingRight(gutterTextPaddingRight);
    }

    /**
     * Get the {@link prettify.Theme.Style} by keyword.
     * @param key the keyword, possible values: plain, comments, string, keyword, preprocessor, variable, value, functions, constants, script, scriptBackground, color1, color2 or color3
     * @return the {@link prettify.Theme.Style} related to the {@code key}; if the style related to the <code>key</code> not exist, the style of 'plain' will return.
     */
    public Style getStyle(String key) {
        if (key.equals("str")) {
            return string;
        } else if (key.equals("kwd")) {
            return keyword;
        } else if (key.equals("com")) {
            return comment;
        } else if (key.equals("typ")) {
            return type;
        } else if (key.equals("lit")) {
            return literal;
        } else if (key.equals("pub")) {
            return punctuation;
        } else if (key.equals("pln")) {
            return plain;
        } else if (key.equals("tag")) {
            return tag;
        } else if (key.equals("dec")) {
            return declaration;
        } else if (key.equals("src")) {
            return source;
        } else if (key.equals("atn")) {
            return attributeName;
        } else if (key.equals("atv")) {
            return attributeValue;
        } else if (key.equals("nocode")) {
            return noCode;
        } else if (key.equals("opn")) {
            return openBracket;
        } else if (key.equals("clo")) {
            return closeBracket;
        } else if (key.equals("var")) {
            return variable;
        } else if (key.equals("fun")) {
            return function;
        } else {
            // key not exist
            return plain;
        }
    }

    /**
     * The font of the script text.
     */
    public Font getFont() {
        return font;
    }

    /**
     * The font of the script text.
     */
    public void setFont(Font font) {
        if (font == null) {
            throw new NullPointerException("argument 'font' cannot be null");
        }
        this.font = font;
    }

    /**
     * The background color of the script text area.
     */
    public Color getBackground() {
        return background;
    }

    /**
     * The background color of the script text area.
     */
    public void setBackground(Color background) {
        if (background == null) {
            throw new NullPointerException("argument 'background' cannot be null");
        }
        this.background = background;
    }

    /**
     * The background color of the highlighted line of script text.
     */
    public Color getHighlightedBackground() {
        return highlightedBackground;
    }

    /**
     * The background color of the highlighted line of script text.
     */
    public void setHighlightedBackground(Color highlightedBackground) {
        if (highlightedBackground == null) {
            throw new NullPointerException("argument 'highlightedBackground' cannot be null");
        }
        this.highlightedBackground = highlightedBackground;
    }

    /**
     * The color of the gutter text.
     */
    public Color getGutterText() {
        return gutterText;
    }

    /**
     * The color of the gutter text.
     */
    public void setGutterText(Color gutterText) {
        if (gutterText == null) {
            throw new NullPointerException("argument 'gutterText' cannot be null");
        }
        this.gutterText = gutterText;
    }

    /**
     * The color of the border that joint the gutter and the script text panel.
     */
    public Color getGutterBorderColor() {
        return gutterBorderColor;
    }

    /**
     * The color of the border that joint the gutter and the script text panel.
     */
    public void setGutterBorderColor(Color gutterBorderColor) {
        if (gutterBorderColor == null) {
            throw new NullPointerException("argument 'gutterBorderColor' cannot be null");
        }
        this.gutterBorderColor = gutterBorderColor;
    }

    /**
     * The width of the border that joint the gutter and the script text panel.
     */
    public int getGutterBorderWidth() {
        return gutterBorderWidth;
    }

    /**
     * The width of the border that joint the gutter and the script text panel.
     */
    public void setGutterBorderWidth(int gutterBorderWidth) {
        this.gutterBorderWidth = gutterBorderWidth;
    }

    /**
     * The font of the gutter text.
     */
    public Font getGutterTextFont() {
        return gutterTextFont;
    }

    /**
     * The font of the gutter text.
     */
    public void setGutterTextFont(Font gutterTextFont) {
        if (gutterTextFont == null) {
            throw new NullPointerException("argument 'gutterTextFont' cannot be null");
        }
        this.gutterTextFont = gutterTextFont;
    }

    /**
     * The minimum padding from 'the leftmost of the line number text' to 'the left margin'.
     */
    public int getGutterTextPaddingLeft() {
        return gutterTextPaddingLeft;
    }

    /**
     * The minimum padding from 'the leftmost of the line number text' to 'the left margin'.
     */
    public void setGutterTextPaddingLeft(int gutterTextPaddingLeft) {
        this.gutterTextPaddingLeft = gutterTextPaddingLeft;
    }

    /**
     * The minimum padding from 'the rightmost of the line number text' to 'the right margin' (not to the gutter border).
     */
    public int getGutterTextPaddingRight() {
        return gutterTextPaddingRight;
    }

    /**
     * The minimum padding from 'the rightmost of the line number text' to 'the right margin' (not to the gutter border).
     */
    public void setGutterTextPaddingRight(int gutterTextPaddingRight) {
        this.gutterTextPaddingRight = gutterTextPaddingRight;
    }

    public Style getString() {
        return string;
    }

    public void setString(Style string) {
        this.string = string;
    }

    public Style getKeyword() {
        return keyword;
    }

    public void setKeyword(Style keyword) {
        this.keyword = keyword;
    }

    public Style getComment() {
        return comment;
    }

    public void setComment(Style comment) {
        this.comment = comment;
    }

    public Style getType() {
        return type;
    }

    public void setType(Style type) {
        this.type = type;
    }

    public Style getLiteral() {
        return literal;
    }

    public void setLiteral(Style literal) {
        this.literal = literal;
    }

    public Style getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(Style punctuation) {
        this.punctuation = punctuation;
    }

    public Style getPlain() {
        return plain;
    }

    public void setPlain(Style plain) {
        this.plain = plain;
    }

    public Style getTag() {
        return tag;
    }

    public void setTag(Style tag) {
        this.tag = tag;
    }

    public Style getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Style declaration) {
        this.declaration = declaration;
    }

    public Style getSource() {
        return source;
    }

    public void setSource(Style source) {
        this.source = source;
    }

    public Style getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(Style attributeName) {
        this.attributeName = attributeName;
    }

    public Style getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(Style attributeValue) {
        this.attributeValue = attributeValue;
    }

    public Style getNoCode() {
        return noCode;
    }

    public void setNoCode(Style noCode) {
        this.noCode = noCode;
    }

    public Style getOpenBracket() {
        return openBracket;
    }

    public void setOpenBracket(Style openBracket) {
        this.openBracket = openBracket;
    }

    public Style getCloseBracket() {
        return closeBracket;
    }

    public void setCloseBracket(Style closeBracket) {
        this.closeBracket = closeBracket;
    }

    public Style getVariable() {
        return variable;
    }

    public void setVariable(Style variable) {
        this.variable = variable;
    }

    public Style getFunction() {
        return function;
    }

    public void setFunction(Style function) {
        this.function = function;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Theme clone() {
        Theme object = null;
        try {
            object = (Theme) super.clone();
            object.font = font;
            object.background = background;
            object.highlightedBackground = highlightedBackground;
            object.gutterText = gutterText;
            object.gutterBorderColor = gutterBorderColor;
            object.gutterBorderWidth = gutterBorderWidth;
            object.gutterTextFont = gutterTextFont;
            object.gutterTextPaddingLeft = gutterTextPaddingLeft;
            object.gutterTextPaddingRight = gutterTextPaddingRight;
            object.string = string.clone();
            object.keyword = keyword.clone();
            object.comment = comment.clone();
            object.type = type.clone();
            object.literal = literal.clone();
            object.punctuation = punctuation.clone();
            object.plain = plain.clone();
            object.tag = tag.clone();
            object.declaration = declaration.clone();
            object.source = source.clone();
            object.attributeName = attributeName.clone();
            object.attributeValue = attributeValue.clone();
            object.noCode = noCode.clone();
            object.openBracket = openBracket.clone();
            object.closeBracket = closeBracket.clone();
            object.variable = variable.clone();
            object.function = function.clone();
        } catch (CloneNotSupportedException ex) {
            if (debug) {
                Logger.getLogger(Theme.class.getName()).log(Level.WARNING, null, ex);
            }
        }
        return object;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(getClass().getName());
        sb.append(": ");
        sb.append("font: ").append(getFont());
        sb.append(", ");
        sb.append("background: ").append(getBackground());
        sb.append(", ");
        sb.append("highlightedBackground: ").append(getHighlightedBackground());
        sb.append(", ");
        sb.append("gutterText: ").append(getGutterText());
        sb.append(", ");
        sb.append("gutterBorderColor: ").append(getGutterBorderColor());
        sb.append(", ");
        sb.append("gutterBorderWidth: ").append(getGutterBorderWidth());
        sb.append(", ");
        sb.append("gutterTextFont: ").append(getGutterTextFont());
        sb.append(", ");
        sb.append("gutterTextPaddingLeft: ").append(getGutterTextPaddingLeft());
        sb.append(", ");
        sb.append("gutterTextPaddingRight: ").append(getGutterTextPaddingRight());
        sb.append(", ");
        sb.append("string: ").append(getString());
        sb.append(", ");
        sb.append("keyword: ").append(getKeyword());
        sb.append(", ");
        sb.append("comment: ").append(getComment());
        sb.append(", ");
        sb.append("type: ").append(getType());
        sb.append(", ");
        sb.append("literal: ").append(getLiteral());
        sb.append(", ");
        sb.append("punctuation: ").append(getPunctuation());
        sb.append(", ");
        sb.append("plain: ").append(getPlain());
        sb.append(", ");
        sb.append("tag: ").append(getTag());
        sb.append(", ");
        sb.append("declaration: ").append(getDeclaration());
        sb.append(", ");
        sb.append("source: ").append(getSource());
        sb.append(", ");
        sb.append("attributeName: ").append(getAttributeName());
        sb.append(", ");
        sb.append("attributeValue: ").append(getAttributeValue());
        sb.append(", ");
        sb.append("noCode: ").append(getNoCode());
        sb.append(", ");
        sb.append("openBracket: ").append(getOpenBracket());
        sb.append(", ");
        sb.append("closeBracket: ").append(getCloseBracket());
        sb.append(", ");
        sb.append("variable: ").append(getVariable());
        sb.append(", ");
        sb.append("function: ").append(getFunction());

        return sb.toString();
    }

    /**
     * The style used by {@link prettify.theme} as those of CSS styles.
     */
    public static class Style {

        protected boolean bold;
        protected Color color;
        /**
         * The background color, null means no background color is set.
         */
        protected Color background;
        protected boolean underline;
        protected boolean italic;

        /**
         * Constructor.
         * <p>
         * <b>Default values:</b><br />
         * <ul>
         * <li>bold: false;</li>
         * <li>color: black;</li>
         * <li>background: null;</li>
         * <li>underline: false;</li>
         * <li>italic: false;</li>
         * </ul>
         * </p>
         */
        public Style() {
            bold = false;
            color = Color.black;
            background = null;
            underline = false;
            italic = false;
        }

        /**
         * Apply the style to the AttributeSet.
         * Note that the AttributeSet should only be set by this function once or some unexpected style may appear.
         * @param attributeSet the AttributeSet to set the style on
         */
        public void setAttributeSet(SimpleAttributeSet attributeSet) {
            if (attributeSet == null) {
                return;
            }
            StyleConstants.setBold(attributeSet, bold);
            StyleConstants.setForeground(attributeSet, color);
            if (background != null) {
                StyleConstants.setBackground(attributeSet, background);
            } else {
                attributeSet.removeAttribute(StyleConstants.Background);
            }
            StyleConstants.setUnderline(attributeSet, underline);
            StyleConstants.setItalic(attributeSet, italic);
        }

        /**
         * Get the AttributeSet from this style.
         * @return the AttributeSet
         */
        public SimpleAttributeSet getAttributeSet() {
            SimpleAttributeSet attributeSet = new SimpleAttributeSet();
            StyleConstants.setBold(attributeSet, bold);
            StyleConstants.setForeground(attributeSet, color);
            if (background != null) {
                StyleConstants.setBackground(attributeSet, background);
            }
            StyleConstants.setUnderline(attributeSet, underline);
            StyleConstants.setItalic(attributeSet, italic);
            return attributeSet;
        }

        /**
         * Get the background color.
         * @return the background color or null if no color is set
         */
        public Color getBackground() {
            return background;
        }

        /**
         * Set the background color.
         * @param background input null means do not set the background
         */
        public void setBackground(Color background) {
            if (background == null) {
                throw new NullPointerException("argument 'background' cannot be null");
            }
            this.background = background;
        }

        public boolean isBold() {
            return bold;
        }

        public void setBold(boolean bold) {
            this.bold = bold;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            if (color == null) {
                throw new NullPointerException("argument 'color' cannot be null");
            }
            this.color = color;
        }

        public boolean isItalic() {
            return italic;
        }

        public void setItalic(boolean italic) {
            this.italic = italic;
        }

        public boolean isUnderline() {
            return underline;
        }

        public void setUnderline(boolean underline) {
            this.underline = underline;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof Style)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            Style _object = (Style) obj;
            return _object.bold == bold && _object.color.equals(color) && _object.background.equals(background)
                    && _object.underline == underline && _object.italic == italic;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Style clone() {
            Style object = null;
            try {
                object = (Style) super.clone();
                object.bold = bold;
                object.color = color;
                object.background = background;
                object.underline = underline;
                object.italic = italic;
            } catch (CloneNotSupportedException ex) {
            }
            return object;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            sb.append(getClass().getName());
            sb.append(": ");
            sb.append("bold: ").append(bold);
            sb.append(", ");
            sb.append("color: ").append(color);
            sb.append(", ");
            sb.append("bg: ").append(background);
            sb.append(", ");
            sb.append("underline: ").append(underline);
            sb.append(", ");
            sb.append("italic: ").append(italic);

            return sb.toString();
        }
    }
}
