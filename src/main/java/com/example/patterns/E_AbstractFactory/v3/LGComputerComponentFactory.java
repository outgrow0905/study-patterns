package com.example.patterns.E_AbstractFactory.v3;

public class LGComputerComponentFactory implements ComputerComponentFactory {
    @Override
    public Monitor getMonitor() {
        return new LGMonitor();
    }

    @Override
    public Keyboard getKeyboard() {
        return new LGKeyboard();
    }

    @Override
    public Mouse getMouse() {
        return new LGMouse();
    }
}
