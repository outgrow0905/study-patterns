package com.example.patterns.C_Decorator.v3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeverageTest {
    @Test
    void cost() {
        Beverage darkRoastWithSteamedMilkAndWhipAndDoubleSoybeanMilk =
                new SoybeanMilk(new SoybeanMilk(new Whip(new SteamedMilk(new DarkRoast()))));

        assertEquals(110 + 5 + 3 + 10 + 10, darkRoastWithSteamedMilkAndWhipAndDoubleSoybeanMilk.cost());
    }
}