package com.example.patterns.D_Factory.v4;

public class CheesePizza extends Pizza {

    private PizzaIngredientFactory pizzaIngredientFactory;

    public CheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    void prepare() {
        dough = pizzaIngredientFactory.getDough();
        sauce = pizzaIngredientFactory.getSauce();
        veggies = pizzaIngredientFactory.getVeggies();

        System.out.println("dough: " + dough);
        System.out.println("sauce: " + sauce);
        System.out.println("shrimp: " + shrimp);
        System.out.println("veggies: " + veggies);
    }
}
