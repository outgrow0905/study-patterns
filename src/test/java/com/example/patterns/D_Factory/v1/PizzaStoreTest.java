package com.example.patterns.D_Factory.v1;

import org.junit.jupiter.api.Test;

import com.example.patterns.D_Factory.pizza.v1.PizzaStore;

class PizzaStoreTest {
    @Test
    void orderPizza() {
        PizzaStore pizzaStore = new PizzaStore();
        pizzaStore.orderPizza("cheese");
    }
}