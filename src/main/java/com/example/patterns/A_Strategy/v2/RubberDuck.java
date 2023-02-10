package com.example.patterns.A_Strategy.v2;

public class RubberDuck extends Duck{
    @Override
    public void display() {
        System.out.println("rubber duck display!");
    }

    @Override
    public void fly() {
        System.out.println("can't fly!");
    }
}
