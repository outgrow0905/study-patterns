package com.example.patterns.D_Factory.v3;

import org.junit.jupiter.api.Test;

import com.example.patterns.D_Factory.pizza.v3.CommonPizzaStore;
import com.example.patterns.D_Factory.pizza.v3.PizzaStore;

class PizzaStoreTest {
    @Test
    void orderPizza() {
        PizzaStore pizzaStore = new CommonPizzaStore();
        pizzaStore.orderPizza("cheese");
    }
}