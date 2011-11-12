// Copyright (C) 2006 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package prettify;

import java.util.Map;
import java.util.TreeMap;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PrettifyTest {

    protected final String packagePath = "test/" + this.getClass().getCanonicalName().replace('.', '/') + "/";

    public PrettifyTest() {
    }

    protected static String getClassName() {
        return new Object() {
        }.getClass().getEnclosingClass().getName();
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("***** " + getClassName() + " *****");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("******************************\r\n");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test() throws IOException {
        System.out.println("+++++ test +++++");

        Prettify prettify = new Prettify();
        Job job;
        String source;
        List<Object> decorations, compare;

        source = new String(readFile(new File(packagePath + "source/bash.txt")));
        job = new Job();
        job.setBasePos(0);
        job.setSourceCode(source);
        prettify.langHandlerForExtension(null, source).decorate(job);
        decorations = job.getDecorations();
        compare = readResult(new String(readFile(new File(packagePath + "result/bash.txt"))));
        assertArrayEquals("bash", decorations.toArray(), compare.toArray());

        source = new String(readFile(new File(packagePath + "source/bash_lang.txt")));
        job = new Job();
        job.setBasePos(0);
        job.setSourceCode(source);
        prettify.langHandlerForExtension("sh", source).decorate(job);
        decorations = removeNewLine(job.getDecorations(), source);
        compare = readResult(new String(readFile(new File(packagePath + "result/bash_lang.txt"))), true);
        assertArrayEquals("bash_lang", decorations.toArray(), compare.toArray());

        source = new String(readFile(new File(packagePath + "source/java.txt")));
        job = new Job();
        job.setBasePos(0);
        job.setSourceCode(source);
        prettify.langHandlerForExtension(null, source).decorate(job);
        decorations = job.getDecorations();
        compare = readResult(new String(readFile(new File(packagePath + "result/java.txt"))));
        assertArrayEquals("java", decorations.toArray(), compare.toArray());


        source = new String(readFile(new File(packagePath + "source/java_lang.txt")));
        job = new Job();
        job.setBasePos(0);
        job.setSourceCode(source);
        prettify.langHandlerForExtension("java", source).decorate(job);
        decorations = removeNewLine(job.getDecorations(), source);
        compare = readResult(new String(readFile(new File(packagePath + "result/java_lang.txt"))), true);
        assertArrayEquals("java_lang", decorations.toArray(), compare.toArray());

        source = new String(readFile(new File(packagePath + "source/C.txt")));
        job = new Job();
        job.setBasePos(0);
        job.setSourceCode(source);
        prettify.langHandlerForExtension(null, source).decorate(job);
        decorations = job.getDecorations();
        compare = readResult(new String(readFile(new File(packagePath + "result/C.txt"))));
        assertArrayEquals("C", decorations.toArray(), compare.toArray());


        source = new String(readFile(new File(packagePath + "source/C_lang.txt")));
        job = new Job();
        job.setBasePos(0);
        job.setSourceCode(source);
        prettify.langHandlerForExtension("c", source).decorate(job);
        decorations = removeNewLine(job.getDecorations(), source);
        compare = readResult(new String(readFile(new File(packagePath + "result/C_lang.txt"))), true);
        assertArrayEquals("C_lang", decorations.toArray(), compare.toArray());

        source = new String(readFile(new File(packagePath + "source/Cpp.txt")));
        job = new Job();
        job.setBasePos(0);
        job.setSourceCode(source);
        prettify.langHandlerForExtension(null, source).decorate(job);
        decorations = job.getDecorations();
        compare = readResult(new String(readFile(new File(packagePath + "result/Cpp.txt"))));
        assertArrayEquals("Cpp", decorations.toArray(), compare.toArray());

        source = new String(readFile(new File(packagePath + "source/Cpp_lang.txt")));
        job = new Job();
        job.setBasePos(0);
        job.setSourceCode(source);
        prettify.langHandlerForExtension("cpp", source).decorate(job);
        decorations = removeNewLine(job.getDecorations(), source);
        compare = readResult(new String(readFile(new File(packagePath + "result/Cpp_lang.txt"))), true);
        assertArrayEquals("Cpp_lang", decorations.toArray(), compare.toArray());

        source = new String(readFile(new File(packagePath + "source/javascript.txt")));
        job = new Job();
        job.setBasePos(0);
        job.setSourceCode(source);
        prettify.langHandlerForExtension(null, source).decorate(job);
        decorations = job.getDecorations();
        compare = readResult(new String(readFile(new File(packagePath + "result/javascript.txt"))));
        assertArrayEquals("javascript", decorations.toArray(), compare.toArray());

        source = new String(readFile(new File(packagePath + "source/perl.txt")));
        job = new Job();
        job.setBasePos(0);
        job.setSourceCode(source);
        prettify.langHandlerForExtension(null, source).decorate(job);
        decorations = job.getDecorations();
        compare = readResult(new String(readFile(new File(packagePath + "result/perl.txt"))));
        assertArrayEquals("perl", decorations.toArray(), compare.toArray());


        source = new String(readFile(new File(packagePath + "source/python.txt")));
        job = new Job();
        job.setBasePos(0);
        job.setSourceCode(source);
        prettify.langHandlerForExtension(null, source).decorate(job);
        decorations = job.getDecorations();
        compare = readResult(new String(readFile(new File(packagePath + "result/python.txt"))));
        assertArrayEquals("python", decorations.toArray(), compare.toArray());

        source = new String(readFile(new File(packagePath + "source/python_lang.txt")));
        job = new Job();
        job.setBasePos(0);
        job.setSourceCode(source);
        prettify.langHandlerForExtension("py", source).decorate(job);
        decorations = removeNewLine(job.getDecorations(), source);
        compare = readResult(new String(readFile(new File(packagePath + "result/python_lang.txt"))), true);
        assertArrayEquals("python_lang", decorations.toArray(), compare.toArray());

    }

    /**
     * Read the whole file and return the content in byte array.
     * @param file the file to read
     * @return the content of the file in byte array
     * @throws IOException error occurred when reading the content from the file
     */
    public static byte[] readFile(File file) throws IOException {
        if (file == null) {
            throw new NullPointerException("argument 'file' cannot be null");
        }

        long fileLength = file.length();
        byte[] content = new byte[(int) fileLength];

        FileInputStream fin = null;
        try {
            fin = new FileInputStream(file);

            int byteRead = 0, cumulateByteRead = 0;
            while ((byteRead = fin.read(content, cumulateByteRead, content.length - cumulateByteRead)) != -1) {
                cumulateByteRead += byteRead;
                if (cumulateByteRead >= fileLength) {
                    break;
                }
            }

            if (cumulateByteRead != fileLength) {
                throw new IOException("The total number of bytes read does not match the file size. Actual file size: " + fileLength + ", bytes read: " + cumulateByteRead + ", path: " + file.getAbsolutePath());
            }
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException ex) {
                }
            }
        }

        return content;
    }

    public static List<Object> removeNewLine(List<Object> decorations, String source) {
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("\r\n");
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()) {
            matcher.appendReplacement(sb, "");
            int posStart = sb.length();
            ListIterator<Object> iterator = decorations.listIterator();
            while (iterator.hasNext()) {
                Integer pos = (Integer) iterator.next();
                if (pos > posStart) {
                    iterator.set(pos - 2);
                }
                iterator.next();
            }
        }
//        matcher.appendTail(sb);

        // use TreeMap to remove entrys with same pos
        Map<Integer, Object> orderedMap = new TreeMap<Integer, Object>();
        for (int i = 0, iEnd = decorations.size(); i < iEnd; i++) {
            orderedMap.put((Integer) decorations.get(i), decorations.get(i + 1));
            i++;
        }
        // remove adjacent style
        List<Object> returnList = new ArrayList<Object>(orderedMap.size() + 1);
        String previousStyle = null;
        for (Integer _pos : orderedMap.keySet()) {
            if (previousStyle != null && previousStyle.equals(orderedMap.get(_pos))) {
                continue;
            }
            returnList.add(_pos);
            returnList.add(orderedMap.get(_pos));
            previousStyle = (String) orderedMap.get(_pos);
        }

        return returnList;
    }

    public static List<Object> readResult(String result) {
        return readResult(result, false);
    }

    public static List<Object> readResult(String result, boolean removeNewLine) {
        List<Object> returnList = new ArrayList<Object>();

        int count = 0;

        if (removeNewLine) {
            while (true) {
                StringBuffer sb = new StringBuffer();
                result = result.replaceAll("[\r\n]", "");
                Pattern pattern = Pattern.compile("(`[A-Z]{3})([^`]+?)`END\\1([^`]+?)`END", Pattern.MULTILINE | Pattern.DOTALL);
                Matcher matcher = pattern.matcher(result);
                boolean found = false;
                while (matcher.find()) {
                    matcher.appendReplacement(sb, "");
                    sb.append(matcher.group(1)).append(matcher.group(2)).append(matcher.group(3)).append("`END");
                    found = true;
                }
                matcher.appendTail(sb);
                result = sb.toString();
                if (!found) {
                    break;
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("`([A-Z]{3})([^`]*?)`END", Pattern.MULTILINE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(result);
        while (matcher.find()) {
            matcher.appendReplacement(sb, "");
            sb.append(matcher.group(2));

            returnList.add(count);
            returnList.add(matcher.group(1).toLowerCase());
            count += matcher.group(2).length();
        }
        matcher.appendTail(sb);
        String plainCode = sb.toString();

        if (removeNewLine) {
            // use TreeMap to remove entrys with same pos
            Map<Integer, Object> orderedMap = new TreeMap<Integer, Object>();
            for (int i = 0, iEnd = returnList.size(); i < iEnd; i++) {
                orderedMap.put((Integer) returnList.get(i), returnList.get(i + 1));
                i++;
            }
            // remove adjacent style
            List<Object> _returnList = new ArrayList<Object>(orderedMap.size() + 1);
            String previousStyle = null;
            for (Integer _pos : orderedMap.keySet()) {
                if (previousStyle != null && previousStyle.equals(orderedMap.get(_pos))) {
                    continue;
                }
                _returnList.add(_pos);
                _returnList.add(orderedMap.get(_pos));
                previousStyle = (String) orderedMap.get(_pos);
            }
            returnList = _returnList;
        }

//        System.out.println(plainCode);
        for (int i = 0, iEnd = returnList.size(); i < iEnd; i++) {
            int end = i + 2 < iEnd ? (Integer) returnList.get(i + 2) : plainCode.length();
//            System.out.println(returnList.get(i) + ": " + returnList.get(i + 1) + ": " + plainCode.substring((Integer) returnList.get(i), end));
            i++;
        }

        return returnList;
    }
}
