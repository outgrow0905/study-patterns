package com.example.patterns.E_AbstractFactory.v2;

public class SamsungComputerSeller extends ComputerSeller{
    @Override
    Computer getComputer() {
        return new Computer(
                new SamsungMonitor(),
                new SamsungKeyboard(),
                new SamsungMouse()
        );
    }
}
