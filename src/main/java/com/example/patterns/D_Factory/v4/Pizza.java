package com.example.patterns.D_Factory.v4;

public abstract class Pizza {
    String name;
    Dough dough;
    Sauce sauce;
    Shrimp shrimp;
    Veggie[] veggies;

    abstract void prepare();

    void bake() {
        System.out.println("bake for 25 minutes at 350F");
    }
    void cut() {
        System.out.println("cut the pizza into diagonal slices");
    }
    void box() {
        System.out.println("place the pizza in official pizza store box");
    }
}
