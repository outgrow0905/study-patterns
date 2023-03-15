package com.example.patterns.L_State.v2;

public class SoldOutState implements State {

    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("no gumball now.");
    }

    @Override
    public void ejectCoin() {
        System.out.println("no gumball now. no coin to eject.");
    }

    @Override
    public void turnLever() {
        System.out.println("no gumball now. sorry.");
    }

    @Override
    public void dispense() {
        System.out.println("no gumball now.");
    }
}
