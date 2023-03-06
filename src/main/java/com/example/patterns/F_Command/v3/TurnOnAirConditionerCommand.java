package com.example.patterns.F_Command.v3;

public class TurnOnAirConditionerCommand implements Command {

    private AirConditioner airConditioner;

    public TurnOnAirConditionerCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        this.airConditioner.on();
    }
}
