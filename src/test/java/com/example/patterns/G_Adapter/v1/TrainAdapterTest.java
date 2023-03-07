package com.example.patterns.G_Adapter.v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainAdapterTest {

    @Test
    void adapterPattern() {
        Car car = new Car();
        Train transformedCar = new TrainAdapter(car);
        Rail rail = new Rail();
        rail.push(transformedCar);
    }
}