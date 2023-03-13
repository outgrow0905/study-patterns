package com.example.patterns.J_Iterator.v5;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WaiterTest {
    @Test
    void waiter() {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        SteakHouseMenu steakHouseMenu = new SteakHouseMenu();
        Waiter waiter = new Waiter(new ArrayList<>(List.of(pancakeHouseMenu, steakHouseMenu)));

        waiter.printMenu();
    }
}