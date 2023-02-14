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

여기서 Observer 패턴을 마무리 할 수 있을까?  
실제로 사용한다면 큰 변경없이 잘 사용할 수 있을까?  

상상 해보자.  

Observer가 엄청 많아도 괜찮을까?  
모든 Observer가 똑같은 정보를 필요로 하지 않을 수 있다.  
하지만 이 구조는 모든 Observer가 굳이 필요하지 않은 정보를 전부 같은 방식으로 전달받아야 한다.  

정보의 변경이 있을 때마다 Subject는 Observer에게 변동여부를 알려주고,  
Observer는 필요한 정보만 Subject에 요청하여 처리하는 것이 좋을 것 같다.

#### v2
먼저 WeatherObserver 인터페이스를 변경해야 한다.  
정보의 변경시 이를 알려줄 뿐, 데이터는 전송하지 않기 때문이다.

그리고, 이왕 개선하는 김에 클래스 명도 범용적으로 사용할 수 있도록 변경해보자.  
WeatherObserver와 WeatherSubject의 인테퍼에스를 살펴보면 사실 Weather가 없어도 될 것 같다.  

~~~java
public interface Observer {
    void update();
}

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}
~~~

이에 맞추어 WeatherData 클래스도 변경하자.

~~~java
public class WeatherData implements Subject {

    List<Observer> observerList = new ArrayList<>();
    private int temperature;
    private int humidity;
    private int pressure;

    @Override
    public void addObserver(Observer observer) {
        this.observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }

    public void setWeatherData(int temperature, int humidity, int pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObserver();
    }
}
~~~

또한, WeatherData에서는 Observer가 필요한 데이터만 조회할 수 있도록 메서드를 만들어야 하겠다. 

~~~java
public int getTemperature() {
    return this.temperature;
}

public int getHumidity() {
    return this.humidity;
}

public int getPressure() {
    return this.pressure;
}
~~~

Display는 아래와 같이 변경함으로서, 데이터변경이 호출될 때마다 (update) 필요한 정보만 얻어올 수 있게 된다.

~~~java
public class Display1 implements Observer {

    private Subject subject;
    
    public Display1(Subject subject) {
        this.subject = subject;
        subject.addObserver(this);
    }

    @Override
    public void update() {
        if (subject instanceof WeatherData) {
            System.out.println(
                    "Display1 temperature: " + ((WeatherData) subject).getTemperature()
                            + ", humidity: " + ((WeatherData) subject).getHumidity()
                            + ", pressure: " + ((WeatherData) subject).getPressure());
        }
        System.out.println("Display1 update!");
    }
}
~~~

만족스러운가?    
조금 더 복잡한 상황을 가정해보고 싶은가?  
만약 Observer가 여러개의 Subject로 이벤트를 받고 싶다면?  

그 부분은 구현은 가능할 것 같다.

~~~
hint1: public void update(Observer observer); (Observer 인터페이스)
hint2: private List<Subject> subjectList; (Display 클래스)
~~~

하지만, 여러 책에서 Observer 패턴은 1:N 관계를 기본으로 하고 있다는 사실은 명심하자.