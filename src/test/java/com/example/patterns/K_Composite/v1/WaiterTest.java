package com.example.patterns.K_Composite.v1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class WaiterTest {
    @Test
    void waiter() {
        Waiter waiter = new Waiter(
                Arrays.asList(new PancakeHouseMenu("Pancake House Menu", "Welcome"),
                        new SteakHouseMenu("Steak House Menu", "Welcome"),
                        new KodachayaMenu("Kodachaya Menu", "Welcome"))
        );
        waiter.printMenu();
    }
}