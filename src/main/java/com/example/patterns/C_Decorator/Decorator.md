#### Decorator Pattern
#### v1
작은 커피숍을 시작했다.  
메뉴는 DarkRoast, HouseBlend, Espresso 세 가지이다.  
각각은 설명이 다르고, 가격도 다르다.  
그렇다면, Beverage라는 추상클레스를 만들고, 설명과 가격만 서브클레스에서 변경하도록 해야겠다.

~~~java
public abstract class Beverage {
    protected String description;

    public String getDescription() {
        return description;
    }

    abstract int cost();
}


public class DarkRoast extends Beverage{

    public DarkRoast() {
        description = "This is DarkRoast.";
    }

    @Override
    int cost() {
        return 110;
    }
}
~~~

#### v2
장사가 잘되고 손님들이 이것저것 주문하는게 많아졌다.  
우유를 스팀우유나 두유로 변경할 수 있도록 요구하는 손님들이 꽤 있다.  
그리고, 휘핑크림도 추가해도 되는지 묻는 손님들이 많아졌다.  
그렇다면, 3개의 음료 * 3개의 우유변경 (기본 우유 포함) * 휘핑크림 여부  
총 18가지 클래스가 만들어져야 한다.  

ex) DarkRoast, DarkRoastWithWhip, DarkRoastWithSoybeanMilk, DarkRoastWithSoybeanMilkAndWhip, DarkRoastWithSteamedMilk, DarkRoastWithSteamedMilkAndWhip

만약, 휘핑크림 말고 초코시럽을 뿌리는 옵션이 추가된다면?  
기존의 18개의 클래스만큼 18개의 클래스가 또 만들어져야 할 것이다.  
그 다음 카라멜크림 옵션이 추가된다면, 기존의 36개 클래스만큼 36개의 클래스가 또 만들어져야 한다.  

애초에 설계가 잘못되었다. Beverage 클래스에 옵션들을 추가하자.  

~~~java
public class Beverage {
    protected String description;
    private boolean soybeanMilk;
    private boolean steamedMilk;
    private boolean whip;

    public String getDescription() {
        return description;
    }

    public int cost() {
        int cost = 0;
        cost = hasSoybeanMilk() ? cost + 10 : cost;
        cost = hasSteamedMilk() ? cost + 5 : cost;
        cost = hasWhip() ? cost + 3 : cost;
        return cost;
    }

    public void soybeanMilk() {
        this.soybeanMilk = true;
    }

    public void steamedMilk() {
        this.steamedMilk = true;
    }

    public void whip() {
        this.whip = true;
    }

    public boolean hasSoybeanMilk() {
        return soybeanMilk;
    }

    public boolean hasSteamedMilk() {
        return steamedMilk;
    }

    public boolean hasWhip() {
        return whip;
    }
}

public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "This is DarkRoast.";
    }

    @Override
    public int cost() {
        return super.cost() + 110;
    }
}
~~~

이렇게 하면 클래스의 추가 없이 가격을 계산할 수 있게 되었다.  
만족스러운가?    

문제를 제기해보겠다.

휘핑크림의 가격이 변동되면, Beverage 클래스를 수정해야 한다.  
모카크림과 같이 새로운 옵션이 추가되면, Beverage 클래스를 수정해야 한다.  
아이스티를 팔고 싶은데, 휘핑크림 옵션은 불가능인데 상속을 했으니 불가능하다.  
휘핑크림을 두 번 더블로 넣고 싶은데, 불가능하다.  

#### v3
Beverage 클래스부터 인터페이스로 변경하고 시작하자.

~~~java
public interface Beverage {
    String getDescription();
    int cost();
}
~~~

기본 음료 DarkRoast, Espresso, HouseBlend 먼저 구현하자.  

~~~java
public class DarkRoast implements Beverage {
    private String description = "This is DarkRoast.";

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public int cost() {
        return 110;
    }
}
~~~

SoybeanMilk, SteamedMilk, Whip클래스가 상속받을 Decorator 클래스를 만들어보자. 
반드시 먼저 만들어보길 바란다. 생각보다 쉽지 않을 수 있다.

~~~java
public abstract class Decorator implements Beverage {

    protected Beverage beverage;
    protected Decorator(Beverage beverage) {
        this.beverage = beverage;
    }
}
~~~

SoybeanMilk를 만들어보자.

~~~java
public class SoybeanMilk extends Decorator {

    public SoybeanMilk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", SoybeanMilk";
    }

    @Override
    public int cost() {
        return beverage.cost() + 10;
    }
}
~~~

SteamMilk, Whip 추가, SoyBeanMilk 두 번 추가한 DarkRoast를 만들어보자.

~~~java
class BeverageTest {
    @Test
    void cost() {
        Beverage darkRoastWithSteamedMilkAndWhipAndDoubleSoybeanMilk =
                new SoybeanMilk(new SoybeanMilk(new Whip(new SteamedMilk(new DarkRoast()))));

        assertEquals(110 + 5 + 3 + 10 + 10, darkRoastWithSteamedMilkAndWhipAndDoubleSoybeanMilk.cost());
    }
}
~~~

v2의 문제점들이 전부 해소되었는가?  

휘핑크림의 가격이 변동되면, Beverage 클래스를 수정해야 한다.  
> 휘핑크림의 가격이 변경되면 휘핑크림 클래스만 수정하면 된다.

모카크림과 같이 새로운 옵션이 추가되면, Beverage 클래스를 수정해야 한다.  
> 새로운 옵션이 추가되더라도 기존 클래스는 변경할것이 전혀 없다. 

휘핑크림을 두 번 더블로 넣고 싶은데, 불가능하다. 
> 가능하다. 100번도 가능하다.

휘핑크림 옵션은 불가능한 아이스티를 팔고 싶은데 상속을 했으니 불가능하다. 
> 여전히 안된다. 휘핑크림 클래스가 바로 아이스티 클래스를 바로 래핑한다면 가능하겠지만, 스팀밀크가 래핑된 아이스티라면 불가능하다.  
Decorator 패턴은 래핑하는 클래스의 구체클래스에 의존해서는 안되고 그럴수도 없다. 이 경우는 이 패턴을 사용하지 않고 다른 대안을 찾아야 한다.