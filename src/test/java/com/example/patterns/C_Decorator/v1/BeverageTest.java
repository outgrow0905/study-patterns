package com.example.patterns.C_Decorator.v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeverageTest {
    @Test
    void getDescription() {
        Beverage houseBlend = new HouseBlend();
        Beverage darkRoast = new DarkRoast();
        Beverage espresso = new Espresso();

        assertEquals("This is HouseBlend.", houseBlend.getDescription());
        assertEquals("This is DarkRoast.", darkRoast.getDescription());
        assertEquals("This is Espresso.", espresso.getDescription());
    }

    @Test
    void cost() {
        Beverage houseBlend = new HouseBlend();
        Beverage darkRoast = new DarkRoast();
        Beverage espresso = new Espresso();

        assertEquals(100, houseBlend.cost());
        assertEquals(110, darkRoast.cost());
        assertEquals(50, espresso.cost());
    }
}