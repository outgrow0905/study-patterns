package com.example.patterns.A_Strategy.v4;

public class CommonADuck extends Duck {
    @Override
    public void display() {
        System.out.println("common A duck display!");
    }

    public CommonADuck(Soundable soundable, Flyable flyable) {
        super(soundable, flyable);
    }
}
