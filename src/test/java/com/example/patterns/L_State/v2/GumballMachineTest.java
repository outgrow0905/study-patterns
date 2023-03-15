package com.example.patterns.L_State.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GumballMachineTest {
    @Test
    void gumballMachine() {
        GumballMachine gumballMachine = new GumballMachine(5);

        gumballMachine.insertCoin();
        gumballMachine.turnLever();

        System.out.println("====================");

        gumballMachine.insertCoin();
        gumballMachine.ejectCoin();
        gumballMachine.turnLever(); // fail

        System.out.println("====================");

        gumballMachine.insertCoin();
        gumballMachine.turnLever();
        gumballMachine.insertCoin();
        gumballMachine.turnLever();
        gumballMachine.ejectCoin(); // fail

        System.out.println("====================");

        gumballMachine.insertCoin();
        gumballMachine.insertCoin(); // fail
        gumballMachine.turnLever();
        gumballMachine.insertCoin();
        gumballMachine.turnLever();
        gumballMachine.insertCoin(); // fail
        gumballMachine.turnLever(); // fail
    }
}