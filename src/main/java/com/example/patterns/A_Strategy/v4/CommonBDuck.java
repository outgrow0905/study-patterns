package com.example.patterns.A_Strategy.v4;

public class CommonBDuck extends Duck {
    @Override
    public void display() {
        System.out.println("common B duck display!");
    }

    public CommonBDuck(Soundable soundable, Flyable flyable) {
        super(soundable, flyable);
    }
}
