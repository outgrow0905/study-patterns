package com.example.patterns.H_Facade.v1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FacadeTest {
    @Test
    void carStatusCheck() {
        Brake brake = new Brake();
        GasolineBox gasolineBox = new GasolineBox();
        Engine engine = new Engine();
        Wheel[] wheels = new Wheel[]{new Wheel(), new Wheel(), new Wheel(), new Wheel()};

        brake.isPushed();
        gasolineBox.isFull();
        engine.isStatusOk();
        for (Wheel wheel : wheels) {
            wheel.isAirPressureFull();
        }
    }
}