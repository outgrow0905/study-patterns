package com.example.patterns.C_Decorator.v1;

public class Espresso extends Beverage{

    public Espresso() {
        description = "This is Espresso.";
    }

    @Override
    int cost() {
        return 50;
    }
}
