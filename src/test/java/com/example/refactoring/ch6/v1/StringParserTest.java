package com.example.refactoring.ch6.v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringParserTest {
    @Test
    void createNode() {
        // stringNode
        Parser parser = new Parser();
        parser.setDoSpecialThing(false);
        StringParser stringParser = new StringParser(parser);
        Node stringNode = stringParser.createStringNode();
        assertTrue(stringNode instanceof StringNode);

        // specialStringNode
        parser.setDoSpecialThing(true);
        Node specialStringNode = stringParser.createStringNode();
        assertTrue(specialStringNode instanceof SpecialStringNode);
    }
}