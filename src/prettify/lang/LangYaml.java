// Contributed by ribrdb @ code.google.com
package prettify.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import prettify.Lang;
import prettify.Prettify;

/**
 * Registers a language handler for YAML.
 *
 * @author ribrdb
 */
public class LangYaml extends Lang {

    public LangYaml() {
        List<List<Object>> _shortcutStylePatterns = new ArrayList<List<Object>>();
        List<List<Object>> _fallthroughStylePatterns = new ArrayList<List<Object>>();

        _shortcutStylePatterns.add(Arrays.asList(new Object[]{Prettify.PR_PUNCTUATION, Pattern.compile("^[:|>?]+"), null, ":|>?"}));
        _shortcutStylePatterns.add(Arrays.asList(new Object[]{Prettify.PR_DECLARATION, Pattern.compile("^%(?:YAML|TAG)[^#\\r\\n]+"), null, "%"}));
        _shortcutStylePatterns.add(Arrays.asList(new Object[]{Prettify.PR_TYPE, Pattern.compile("^[&]\\S+"), null, "&"}));
        _shortcutStylePatterns.add(Arrays.asList(new Object[]{Prettify.PR_TYPE, Pattern.compile("^!\\S*"), null, "!"}));
        _shortcutStylePatterns.add(Arrays.asList(new Object[]{Prettify.PR_STRING, Pattern.compile("^\"(?:[^\\\\\"]|\\\\.)*(?:\"|$)"), null, "\""}));
        _shortcutStylePatterns.add(Arrays.asList(new Object[]{Prettify.PR_STRING, Pattern.compile("^'(?:[^']|'')*(?:'|$)"), null, "'"}));
        _shortcutStylePatterns.add(Arrays.asList(new Object[]{Prettify.PR_COMMENT, Pattern.compile("^#[^\\r\\n]*"), null, "#"}));
        _shortcutStylePatterns.add(Arrays.asList(new Object[]{Prettify.PR_PLAIN, Pattern.compile("^\\s+"), null, " \t\r\n"}));
        _fallthroughStylePatterns.add(Arrays.asList(new Object[]{Prettify.PR_DECLARATION, Pattern.compile("^(?:---|\\.\\.\\.)(?:[\\r\\n]|$)")}));
        _fallthroughStylePatterns.add(Arrays.asList(new Object[]{Prettify.PR_PUNCTUATION, Pattern.compile("^-")}));
        _fallthroughStylePatterns.add(Arrays.asList(new Object[]{Prettify.PR_KEYWORD, Pattern.compile("^\\w+:[ \\r\\n]")}));
        _fallthroughStylePatterns.add(Arrays.asList(new Object[]{Prettify.PR_PLAIN, Pattern.compile("^\\w+")}));

        setShortcutStylePatterns(_shortcutStylePatterns);
        setFallthroughStylePatterns(_fallthroughStylePatterns);
    }

    public static List<String> getFileExtensions() {
        return Arrays.asList(new String[]{"yaml", "yml"});
    }
}
