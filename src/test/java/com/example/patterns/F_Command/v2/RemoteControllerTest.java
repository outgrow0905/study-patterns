package com.example.patterns.F_Command.v2;

import org.junit.jupiter.api.Test;

class RemoteControllerTest {
    @Test
    void commandPattern() {
        AirConditioner airConditioner = new AirConditioner();

        RemoteController airConditionerRemoteController =
                new RemoteController(
                        new TurnOnAirConditionerCommand(airConditioner),
                        new TurnOffAirConditionerCommand(airConditioner));

        airConditionerRemoteController.button1Pressed();
        airConditionerRemoteController.button2Pressed();
    }
}