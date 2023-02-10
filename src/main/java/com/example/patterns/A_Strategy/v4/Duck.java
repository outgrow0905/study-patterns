package com.example.patterns.A_Strategy.v4;

public abstract class Duck {

    private Soundable soundable;
    private Flyable flyable;


    public void sound() {
        soundable.sound();
    }

    public void fly() {
        flyable.fly();
    }

    public Duck(Soundable soundable, Flyable flyable) {
        this.soundable = soundable;
        this.flyable = flyable;
    }
    public abstract void display();
}
