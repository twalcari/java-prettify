#Java Prettify
[![Build Status](https://travis-ci.org/twalcari/java-prettify.svg?branch=trunk)](https://travis-ci.org/twalcari/java-prettify)

**Java Prettify** is a Java port of [Google Prettify](http://google-code-prettify.googlecode.com/), the current version ported is 4-Mar-2013. 
The copyright holder of the Google Prettify is Mike Samuel (mikesamuel@gmail.com). It is licensed under the [Apache license Version 2](http://www.opensource.org/licenses/Apache-2.0). 

The original work on this port was done by Chan Wai Shing (cws1989@gmail.com), and was published on [https://code.google.com/p/java-prettify/](https://code.google.com/p/java-prettify/).
This was then moved to GitHub, and made into a Maven-project by Thijs Walcarius.

Version 2.0 adds support for the [RichTextFX](https://github.com/TomasMikula/RichTextFX)-controls, which require Java 8.

The latest releases of Java Prettify are:

* Latest Java 8 release: v2.0.0
* Latest Java 6 release: v1.2.2

##Distribution

Java Prettify is available on Maven Central. To include it in your project, use:
 
    <dependency>
        <groupId>com.github.twalcari</groupId>
        <artifactId>java-prettify</artifactId>
        <version>2.0.0</version>
    </dependency>


##Usage

```java
CodeArea codeArea = new CodeArea("<example>data</example> <!-- ... --->");

RTSyntaxHighlighter xmlCodeHighlighter = new RTSyntaxHighlighter(codeArea, "xml");
```

Please refer to [RTSyntaxHighlighterTest.java](https://github.com/twalcari/java-prettify/blob/trunk/src/test/java/com/github/twalcari/prettify/RTSyntaxHighlighterTest.java) for more information.

##License

This port is distributed under [Apache license Version 2](http://www.opensource.org/licenses/Apache-2.0).

