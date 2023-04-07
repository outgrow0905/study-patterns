package com.example.refactoring.ch6.v5;

public class StringParser {
    Parser parser;
    String a;

    public StringParser(Parser parser) {
        this.parser = parser;
    }

    public Node createStringNode() {
        return parser.getNodeFactory().createStringNode(a);
    }
}
