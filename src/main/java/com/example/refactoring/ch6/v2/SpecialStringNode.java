package com.example.refactoring.ch6.v2;

public class SpecialStringNode implements Node {
    Node node;

    public SpecialStringNode(Node node) {
        this.node = node;
    }
}
