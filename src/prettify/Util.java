package prettify;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Chan Wai Shing <cws1989@gmail.com>
 */
public class Util {

    /**
     * Read the resource file from the jar.
     * @param path the resource path
     * @return the content of the resource file in byte array
     * @throws IOException error occurred when reading the content from the file
     */
    public static byte[] readResourceFile(String path) throws IOException {
        if (path == null) {
            throw new NullPointerException("argument 'path' cannot be null");
        }

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        InputStream in = null;
        try {
            in = Util.class.getResourceAsStream(path);
            if (in == null) {
                throw new IOException("Resources not found: " + path);
            }

            int byteRead = 0;
            byte[] b = new byte[8096];

            while ((byteRead = in.read(b)) != -1) {
                bout.write(b, 0, byteRead);
            }
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                }
            }
        }

        return bout.toByteArray();
    }

    public static String[] match(Pattern pattern, String string) {
        List<String> matchesList = new ArrayList<String>();

        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            matchesList.add(matcher.group(0));
        }

        return matchesList.toArray(new String[matchesList.size()]);
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
