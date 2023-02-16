package com.example.patterns.C_Decorator.v3;

public class Whip extends Decorator {

    public Whip(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public int cost() {
        return beverage.cost() + 3;
    }
}
