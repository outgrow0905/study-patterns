package com.example.refactoring.ch6.v3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeFactoryTest {
    @Test
    void createNode() {
        DoSpecialThingOption option = new DoSpecialThingOption();
        option.setDoSpecialThing(false);
        Parser parser = new Parser();
        parser.setDoSpecialThingOption(option);
        StringParser stringParser = new StringParser(parser);
        Node stringNode = stringParser.createStringNode();
        assertTrue(stringNode instanceof  StringNode);

        option.setDoSpecialThing(true);
        Node specialStringNode = stringParser.createStringNode();
        assertTrue(specialStringNode instanceof SpecialStringNode);
    }
}