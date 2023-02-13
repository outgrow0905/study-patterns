package com.example.patterns.B_Observer.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherData implements WeatherSubject{

    List<WeatherObserver> weatherObserverList = new ArrayList<>();
    private int temperature;
    private int humidity;
    private int pressure;

    @Override
    public void addWeatherObserver(WeatherObserver weatherObserver) {
        this.weatherObserverList.add(weatherObserver);
    }

    @Override
    public void removeWeatherObserver(WeatherObserver weatherObserver) {
        this.weatherObserverList.remove(weatherObserver);
    }

    @Override
    public void notifyWeatherObserver() {
        for (WeatherObserver weatherObserver : weatherObserverList) {
            weatherObserver.update(this.temperature, this.humidity, this.pressure);
        }
    }

    public void setWeatherData(int temperature, int humidity, int pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyWeatherObserver();
    }
}
