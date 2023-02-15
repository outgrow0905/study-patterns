package com.example.patterns.C_Decorator.v2;

import com.example.patterns.C_Decorator.v2.Beverage;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "This is HouseBlend.";
    }

    @Override
    public int cost() {
        return super.cost() + 100;
    }
}
