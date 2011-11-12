package prettify;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Chan Wai Shing <cws1989@gmail.com>
 */
public class Util {

    public static String[] match(Pattern pattern, String string) {
        List<String> matchesList = new ArrayList<String>();

        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            matchesList.add(matcher.group(0));
        }

        return matchesList.toArray(new String[matchesList.size()]);
    }

    public static boolean test(Pattern pattern, String string) {
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }

    public static String join(List<String> strings) {
        return join(strings.toArray(new String[strings.size()]));
    }

    public static String join(List<String> strings, String delimiter) {
        return join(strings.toArray(new String[strings.size()]), delimiter);
    }

    public static String join(String[] strings) {
        return join(strings, null);
    }

    public static String join(String[] strings, String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            if (delimiter != null && sb.length() != 0) {
                sb.append(delimiter);
            }
            sb.append(string);
        }
        return sb.toString();
    }
}
