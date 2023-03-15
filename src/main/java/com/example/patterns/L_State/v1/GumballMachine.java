package com.example.patterns.L_State.v1;

public class GumballMachine {
    final static int SOLD_OUT = 0;
    final static int NO_COIN = 1;
    final static int HAS_COIN = 2;
    final static int SOLD = 3;

    int state = SOLD_OUT;
    int count = 0;

    public GumballMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = NO_COIN;
        }
    }

    public void insertCoin() {
        if (state == HAS_COIN) {
            System.out.println("you already inserted coin.");
        } else if (state == NO_COIN) {
            state = HAS_COIN;
            System.out.println("you inserted coin.");
        } else if (state == SOLD_OUT) {
            System.out.println("no gumball now.");
        } else if (state == SOLD) {
            System.out.println("gumball is coming out. please wait.");
        }
    }

    public void ejectCoin() {
        if (state == HAS_COIN) {
            state = NO_COIN;
            System.out.println("coin is ejected.");
        } else if (state == NO_COIN) {
            System.out.println("no coin to eject.");
        } else if (state == SOLD_OUT) {
            System.out.println("no gumball now. no coin to eject.");
        } else if (state == SOLD) {
            System.out.println("gumball is coming out. can't eject now.");
        }
    }

    public void turnLever() {
        if (state == HAS_COIN) {
            state = SOLD;
            System.out.println("you turned lever. gumball is coming out.");
            dispense();
        } else if (state == NO_COIN) {
            System.out.println("insert coin first.");
        } else if (state == SOLD_OUT) {
            System.out.println("no gumball now. sorry.");
        } else if (state == SOLD) {
            System.out.println("gumball is coming out. please wait.");
        }
    }

    public void dispense() {
        if (state == HAS_COIN) {
            System.out.println("turn lever first.");
        } else if (state == NO_COIN) {
            System.out.println("insert coin first.");
        } else if (state == SOLD_OUT) {
            System.out.println("no gumball now.");
        } else if (state == SOLD) {
            count--;
            if (count == 0) {
                System.out.println("gumball is coming out. all gumballs are sold out.");
                state = SOLD_OUT;
            } else {
                System.out.println("gumball is coming out.");
                state = NO_COIN;
            }
        }
    }
}
