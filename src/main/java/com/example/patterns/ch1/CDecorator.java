package com.example.patterns.ch1;

public class CDecorator extends C {
    private C c;

    public CDecorator(C c) {
        this.c = c;
    }
}
