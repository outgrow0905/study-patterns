package com.example.patterns.B_Observer.v2;

public class Display2 implements Observer {

    private Subject subject;
    public Display2(Subject subject) {
        this.subject = subject;
        subject.addObserver(this);
    }

    @Override
    public void update() {
        if (subject instanceof WeatherData) {
            System.out.println(
                    "Display2 temperature: " + ((WeatherData) subject).getTemperature()
                            + ", humidity: " + ((WeatherData) subject).getHumidity()
                            + ", pressure: " + ((WeatherData) subject).getPressure());
        }
        System.out.println("Display2 update!");
    }
}
