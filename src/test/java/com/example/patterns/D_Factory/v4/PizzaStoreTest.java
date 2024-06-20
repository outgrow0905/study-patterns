package com.example.patterns.D_Factory.v4;

import org.junit.jupiter.api.Test;

import com.example.patterns.D_Factory.pizza.v4.NYPizzaStore;
import com.example.patterns.D_Factory.pizza.v4.Pizza;
import com.example.patterns.D_Factory.pizza.v4.PizzaStore;

class PizzaStoreTest {

    @Test
    void orderPizza() {
        PizzaStore nyPizzaStore = new NYPizzaStore();
        Pizza cheesePizza = nyPizzaStore.orderPizza("cheese");
        Pizza shrimpPizza = nyPizzaStore.orderPizza("shrimp");
    }
}