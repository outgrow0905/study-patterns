package com.example.patterns.C_Decorator.v2;

import com.example.patterns.C_Decorator.v2.Beverage;

public class Espresso extends Beverage {

    public Espresso() {
        description = "This is Espresso.";
    }

    @Override
    public int cost() {
        return super.cost() + 50;
    }
}
