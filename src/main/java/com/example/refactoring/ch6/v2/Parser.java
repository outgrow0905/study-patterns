package com.example.refactoring.ch6.v2;

public class Parser {
    private boolean doSpecialThing;

    public boolean isDoingSpecialThing() {
        return doSpecialThing;
    }

    public void setDoSpecialThing(boolean doSpecialThing) {
        this.doSpecialThing = doSpecialThing;
    }
}