package com.example.patterns.A_Strategy.v4;

import org.junit.jupiter.api.Test;

class DuckTest {
    @Test
    void rubberDuckCannotFlyTest() {
        Duck rubberDuck = new RubberDuck(new CommonDuckSound(), new CannotFly());

        rubberDuck.fly();
        rubberDuck.sound();
    }
}