package com.example.patterns.D_Factory.v4;

public class NYPizzaStore extends PizzaStore{

    NYPizzaIngredientFactory factory = new NYPizzaIngredientFactory();

    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;

        if ("cheese".equals(type)) {
            pizza = new CheesePizza(factory);
        }

        if ("shrimp".equals(type)) {
            pizza = new ShrimpPizza(factory);
        }

        if (null == pizza) {
            throw new RuntimeException("We don't sell that type of pizza.");
        }

        return pizza;
    }
}
