package com.example.patterns.L_State.v2;

public class SoldState implements State {
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("gumball is coming out. please wait.");
    }

    @Override
    public void ejectCoin() {
        System.out.println("gumball is coming out. can't eject now.");
    }

    @Override
    public void turnLever() {
        System.out.println("gumball is coming out. please wait.");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        System.out.println("gumball is coming out.");

        if (gumballMachine.isEmpty()) {
            gumballMachine.setCurrentStatus(gumballMachine.getSoldOutStatus());
            System.out.println("all gumball sold out.");
        } else {
            gumballMachine.setCurrentStatus(gumballMachine.getNoCoinStatus());
        }
    }
}
