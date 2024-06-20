package com.example.patterns.D_Factory.v2;

import org.junit.jupiter.api.Test;

import com.example.patterns.D_Factory.pizza.v2.PizzaStore;
import com.example.patterns.D_Factory.pizza.v2.SimplePizzaFactory;

class PizzaStoreTest {
    @Test
    void orderPizza() {
        PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFactory());
        pizzaStore.orderPizza("cheese");
    }
}