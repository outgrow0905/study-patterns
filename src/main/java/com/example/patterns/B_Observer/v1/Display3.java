package com.example.patterns.B_Observer.v1;

public class Display3 implements WeatherObserver{

    public Display3(WeatherSubject weatherSubject) {
        weatherSubject.addWeatherObserver(this);
    }

    @Override
    public void update(int temperature, int humidity, int pressure) {
        System.out.println("Display3 temperature: " + temperature + ", humidity: " + humidity + ", pressure: " + pressure);
        System.out.println("Display3 update!");
    }
}
