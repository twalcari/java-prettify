/**
 * This is part of the Java SyntaxHighlighter.
 * 
 * It is distributed under MIT license. See the file 'readme.txt' for
 * information on usage and redistribution of this file, and for a
 * DISCLAIMER OF ALL WARRANTIES.
 * 
 * @author Chan Wai Shing <cws1989@gmail.com>
 */
package prettify.example;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import prettify.SyntaxHighlighter;
import prettify.theme.ThemeDefault;

/**
 * Usage example. This will just cover some of the functions. To know other available functions, please read the JavaDoc.
 * @author Chan Wai Shing <cws1989@gmail.com>
 */
public class Example {

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
            in = Example.class.getResourceAsStream(path);
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

    public static void main(String[] args) {
        // set look & feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            Logger.getLogger(Example.class.getName()).log(Level.INFO, "Failed to set system look and feel.", ex);
        }

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    // timer start
                    long start, end;
                    start = System.currentTimeMillis();

                    // use XML (for HTML) brush and RDark theme
                    SyntaxHighlighter highlighter = new SyntaxHighlighter(new ThemeDefault());
                    // set the line number count from 10 instead of 1
                    highlighter.setFirstLine(10);
                    // set to highlight line 13, 27, 28, 38, 42, 43 and 53
                    highlighter.setHighlightedLineList(Arrays.asList(13, 27, 28, 38, 42, 43, 53));
                    // set the content of the script, the example.html is located in the jar: /syntaxhighlighter/example/example.html
                    highlighter.setContent(new String(readResourceFile("/prettify/example/example.html")));

                    // timer end
                    end = System.currentTimeMillis();
                    System.out.println("time elapsed: " + (end - start) + "ms");

                    // initiate a frame and display
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    // SyntaxHighlighter is actually a JScrollPane
                    frame.setContentPane(highlighter);
                    frame.setLocationByPlatform(true);
                    frame.pack();
                    frame.setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Example.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
