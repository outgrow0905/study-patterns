package com.example.patterns.D_Factory.v1;

public class ChicagoPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("prepare ChicagoPizza.");
    }

    @Override
    public void bake() {
        System.out.println("bake ChicagoPizza.");
    }

    @Override
    public void cut() {
        System.out.println("cut ChicagoPizza.");
    }

    @Override
    public void box() {
        System.out.println("box ChicagoPizza.");
    }
}
