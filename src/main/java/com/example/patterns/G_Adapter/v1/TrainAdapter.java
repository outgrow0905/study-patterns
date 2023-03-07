package com.example.patterns.G_Adapter.v1;

public class TrainAdapter extends Train {

    private Car car;

    public TrainAdapter(Car car) {
        this.car = car;
    }

    @Override
    public void rail() {
        car.drive();
    }
}
