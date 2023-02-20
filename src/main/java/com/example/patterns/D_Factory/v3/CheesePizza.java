package com.example.patterns.D_Factory.v3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheesePizza extends Pizza {
    public CheesePizza() {
        name = "CheesePizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("Grated Reggiano Cheese");
    }
}
