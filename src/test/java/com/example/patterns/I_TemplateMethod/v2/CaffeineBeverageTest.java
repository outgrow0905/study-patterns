package com.example.patterns.I_TemplateMethod.v2;

import org.junit.jupiter.api.Test;

class CaffeineBeverageTest {
    @Test
    void templateMethodPattern() {
        CaffeineBeverage coffee = new Coffee();
        CaffeineBeverage tea = new Tea();

        coffee.prepare();
        tea.prepare();
    }
}