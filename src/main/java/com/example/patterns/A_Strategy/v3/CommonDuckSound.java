package com.example.patterns.A_Strategy.v3;

public class CommonDuckSound implements Soundable{
    @Override
    public void sound() {
        System.out.println("duck! duck!");
    }
}
