package com.example.patterns.F_Command.v3;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

class RemoteControllerTest {
    @Test
    void megaCommand() {
        AirConditioner airConditioner = new AirConditioner();
        Refrigerator refrigerator = new Refrigerator();

        RemoteController remoteController =
                new RemoteController(
                        new MegaCommand(
                                Lists.newArrayList(
                                        new TurnOnAirConditionerCommand(airConditioner),
                                        new OpenRefrigeratorCommand(refrigerator)
                                )),
                        new MegaCommand(
                                Lists.newArrayList(
                                        new TurnOffAirConditionerCommand(airConditioner),
                                        new CloseRefrigeratorCommand(refrigerator)
                                ))
                );

     remoteController.button1Pressed();
     remoteController.button2Pressed();
    }
}