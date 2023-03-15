package com.example.patterns.L_State.v2;

public class GumballMachine {

    State soldOutStatus;
    State noCoinStatus;
    State soldStatus;
    State hasCoinStatus;

    State currentStatus = soldOutStatus;

    int count = 0;

    public GumballMachine(int count) {
        soldOutStatus = new SoldOutState(this);
        noCoinStatus = new NoCoinState(this);
        soldStatus = new SoldState(this);
        hasCoinStatus = new HasCoinState(this);

        this.count = count;
        if (count > 0) {
            currentStatus = noCoinStatus;
        }
    }

    public void insertCoin() {
        currentStatus.insertCoin();
    }

    public void ejectCoin() {
        currentStatus.ejectCoin();
    }

    public void turnLever() {
        currentStatus.turnLever();
        currentStatus.dispense();
    }

    public void setCurrentStatus(State currentStatus) {
        this.currentStatus = currentStatus;
    }

    public State getSoldOutStatus() {
        return soldOutStatus;
    }

    public State getNoCoinStatus() {
        return noCoinStatus;
    }

    public State getSoldStatus() {
        return soldStatus;
    }

    public State getHasCoinStatus() {
        return hasCoinStatus;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void releaseBall() {
        System.out.println("a gumball is comes rolling out the slot.");
        if (count > 0) {
            count--;
        }
    }
}
