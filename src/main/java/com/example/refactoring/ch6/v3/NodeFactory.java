package com.example.refactoring.ch6.v3;

public class NodeFactory {
    public Node createStringNode(boolean isDoingSpecialThing, String a) {
        if (isDoingSpecialThing) {
            return new SpecialStringNode(new StringNode());
        }

        return new StringNode();
    }
}
