package com.example.patterns.C_Decorator.v2;

public class Beverage {
    protected String description;
    private boolean soybeanMilk;
    private boolean steamedMilk;
    private boolean whip;

    public String getDescription() {
        return description;
    }

    public int cost() {
        int cost = 0;
        cost = hasSoybeanMilk() ? cost + 10 : cost;
        cost = hasSteamedMilk() ? cost + 5 : cost;
        cost = hasWhip() ? cost + 3 : cost;
        return cost;
    }

    public void soybeanMilk() {
        this.soybeanMilk = true;
    }

    public void steamedMilk() {
        this.steamedMilk = true;
    }

    public void whip() {
        this.whip = true;
    }

    public boolean hasSoybeanMilk() {
        return soybeanMilk;
    }

    public boolean hasSteamedMilk() {
        return steamedMilk;
    }

    public boolean hasWhip() {
        return whip;
    }
}
