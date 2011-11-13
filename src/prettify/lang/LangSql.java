package prettify.lang;

import java.util.Arrays;
import java.util.List;
import prettify.Lang;

public class LangSql extends Lang {

    public LangSql() {
    }

    public static List<String> getExtensions() {
        return Arrays.asList(new String[]{});
    }
}
