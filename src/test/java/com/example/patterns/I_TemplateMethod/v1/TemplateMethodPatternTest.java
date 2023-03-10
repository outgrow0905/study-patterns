package com.example.patterns.I_TemplateMethod.v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemplateMethodPatternTest {
    @Test
    void templateMethodPattern() {
        Coffee coffee = new Coffee();
        Tea tea = new Tea();

        coffee.prepare();
        tea.prepare();
    }
}