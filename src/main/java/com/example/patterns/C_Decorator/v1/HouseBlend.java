package com.example.patterns.C_Decorator.v1;

public class HouseBlend extends Beverage{

    public HouseBlend() {
        description = "This is HouseBlend.";
    }

    @Override
    int cost() {
        return 100;
    }
}
