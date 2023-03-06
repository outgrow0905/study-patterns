package com.example.patterns.F_Command.v1;

public class RemoteController {

    private AirConditioner airConditioner;

    public RemoteController(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    public void turnOnAirConditioner() {
        this.airConditioner.on();
    }

    public void turnOffAirConditioner() {
        this.airConditioner.on();
    }
}
