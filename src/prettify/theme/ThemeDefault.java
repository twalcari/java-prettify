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

        setHighlightedBackground(Color.decode("0xeee"));

        setGutterText(Color.decode("0x000"));
        setGutterBorderColor(Color.decode("0xeee"));
        setGutterBorderWidth(3);
        setGutterTextFont(new Font("Verdana", Font.PLAIN, 11));
        setGutterTextPaddingLeft(7);
        setGutterTextPaddingRight(7);

        Style plainStyle = new Style();
        plainStyle.setColor(Color.decode("0x000"));
        setPlain(plainStyle);

        Style style;

        style = new Style();
        style.setColor(Color.decode("0x080"));
        setString(style);

        style = new Style();
        style.setColor(Color.decode("0x008"));
        setKeyword(style);

        style = new Style();
        style.setColor(Color.decode("0x800"));
        setComment(style);

        style = new Style();
        style.setColor(Color.decode("0x606"));
        setType(style);

        style = new Style();
        style.setColor(Color.decode("0x066"));
        setLiteral(style);

        style = new Style();
        style.setColor(Color.decode("0x660"));
        setPunctuation(style);

        style = new Style();
        style.setColor(Color.decode("0x008"));
        setTag(style);

        setDeclaration(plainStyle);

        style = new Style();
        style.setColor(Color.decode("0x606"));
        setAttributeName(style);

        style = new Style();
        style.setColor(Color.decode("0x080"));
        setAttributeValue(style);

        setNoCode(plainStyle);

        style = new Style();
        style.setColor(Color.decode("0x660"));
        setOpenBracket(style);

        style = new Style();
        style.setColor(Color.decode("0x660"));
        setCloseBracket(style);

        style = new Style();
        style.setColor(Color.decode("0x606"));
        setVariable(style);

        style = new Style();
        style.setColor(Color.red);
        setFunction(style);
    }
}
