package com.example.patterns.E_AbstractFactory.v1;

public class ComputerSeller {
    public Computer orderComputer(String brand) {
        Computer computer = null;

        if ("samsung".equals(brand)) {
            computer = new Computer(
                    new SamsungMonitor(),
                    new SamsungKeyboard(),
                    new SamsungMouse());
        }

        if ("lg".equals(brand)) {
            computer = new Computer(
                    new LGMonitor(),
                    new LGKeyboard(),
                    new LGMouse());
        }

        if (null == computer) {
            throw new RuntimeException("we don't sell apple");
        }

        computer.examine();

        return computer;
    }
}
