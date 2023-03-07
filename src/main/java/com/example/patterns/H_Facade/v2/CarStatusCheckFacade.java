package com.example.patterns.H_Facade.v2;

public class CarStatusCheckFacade {
    Brake brake;
    Engine engine;
    GasolineBox gasolineBox;
    Wheel[] wheels;

    public CarStatusCheckFacade(Brake brake, Engine engine, GasolineBox gasolineBox, Wheel[] wheels) {
        this.brake = brake;
        this.engine = engine;
        this.gasolineBox = gasolineBox;
        this.wheels = wheels;
    }

    public void statusCheck() {
        brake.isPushed();
        engine.isStatusOk();
        gasolineBox.isFull();
        for (Wheel wheel : wheels) {
            wheel.isAirPressureFull();
        }
    }
}
