#### Adapter
부산에 위치한 자동차회사의 사장이 되어보자.  
매일 자동차 100대를 서울로 보내야 하는데 운반차에는 6대밖에 싣지 못한다.  
철로를 이용해서 차를 보내면 얼마나 편할까?  
하지만, 자동차바퀴는 철로와 규격이 맞지 않다.  

Adapter 패턴을 사용하여 자동차가 철로를 이용할 수 있도록 해보자.


#### v1
자동차, 기차, 철로 클래스는 아래와 같다.

~~~java
public class Car {
    public void drive() {
        System.out.println("drive! drive!");
    }
}

public class Train {
    public void rail() {
        System.out.println("choo! choo!");
    }
}

public class Rail {
    public void push(Train train) {
        train.rail();
    }
}
~~~

철도 클래스를 보면 기차만 움직일 수 있다.  
Adapter를 만들어보자.

~~~java
public class TrainAdapter extends Train {

    private Car car;

    public TrainAdapter(Car car) {
        this.car = car;
    }

    @Override
    public void rail() {
        car.drive();
    }
}
~~~

실행해보자.

~~~java
class TrainAdapterTest {

    @Test
    void adapterPattern() {
        Car car = new Car();
        Train transformedCar = new TrainAdapter(car);
        Rail rail = new Rail();
        rail.push(transformedCar);
    }
}
~~~