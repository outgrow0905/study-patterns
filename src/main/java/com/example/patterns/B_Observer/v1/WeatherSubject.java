package com.example.patterns.B_Observer.v1;

public interface WeatherSubject {
    void addWeatherObserver(WeatherObserver weatherObserver);
    void removeWeatherObserver(WeatherObserver weatherObserver);
    void notifyWeatherObserver();
}
