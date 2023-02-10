#### Strategy Pattern
#### v1
Duck 클래스가 있다.  
대부분의 오리(Duck)은 생김새(display)만 다르고, 똑같이 날고(fly), 똑같은 울음소리(sound)를 낸다.  

~~~java
public abstract class Duck {
    public void makeSound() {
        System.out.println("duck! duck!");
    }

    public void fly() {
        System.out.println("fly! fly!");
    }

    public abstract void display();
}
~~~

생김새가 다른 오리가 계속해서 추가된다 하더라도, 메서드를 재활용하여 코드의 중복없이 클래스만 추가하면 된다.

~~~java


public class CommonADuck extends Duck {
    @Override
    public void display() {
        System.out.println("common A duck display!");
    }
}

public class CommonBDuck extends Duck {
    @Override
    public void display() {
        System.out.println("common B duck display!");
    }
}
~~~

완벽하다.

#### v2
날지 못하는 오리가 생겼다. 고무오리(RubberDuck)이다. fly 메서드만 override 하면 문제 없을 것 같다.  
하지만, 문제가 생길 것 같다.   
날지 못하는 종류의 오리가 계속해서 추가된다면?  
날지 못하는 오리 클래스마다 아래의 코드를 계속해서 추가하는 수 밖에 없다. 

~~~java
@Override
public void fly() {
    System.out.println("can't fly!");
}
~~~

이렇게 둘 수는 없다.


#### v3
fly, sound 메서드를 각각 인터페이스로 만들고, 
Duck 클래스에서 인터페이스를 호출하여 수행하도록 변경하는게 좋을 것 같다.

~~~java
public abstract class Duck {

    private Soundable soundable;
    private Flyable flyable;


    public void sound() {
        soundable.sound();
    }

    public void fly() {
        flyable.fly();
    }

    public abstract void display();
}
~~~

이렇게 하면, Soundable, Flyable을 구현한 클래스만 주입하면 될 것 같다.  
Setter를 통해 Duck 클래스에 동적으로 주입할 수 있도록 하자.

~~~java
public void setSoundable(Soundable soundable) {
    this.soundable = soundable;
}

public void setFlyable(Flyable flyable) {
    this.flyable = flyable;
}
~~~

완벽한 것 같지만 한가지 걱정이 있다.  
클라이언트에서 Setter를 주입하지 않으면 NPE가 날 것 같다.    

#### v4
마지막으로 Duck 클래스에서 Setter를 제거하고 생성자 주입을 사용하는 것으로 변경하자.

~~~java
public Duck(Soundable soundable, Flyable flyable) {
        this.soundable = soundable;
        this.flyable = flyable;
}
~~~

이렇게 변경하면, Duck을 구현한 모든 클래스에 코드를 추가해주어야 한다.  
차라리 v3이 나은것 같기도 하지만, 이게 나는 더 마음이 편하다. 

~~~java
public CommonADuck(Soundable soundable, Flyable flyable) {
    super(soundable, flyable);
}

public CommonBDuck(Soundable soundable, Flyable flyable) {
    super(soundable, flyable);
}

public RubberDuck(Soundable soundable, Flyable flyable) {
    super(soundable, flyable);
}
~~~