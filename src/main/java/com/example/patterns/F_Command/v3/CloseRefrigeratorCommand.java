package com.example.patterns.F_Command.v3;

public class CloseRefrigeratorCommand implements Command {

    private Refrigerator refrigerator;

    public CloseRefrigeratorCommand(Refrigerator refrigerator) {
        this.refrigerator = refrigerator;
    }

    @Override
    public void execute() {
        this.refrigerator.close();
    }
}
