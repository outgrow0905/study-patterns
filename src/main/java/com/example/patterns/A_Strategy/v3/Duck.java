package com.example.patterns.A_Strategy.v3;

public abstract class Duck {

    private Soundable soundable;
    private Flyable flyable;


    public void sound() {
        soundable.sound();
    }

    public void fly() {
        flyable.fly();
    }

    public void setSoundable(Soundable soundable) {
        this.soundable = soundable;
    }

    public void setFlyable(Flyable flyable) {
        this.flyable = flyable;
    }

    public abstract void display();
}
