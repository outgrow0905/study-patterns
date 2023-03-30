package com.example.refactoring.ch6.v1;

public class StringNode implements Node {
    public static Node createStringNode(boolean isDoSpecialThing) {
        if (isDoSpecialThing) {
            return new SpecialStringNode(new StringNode());
        }

        return new StringNode();
    }
}
