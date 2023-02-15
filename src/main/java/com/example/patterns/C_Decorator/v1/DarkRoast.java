package com.example.patterns.C_Decorator.v1;

public class DarkRoast extends Beverage{

    public DarkRoast() {
        description = "This is DarkRoast.";
    }

    @Override
    int cost() {
        return 110;
    }
}
