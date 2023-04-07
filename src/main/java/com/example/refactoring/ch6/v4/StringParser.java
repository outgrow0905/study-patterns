package com.example.refactoring.ch6.v4;

public class StringParser {
    Parser parser;
    String a;

    public StringParser(Parser parser) {
        this.parser = parser;
    }

    public Node createStringNode() {
        return parser.getDoSpecialThingOption().createStringNode(a);
//        NodeFactory nodeFactory = new NodeFactory();
//        return nodeFactory.createStringNode(parser.getDoSpecialThingOption().isDoingSpecialThing(), a);
    }
}
