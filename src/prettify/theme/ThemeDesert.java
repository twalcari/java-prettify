package prettify.theme;

import java.awt.Color;
import java.awt.Font;
import prettify.Theme;

/**
 * Desert theme.
 */
public class ThemeDesert extends Theme {

    public ThemeDesert() {
        super();

        /* desert scheme ported from vim to google prettify */

        setFont(new Font("Consolas", Font.PLAIN, 12));
        setBackground(Color.decode("0x000"));

        setHighlightedBackground(Color.decode("0x111"));

        setGutterText(Color.decode("0xfff"));
        setGutterBorderColor(Color.decode("0x111"));
        setGutterBorderWidth(3);
        setGutterTextFont(new Font("Verdana", Font.PLAIN, 11));
        setGutterTextPaddingLeft(7);
        setGutterTextPaddingRight(7);

        Style plainStyle = new Style();
        plainStyle.setColor(Color.decode("0xfff"));
        setPlain(plainStyle);

        Style style;

        style = new Style();
        style.setColor(Color.decode("0xffa0a0")); /* string  - pink */
        setString(style);

        style = new Style();
        style.setColor(Color.decode("0xf0e68c"));
        style.setBold(true);
        setKeyword(style);

        style = new Style();
        style.setColor(Color.decode("0x87ceeb")); /* comment - skyblue */
        setComment(style);

        style = new Style();
        style.setColor(Color.decode("0x98fb98")); /* type    - lightgreen */
        setType(style);

        style = new Style();
        style.setColor(Color.decode("0xcd5c5c")); /* literal - darkred */
        setLiteral(style);

        style = new Style();
        style.setColor(Color.decode("0xfff"));
        setPunctuation(style);

        style = new Style();
        style.setColor(Color.decode("0xf0e68c"));/* html/xml tag    - lightyellow */
        style.setBold(true);
        setTag(style);

        style = new Style();
        style.setColor(Color.decode("0x98fb98")); /* decimal         - lightgreen */
        setDeclaration(style);

        style = new Style();
        style.setColor(Color.decode("0xbdb76b")); /* attribute name  - khaki */
        style.setBold(true);
        setAttributeName(style);

        style = new Style();
        style.setColor(Color.decode("0xffa0a0")); /* attribute value - pink */
        style.setBold(true);
        setAttributeValue(style);

        style = new Style();
        style.setColor(Color.decode("0x333"));
        setNoCode(style);

        setOpenBracket(plainStyle);

        setCloseBracket(plainStyle);

        setVariable(plainStyle);

        setFunction(plainStyle);
    }
}
