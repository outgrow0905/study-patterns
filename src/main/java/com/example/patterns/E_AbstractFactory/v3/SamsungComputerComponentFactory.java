package com.example.patterns.E_AbstractFactory.v3;

public class SamsungComputerComponentFactory implements ComputerComponentFactory {
    @Override
    public Monitor getMonitor() {
        return new SamsungMonitor();
    }

    @Override
    public Keyboard getKeyboard() {
        return new SamsungKeyboard();
    }

    @Override
    public Mouse getMouse() {
        return new SamsungMouse();
    }
}
