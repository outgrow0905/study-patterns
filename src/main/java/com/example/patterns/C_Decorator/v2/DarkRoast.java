package com.example.patterns.C_Decorator.v2;

import com.example.patterns.C_Decorator.v2.Beverage;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "This is DarkRoast.";
    }

    @Override
    public int cost() {
        return super.cost() + 110;
    }
}
