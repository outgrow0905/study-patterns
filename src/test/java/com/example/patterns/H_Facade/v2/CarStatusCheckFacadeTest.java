package com.example.patterns.H_Facade.v2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarStatusCheckFacadeTest {

    @Test
    void facadePattern() {
        CarStatusCheckFacade carStatusCheckFacade
                = new CarStatusCheckFacade(
                        new Brake(), new Engine(), new GasolineBox(), new Wheel[]{new Wheel(), new Wheel(), new Wheel(), new Wheel()}
        );

        carStatusCheckFacade.statusCheck();
    }
}