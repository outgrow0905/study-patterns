package com.example.patterns.B_Observer.v1;

public class Display1 implements WeatherObserver{

    public Display1(WeatherSubject weatherSubject) {
        weatherSubject.addWeatherObserver(this);
    }

    @Override
    public void update(int temperature, int humidity, int pressure) {
        System.out.println("Display1 temperature: " + temperature + ", humidity: " + humidity + ", pressure: " + pressure);
        System.out.println("Display1 update!");
    }
}
