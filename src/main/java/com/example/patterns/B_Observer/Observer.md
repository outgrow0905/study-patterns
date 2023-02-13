#### Observer Pattern
#### v1
WeatherStation 클래스는 온도, 습도, 기압 디바이스로부터 정보를 얻어온다(고 가정한다).  
그리고, 정보 수집이 끝나면 WeatherData에 정보를 전달한다.

~~~java
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
~~~

WeatherData 클래스는 WeatherObserver 인터페이스를 구현하여 WeatherObserver를 등록, 해지, 알림 역할을 한다.  
WeatherStation는 WeatherData의 클라이언트이고 setWeatherInformation을 호출하여   
WeatherData에 등록된 WeatherObserver 전부에게 변경사항을 전달한다.

~~~java
public class WeatherData implements WeatherSubject {

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
~~~

Display1, 2, 3은 WeatherObserver를 구현하였기 때문에, WeatherData에 등록, 해지를 할 수 있다.  

~~~java
public interface WeatherObserver {
    void update(int temperature, int humidity, int pressure);
}

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
~~~

클라이언트 코드역할을 하는 테스트코드는 아래와 같을 것이다.

~~~java
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
~~~

