package com.example.patterns.D_Factory.v4;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough getDough() {
        return new NYStyleDough();
    }

    @Override
    public Sauce getSauce() {
        return new NYStyleSauce();
    }

    @Override
    public Veggie[] getVeggies() {
        return new Veggie[]{new Tomato(), new Olive()};
    }

    @Override
    public Shrimp getShrimp() {
        return new BlackShrimp();
    }
}
