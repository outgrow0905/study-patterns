package com.example.patterns.A_Strategy.v3;

public class CannotFly implements Flyable{
    @Override
    public void fly() {
        System.out.println("can't fly!");
    }
}
