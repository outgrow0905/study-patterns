package com.example.patterns.E_AbstractFactory.v3;

public interface ComputerComponentFactory {
    Monitor getMonitor();
    Keyboard getKeyboard();
    Mouse getMouse();
}
