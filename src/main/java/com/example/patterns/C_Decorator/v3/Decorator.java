package com.example.patterns.C_Decorator.v3;

public abstract class Decorator implements Beverage {

    protected Beverage beverage;
    protected Decorator(Beverage beverage) {
        this.beverage = beverage;
    }
}
