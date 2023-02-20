package com.example.patterns.D_Factory.v3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaStoreTest {
    @Test
    void orderPizza() {
        PizzaStore pizzaStore = new CommonPizzaStore();
        pizzaStore.orderPizza("cheese");
    }
}