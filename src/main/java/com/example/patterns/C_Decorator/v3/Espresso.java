package com.example.patterns.C_Decorator.v3;

public class Espresso implements Beverage{
    private String description = "This is Espresso.";

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public int cost() {
        return 50;
    }
}
