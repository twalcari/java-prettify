package prettify.theme;

import java.awt.Color;
import java.awt.Font;
import prettify.Theme;

/**
 * Son of Obsidian theme.
 * @author Alex Ford
 */
public class ThemeSonsOfObsidian extends Theme {

    public ThemeSonsOfObsidian() {
        super();

        /*
         * Derived from einaros's Sons of Obsidian theme at
         * http://studiostyl.es/schemes/son-of-obsidian by
         * Alex Ford of CodeTunnel:
         * http://CodeTunnel.com/blog/post/71/google-code-prettify-obsidian-theme
         */

        setFont(new Font("Consolas", Font.PLAIN, 12));
        setBackground(Color.white);

        setHighlightedBackground(Color.decode("0x111"));

        setGutterText(Color.decode("0xF1F2F3"));
        setGutterBorderColor(Color.decode("0x111"));
        setGutterBorderWidth(3);
        setGutterTextFont(new Font("Verdana", Font.PLAIN, 11));
        setGutterTextPaddingLeft(7);
        setGutterTextPaddingRight(7);

        Style plainStyle = new Style();
        plainStyle.setColor(Color.decode("0xF1F2F3"));
        setPlain(plainStyle);

        Style style;

        style = new Style();
        style.setColor(Color.decode("0xEC7600"));
        setString(style);

        style = new Style();
        style.setColor(Color.decode("0x93C763"));
        setKeyword(style);

        style = new Style();
        style.setColor(Color.decode("0x66747B"));
        setComment(style);

        style = new Style();
        style.setColor(Color.decode("0x678CB1"));
        setType(style);

        style = new Style();
        style.setColor(Color.decode("0xFACD22"));
        setLiteral(style);

        style = new Style();
        style.setColor(Color.decode("0xF1F2F3"));
        setPunctuation(style);

        style = new Style();
        style.setColor(Color.decode("0x8AC763"));
        setTag(style);

        style = new Style();
        style.setColor(Color.decode("0x800080"));
        setDeclaration(style);

        style = new Style();
        style.setColor(Color.decode("0xE0E2E4"));
        setAttributeName(style);

        style = new Style();
        style.setColor(Color.decode("0xEC7600"));
        setAttributeValue(style);

        setNoCode(plainStyle);

        setOpenBracket(plainStyle);

        setCloseBracket(plainStyle);

        setVariable(plainStyle);

        setFunction(plainStyle);
    }
}
