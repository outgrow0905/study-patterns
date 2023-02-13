package com.example.patterns.B_Observer.v1;

public class Display2 implements WeatherObserver{

    public Display2(WeatherSubject weatherSubject) {
        weatherSubject.addWeatherObserver(this);
    }
    @Override
    public void update(int temperature, int humidity, int pressure) {
        System.out.println("Display2 temperature: " + temperature + ", humidity: " + humidity + ", pressure: " + pressure);
        System.out.println("Display2 update!");
    }
}
