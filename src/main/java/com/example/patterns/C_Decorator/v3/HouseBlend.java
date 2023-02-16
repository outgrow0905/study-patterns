package com.example.patterns.C_Decorator.v3;

public class HouseBlend implements Beverage {

    private String description = "This is HouseBlend.";

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public int cost() {
        return 100;
    }

}
