#### Facade
자동차 엔지니어의 입장에서 시동을 걸어보자.  
브레이크 밟았는지 확인하고, 휘발유 체크하고, 엔진상태 체크하고, 바퀴 공기압 체크가 끝나야 시동을 걸 수 있다.

엔지니어는 아래의 것들을 숙지해야 한다.
- 어떤 객체들을 체크해야하는지 알아야 한다.
- 어떤 순서로 상태체크를 해야하는지 알아야 한다.
- 어떤 객체의 어떤 것을 체크해야하는지 알아야 한다.
- 특정 객체의 체크방법이 바뀌면 이를 알아야 한다.

Facade 패턴을 배워보자.

#### v1
자동차 시동 전 체크해야 할 클래스들은 아래와 같다.

~~~java
public class Brake {
    boolean pushed;

    public boolean isPushed() {
        return pushed;
    }
}

public class GasolineBox {
    boolean full;

    public boolean isFull() {
        return full;
    }
}

public class Engine {
    boolean statusOk;

    public boolean isStatusOk() {
        return statusOk;
    }
}

public class Wheel {
    boolean airPressureFull;

    public boolean isAirPressureFull() {
        return airPressureFull;
    }
}
~~~

엔지니어는 아래와 같이 상태체크를 해야 한다.

~~~java
class FacadeTest {
    @Test
    void carStatusCheck() {
        Brake brake = new Brake();
        GasolineBox gasolineBox = new GasolineBox();
        Engine engine = new Engine();
        Wheel[] wheels = new Wheel[]{new Wheel(), new Wheel(), new Wheel(), new Wheel()};

        brake.isPushed();
        gasolineBox.isFull();
        engine.isStatusOk();
        for (Wheel wheel : wheels) {
            wheel.isAirPressureFull();
        }
    }
}
~~~


#### v2
자동화를 하고 싶다.  
자동차 상태체크 순서도 알고 싶지 않고,  
어떤 부품의 어떤 것을 체크해야하는지도 알고싶지 않다.  
특정 부품의 체크방식이 변경되더라도 알고 싶지 않다.  

CarStatusCheckFacade를 만들어보자.

~~~java
public class CarStatusCheckFacade {
    Brake brake;
    Engine engine;
    GasolineBox gasolineBox;
    Wheel[] wheels;

    public CarStatusCheckFacade(Brake brake, Engine engine, GasolineBox gasolineBox, Wheel[] wheels) {
        this.brake = brake;
        this.engine = engine;
        this.gasolineBox = gasolineBox;
        this.wheels = wheels;
    }

    public void statusCheck() {
        brake.isPushed();
        engine.isStatusOk();
        gasolineBox.isFull();
        for (Wheel wheel : wheels) {
            wheel.isAirPressureFull();
        }
    }
}
~~~

엔지니어(클라이언트)는 아래와 같이 편해졌다.

~~~java
class CarStatusCheckFacadeTest {

    @Test
    void facadePattern() {
        CarStatusCheckFacade carStatusCheckFacade
                = new CarStatusCheckFacade(
                        new Brake(), new Engine(), new GasolineBox(), new Wheel[]{new Wheel(), new Wheel(), new Wheel(), new Wheel()}
        );

        carStatusCheckFacade.statusCheck();
    }
}
~~~