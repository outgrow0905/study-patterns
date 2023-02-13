package com.example.patterns.B_Observer.v1;

import java.util.Random;

public class WeatherStation {
    private WeatherData weatherData;
    private int temperature;
    private int humidity;
    private int pressure;

    public WeatherStation(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    public void collectWeatherData() {
        Random random = new Random();
        this.temperature = random.nextInt(40) - 10;
        this.humidity = random.nextInt(80);
        this.pressure = random.nextInt(100) + 950;

        setWeatherData();
    }

    public void setWeatherData() {
        weatherData.setWeatherData(this.temperature, this.humidity, this.pressure);
    }
}
