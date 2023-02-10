package com.example.patterns.A_Strategy.v3;

public class CommonDuckFly implements Flyable{
    @Override
    public void fly() {
        System.out.println("duck fly! duck fly!");
    }
}
