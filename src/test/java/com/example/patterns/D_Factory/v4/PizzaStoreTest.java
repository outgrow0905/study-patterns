package com.example.patterns.D_Factory.v4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaStoreTest {

    @Test
    void orderPizza() {
        PizzaStore nyPizzaStore = new NYPizzaStore();
        Pizza cheesePizza = nyPizzaStore.orderPizza("cheese");
        Pizza shrimpPizza = nyPizzaStore.orderPizza("shrimp");
    }
}