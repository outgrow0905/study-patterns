package com.example.patterns.D_Factory.pizza.v1;

public class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza = null;

        if ("cheese".equals(type)) {
            pizza = new CheesePizza();
        }
        if ("chicago".equals(type)) {
            pizza = new ChicagoPizza();
        }

        if (null == pizza) {
            throw new RuntimeException("We don't have that type of pizza.");
        }

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
