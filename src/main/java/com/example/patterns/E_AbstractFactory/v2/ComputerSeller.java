package com.example.patterns.E_AbstractFactory.v2;

public abstract class ComputerSeller {
    public Computer orderComputer() {
        Computer computer = getComputer();

        computer.examine();

        return computer;
    }

    abstract Computer getComputer();
}
