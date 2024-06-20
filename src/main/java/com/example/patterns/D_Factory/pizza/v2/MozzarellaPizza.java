package com.example.patterns.D_Factory.pizza.v2;

public class MozzarellaPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("prepare MozzarellaPizza.");
    }

    @Override
    public void bake() {
        System.out.println("bake MozzarellaPizza.");
    }

    @Override
    public void cut() {
        System.out.println("cut MozzarellaPizza.");
    }

    @Override
    public void box() {
        System.out.println("box MozzarellaPizza.");
    }
}
