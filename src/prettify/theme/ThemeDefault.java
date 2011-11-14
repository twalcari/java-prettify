package prettify.theme;

import java.awt.Color;
import java.awt.Font;
import prettify.Theme;

/**
 * Default theme.
 */
public class ThemeDefault extends Theme {

    public ThemeDefault() {
        super();

        setFont(new Font("Consolas", Font.PLAIN, 12));
        setBackground(Color.white);

        setHighlightedBackground(Color.decode("0xcccccc"));

        setGutterText(Color.decode("0x000000"));
        setGutterBorderColor(Color.decode("0xaaaaaa"));
        setGutterBorderWidth(3);
        setGutterTextFont(new Font("Verdana", Font.PLAIN, 11));
        setGutterTextPaddingLeft(7);
        setGutterTextPaddingRight(7);

        Style plainStyle = new Style();
        plainStyle.setColor(Color.decode("0x000000"));
        setPlain(plainStyle);

        Style style;

        style = new Style();
        style.setColor(Color.decode("0x008800"));
        setString(style);

        style = new Style();
        style.setColor(Color.decode("0x000088"));
        setKeyword(style);

        style = new Style();
        style.setColor(Color.decode("0x880000"));
        setComment(style);

        style = new Style();
        style.setColor(Color.decode("0x660066"));
        setType(style);

        style = new Style();
        style.setColor(Color.decode("0x006666"));
        setLiteral(style);

        style = new Style();
        style.setColor(Color.decode("0x666600"));
        setPunctuation(style);

        style = new Style();
        style.setColor(Color.decode("0x000088"));
        setTag(style);

        setDeclaration(plainStyle);

        style = new Style();
        style.setColor(Color.decode("0x660066"));
        setAttributeName(style);

        style = new Style();
        style.setColor(Color.decode("0x008800"));
        setAttributeValue(style);

        setNoCode(plainStyle);

        style = new Style();
        style.setColor(Color.decode("0x666600"));
        setOpenBracket(style);

        style = new Style();
        style.setColor(Color.decode("0x666600"));
        setCloseBracket(style);

        style = new Style();
        style.setColor(Color.decode("0x660066"));
        setVariable(style);

        style = new Style();
        style.setColor(Color.red);
        setFunction(style);
    }
}
