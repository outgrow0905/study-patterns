package com.example.patterns.B_Observer.v1;

import org.junit.jupiter.api.Test;

class WeatherDataTest {
    @Test
    void observerPatternTest() {
        // create subject
        WeatherSubject weatherData = new WeatherData();

        // register observers
        Display1 display1 = new Display1(weatherData);
        Display2 display2 = new Display2(weatherData);
        Display3 display3 = new Display3(weatherData);

        // create data collector
        WeatherStation collector = new WeatherStation((WeatherData) weatherData);

        // collect data and inform
        collector.collectWeatherData();

        // remove observer display 1
        weatherData.removeWeatherObserver(display1);

        // collect data and inform
        collector.collectWeatherData();
    }
}