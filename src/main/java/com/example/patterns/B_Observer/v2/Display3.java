package com.example.patterns.B_Observer.v2;

public class Display3 implements Observer {

    private Subject subject;
    public Display3(Subject subject) {
        this.subject = subject;
        subject.addObserver(this);
    }

    @Override
    public void update() {
        if (subject instanceof WeatherData) {
            System.out.println(
                    "Displa31 temperature: " + ((WeatherData) subject).getTemperature()
                            + ", humidity: " + ((WeatherData) subject).getHumidity()
                            + ", pressure: " + ((WeatherData) subject).getPressure());
        }
        System.out.println("Display3 update!");
    }
}
