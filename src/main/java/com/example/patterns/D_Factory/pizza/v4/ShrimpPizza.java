package com.example.patterns.D_Factory.pizza.v4;

public class ShrimpPizza extends Pizza{

    PizzaIngredientFactory pizzaIngredientFactory;

    public ShrimpPizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    void prepare() {
        dough = pizzaIngredientFactory.getDough();
        sauce = pizzaIngredientFactory.getSauce();
        shrimp = pizzaIngredientFactory.getShrimp();

        System.out.println("dough: " + dough);
        System.out.println("sauce: " + sauce);
        System.out.println("shrimp: " + shrimp);
        System.out.println("veggies: " + veggies);
    }
}
