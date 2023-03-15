package com.example.patterns.L_State.v2;

public class HasCoinState implements State {
    GumballMachine gumballMachine;

    public HasCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("you already inserted coin.");
    }

    @Override
    public void ejectCoin() {
        gumballMachine.setCurrentStatus(gumballMachine.getNoCoinStatus());
        System.out.println("coin is ejected.");
    }

    @Override
    public void turnLever() {
        gumballMachine.setCurrentStatus(gumballMachine.getSoldStatus());
        System.out.println("you turned lever. gumball is coming out.");
    }

    @Override
    public void dispense() {
        System.out.println("turn lever first.");
    }
}
