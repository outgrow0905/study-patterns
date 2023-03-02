package com.example.patterns.E_AbstractFactory.v2;

public class LGComputerSeller extends ComputerSeller{
    @Override
    Computer getComputer() {
        return new Computer(
                new LGMonitor(),
                new LGKeyboard(),
                new LGMouse()
        );
    }
}