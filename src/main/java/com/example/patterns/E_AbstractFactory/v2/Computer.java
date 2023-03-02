package com.example.patterns.E_AbstractFactory.v2;

public class Computer {

    Monitor monitor;
    Keyboard keyboard;
    Mouse mouse;

    public Computer(Monitor monitor, Keyboard keyboard, Mouse mouse) {
        this.monitor = monitor;
        this.keyboard = keyboard;
        this.mouse = mouse;
    }

    public void examine() {
        System.out.println("examine this computer's condition");
    }
}
