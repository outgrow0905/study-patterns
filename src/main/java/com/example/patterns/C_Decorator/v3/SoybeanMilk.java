package com.example.patterns.C_Decorator.v3;

public class SoybeanMilk extends Decorator {

    public SoybeanMilk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", SoybeanMilk";
    }

    @Override
    public int cost() {
        return beverage.cost() + 10;
    }
}
