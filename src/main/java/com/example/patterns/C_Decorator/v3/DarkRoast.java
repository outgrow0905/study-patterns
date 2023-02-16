package com.example.patterns.C_Decorator.v3;

public class DarkRoast implements Beverage{
    private String description = "This is DarkRoast.";

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public int cost() {
        return 110;
    }
}
