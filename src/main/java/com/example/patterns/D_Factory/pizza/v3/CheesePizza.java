package com.example.patterns.D_Factory.pizza.v3;

public class CheesePizza extends Pizza {
    public CheesePizza() {
        name = "CheesePizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("Grated Reggiano Cheese");
    }
}
