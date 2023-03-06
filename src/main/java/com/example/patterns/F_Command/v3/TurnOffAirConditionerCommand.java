package com.example.patterns.F_Command.v3;

public class TurnOffAirConditionerCommand implements Command {
    private AirConditioner airConditioner;

    public TurnOffAirConditionerCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        this.airConditioner.off();
    }
}
