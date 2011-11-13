package prettify.lang;

import java.util.Arrays;
import java.util.List;
import prettify.Lang;

public class LangYaml extends Lang {

    public LangYaml() {
    }

    public static List<String> getExtensions() {
        return Arrays.asList(new String[]{});
    }
}
