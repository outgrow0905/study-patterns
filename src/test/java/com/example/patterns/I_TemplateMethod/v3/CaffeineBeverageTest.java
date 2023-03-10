package com.example.patterns.I_TemplateMethod.v3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaffeineBeverageTest {
    @Test
    void templateMethodPattern() {
        CaffeineBeverage coffee = new Coffee();
        coffee.prepare();
    }
}