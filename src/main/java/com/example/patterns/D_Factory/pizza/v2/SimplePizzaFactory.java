package com.example.patterns.D_Factory.pizza.v2;

public class SimplePizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if ("cheese".equals(type)) {
            pizza = new CheesePizza();
        }
        if ("chicago".equals(type)) {
            pizza = new MozzarellaPizza();
        }

        if (null == pizza) {
            throw new RuntimeException("We don't create that type of pizza.");
        }

        return pizza;
    }
}
