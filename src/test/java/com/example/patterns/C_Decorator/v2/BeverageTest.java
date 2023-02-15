package com.example.patterns.C_Decorator.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BeverageTest {
    @Test
    void cost() {
        Beverage houseBlend = new HouseBlend();
        houseBlend.soybeanMilk();
        houseBlend.steamedMilk();
        houseBlend.whip();

        Beverage darkRoast = new DarkRoast();
        darkRoast.soybeanMilk();
        darkRoast.steamedMilk();
        darkRoast.whip();

        Beverage espresso = new Espresso();
        espresso.soybeanMilk();
        espresso.steamedMilk();
        espresso.whip();

        assertEquals(118, houseBlend.cost());
        assertEquals(128, darkRoast.cost());
        assertEquals(68, espresso.cost());
    }
}