package com.example.patterns.E_AbstractFactory.v3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerSellerTest {
    @Test
    void orderComputer() {
        ComputerSeller samsungComputerSeller = new ComputerSeller(new SamsungComputerComponentFactory());
        ComputerSeller lgComputerSeller = new ComputerSeller(new LGComputerComponentFactory());

        samsungComputerSeller.orderComputer();
        lgComputerSeller.orderComputer();
    }
}