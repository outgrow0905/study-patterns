package com.example.patterns.A_Strategy.v3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuckTest {

    @Test
    void rubberDuckCannotFlyTest() {
        Duck rubberDuck = new RubberDuck();
        rubberDuck.setFlyable(new CannotFly());
        rubberDuck.setSoundable(new CommonDuckSound());

        rubberDuck.fly();
        rubberDuck.sound();
    }
}