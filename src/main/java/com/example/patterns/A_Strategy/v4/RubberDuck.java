package com.example.patterns.A_Strategy.v4;

public class RubberDuck extends Duck {
    @Override
    public void display() {
        System.out.println("rubber duck display!");
    }

    public RubberDuck(Soundable soundable, Flyable flyable) {
        super(soundable, flyable);
    }
}
