package com.example.patterns.B_Observer.v1;

public interface WeatherObserver {
    void update(int temperature, int humidity, int pressure);
}
