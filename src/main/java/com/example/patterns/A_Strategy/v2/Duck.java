package com.example.patterns.A_Strategy.v2;

public abstract class Duck {
    public void sound() {
        System.out.println("duck! duck!");
    }

    public void fly() {
        System.out.println("duck fly! duck fly!");
    }

    public abstract void display();
}
