package com.example.patterns.E_AbstractFactory.v1;

import org.junit.jupiter.api.Test;

class ComputerSellerTest {
    @Test
    void orderComputer() {
        ComputerSeller computerSeller = new ComputerSeller();
        computerSeller.orderComputer("samsung");
        computerSeller.orderComputer("lg");
    }
}