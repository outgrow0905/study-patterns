package com.example.patterns.C_Decorator.v3;

public class SteamedMilk extends Decorator {

    public SteamedMilk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", SteamedMilk";
    }

    @Override
    public int cost() {
        return beverage.cost() + 5;
    }
}
