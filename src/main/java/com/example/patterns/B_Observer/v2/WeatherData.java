package com.example.patterns.B_Observer.v2;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

    List<Observer> observerList = new ArrayList<>();
    private int temperature;
    private int humidity;
    private int pressure;

    @Override
    public void addObserver(Observer observer) {
        this.observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }

    public void setWeatherData(int temperature, int humidity, int pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObserver();
    }

    public int getTemperature() {
        return this.temperature;
    }

    public int getHumidity() {
        return this.humidity;
    }

    public int getPressure() {
        return this.pressure;
    }
}
