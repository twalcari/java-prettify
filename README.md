# SyntaxHighlighterFX
[![Build Status](https://travis-ci.org/twalcari/syntaxhighlighterfx.svg?branch=trunk)](https://travis-ci.org/twalcari/syntaxhighlighterfx)

**SyntaxHighlighterFX** is capable of styling code in a `StyleClassedTextArea` from [RichTextFX](https://github.com/TomasMikula/RichTextFX).

The computation of the styles can be done asynchronously to ensure a smooth rendering of your application.

The latest releases of Java Prettify are:

* Latest Java 10 release: v3.0.0
* Latest Java 8 release: v2.0.1
* Latest Java 6 release: v1.2.2

## Distribution

Java Prettify is available on Maven Central. To include it in your project, use:
 
    <dependency>
        <groupId>com.github.twalcari</groupId>
        <artifactId>syntaxhighlighterfx</artifactId>
        <version>3.0.0</version>
    </dependency>


## Usage

```java
CodeArea codeArea = new CodeArea("<example>data</example> <!-- ... --->");

RTSyntaxHighlighter xmlCodeHighlighter = new RTSyntaxHighlighter(codeArea, "xml");
```

Please refer to [RTSyntaxHighlighterTest.java](https://github.com/twalcari/java-prettify/blob/trunk/src/test/java/com/github/twalcari/prettify/RTSyntaxHighlighterTest.java) for more information.


## History 

The syntax parser is  based on **Java Prettify**, which is a Java port of [Google Prettify](http://google-code-prettify.googlecode.com/), the current version ported is 4-Mar-2013. 
The copyright holder of the Google Prettify is Mike Samuel (mikesamuel@gmail.com). It is licensed under the [Apache license Version 2](http://www.opensource.org/licenses/Apache-2.0). 

The original work on this port was done by Chan Wai Shing (cws1989@gmail.com), and was published on [https://code.google.com/p/java-prettify/](https://code.google.com/p/java-prettify/).
This was then moved to GitHub, and made into a Maven-project by Thijs Walcarius.

Version 2.0.0 still used the name 'java-prettify', and added support for the RichTextFX-controls, which require Java 8.
Version 3.0.0 upgraded was renamed to 'SyntaxHighlighterFX' to better represent the goal of this library. It was modularized and edited to support Java 10. 

## License

This port is distributed under [Apache license Version 2](http://www.opensource.org/licenses/Apache-2.0).

