package com.example.refactoring.ch6.v5;

public class Parser {
    private NodeFactory nodeFactory;

    public NodeFactory getNodeFactory() {
        return nodeFactory;
    }

    public void setNodeFactory(NodeFactory nodeFactory) {
        this.nodeFactory = nodeFactory;
    }
}