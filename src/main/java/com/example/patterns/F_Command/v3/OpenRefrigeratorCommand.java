package com.example.patterns.F_Command.v3;

public class OpenRefrigeratorCommand implements Command {

    private Refrigerator refrigerator;

    public OpenRefrigeratorCommand(Refrigerator refrigerator) {
        this.refrigerator = refrigerator;
    }

    @Override
    public void execute() {
        this.refrigerator.open();
    }
}
