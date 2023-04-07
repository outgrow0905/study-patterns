package com.example.refactoring.ch6.v5;

public class NodeFactory {
    private boolean doSpecialThing;

    public boolean isDoingSpecialThing() {
        return doSpecialThing;
    }

    public void setDoSpecialThing(boolean doSpecialThing) {
        this.doSpecialThing = doSpecialThing;
    }

    public Node createStringNode(String a) {
        if (doSpecialThing) {
            return new SpecialStringNode(new StringNode());
        }

        return new StringNode();
    }
}
