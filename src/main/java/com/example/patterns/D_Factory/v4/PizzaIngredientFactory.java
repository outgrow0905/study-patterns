package com.example.patterns.D_Factory.v4;

public interface PizzaIngredientFactory {
    Dough getDough();
    Sauce getSauce();
    Veggie[] getVeggies();
    Shrimp getShrimp();
}
