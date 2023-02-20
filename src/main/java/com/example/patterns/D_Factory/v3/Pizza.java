package com.example.patterns.D_Factory.v3;

import java.util.ArrayList;

public abstract class Pizza {
    String name;
    String dough;
    String sauce;
    ArrayList<String> toppings = new ArrayList<>();

    void prepare() {
        System.out.println("preparing " + name);
        System.out.println("preparing dough: " + dough);
        System.out.println("preparing sauce: " + sauce);
        System.out.println("preparing toppings: " + toppings);
    }
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
