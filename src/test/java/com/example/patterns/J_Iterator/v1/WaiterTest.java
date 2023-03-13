package com.example.patterns.J_Iterator.v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaiterTest {
    @Test
    void waiter() {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        SteakHouseMenu steakHouseMenu = new SteakHouseMenu();
        Waiter waiter = new Waiter(pancakeHouseMenu, steakHouseMenu);

        waiter.printMenu();
    }
}