package com.example.patterns.D_Factory.v3;

public class CommonPizzaStore extends PizzaStore{
    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if ("cheese".equals(type)) {
            pizza = new CheesePizza();
        }
        if ("mozzarella".equals(type)) {
            pizza = new MozzarellaPizza();
        }

        if (null == pizza) {
            throw new RuntimeException("We don't sell that type of pizza.");
        }

        return pizza;
    }
}
