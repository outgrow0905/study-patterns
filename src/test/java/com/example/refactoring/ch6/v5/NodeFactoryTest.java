package com.example.refactoring.ch6.v5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeFactoryTest {
    @Test
    void createNode() {
        NodeFactory nodeFactory = new NodeFactory();
        nodeFactory.setDoSpecialThing(false);
        Parser parser = new Parser();
        parser.setNodeFactory(nodeFactory);
        StringParser stringParser = new StringParser(parser);
        Node stringNode = stringParser.createStringNode();
        assertTrue(stringNode instanceof StringNode);

        nodeFactory.setDoSpecialThing(true);
        Node specialStringNode = stringParser.createStringNode();
        assertTrue(specialStringNode instanceof SpecialStringNode);
    }
}