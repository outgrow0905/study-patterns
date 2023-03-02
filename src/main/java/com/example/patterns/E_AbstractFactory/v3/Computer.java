package com.example.patterns.E_AbstractFactory.v3;

public class Computer {

    Monitor monitor;
    Keyboard keyboard;
    Mouse mouse;

    ComputerComponentFactory computerComponentFactory;

    public Computer(ComputerComponentFactory computerComponentFactory) {
        this.computerComponentFactory = computerComponentFactory;
    }

    public Computer() {
        this.monitor = computerComponentFactory.getMonitor();
        this.keyboard = computerComponentFactory.getKeyboard();
        this.mouse = computerComponentFactory.getMouse();
    }

    public void examine() {
        System.out.println("examine this computer's condition");
    }
}
