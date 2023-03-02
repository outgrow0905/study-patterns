package com.example.patterns.E_AbstractFactory.v3;

public class ComputerSeller {

    ComputerComponentFactory computerComponentFactory;

    public ComputerSeller(ComputerComponentFactory computerComponentFactory) {
        this.computerComponentFactory = computerComponentFactory;
    }

    public Computer orderComputer() {
        Computer computer = new Computer(computerComponentFactory);

        computer.examine();

        return computer;
    }
}
