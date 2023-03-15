package com.example.patterns.L_State.v2;

public class NoCoinState implements State {
    GumballMachine gumballMachine;

    public NoCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        gumballMachine.setCurrentStatus(gumballMachine.getHasCoinStatus());
        System.out.println("you inserted coin.");
    }

    @Override
    public void ejectCoin() {
        System.out.println("no coin to eject.");
    }

    @Override
    public void turnLever() {
        System.out.println("insert coin first.");
    }

    @Override
    public void dispense() {
        System.out.println("insert coin first.");
    }
}
