package com.example.patterns.E_AbstractFactory.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerSellerTest {
    @Test
    void orderComputer() {
        ComputerSeller samsungComputerSeller = new SamsungComputerSeller();
        ComputerSeller lgComputerSeller = new LGComputerSeller();

        samsungComputerSeller.orderComputer();
        lgComputerSeller.orderComputer();
    }
}