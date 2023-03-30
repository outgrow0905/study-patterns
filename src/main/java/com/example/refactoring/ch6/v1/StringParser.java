package com.example.refactoring.ch6.v1;

public class StringParser {
    Parser parser;

    public StringParser(Parser parser) {
        this.parser = parser;
    }

    public Node createStringNode() {
        return StringNode.createStringNode(parser.isDoingSpecialThing());
    }
}
