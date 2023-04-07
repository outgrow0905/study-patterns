package com.example.refactoring.ch6.v3;

public class StringParser {
    Parser parser;
    String a;

    public StringParser(Parser parser) {
        this.parser = parser;
    }

    public Node createStringNode() {
        NodeFactory nodeFactory = new NodeFactory();
        return nodeFactory.createStringNode(parser.getDoSpecialThingOption().isDoingSpecialThing(), a);
//        return nodeFactory.createStringNode(parser.isDoingSpecialThing(), a);
    }
}
