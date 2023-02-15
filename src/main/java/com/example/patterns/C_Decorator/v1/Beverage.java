package com.example.patterns.C_Decorator.v1;

public abstract class Beverage {
    protected String description;

    public String getDescription() {
        return description;
    }

    abstract int cost();
}
