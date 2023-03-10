#### TemplateMethod
커피와 차를 내려보자.  
커피는 물을 끓이고, 커피스틱을 뜯어 물에 넣고, 컵에 부은 뒤, 설탕 등을 넣고 마시면 된다.  
차는 물을 끓이고, 티백을 뜯어 물에 넣고, 컵에 부은 뒤, 레몬 등을 넣고 마시면 된다.  

거의 비슷하다.

#### v1
~~~java
public class Coffee {
    public void prepare() {
        boilWater();
        openCoffeeStickAndPourInCup();
        pourInCup();
        addSugar();
    }

    public void boilWater() {
        System.out.println("boil Water");
    }

    public void openCoffeeStickAndPourInCup() {
        System.out.println("steepTeaBag");
    }

    public void pourInCup() {
        System.out.println("pourInCup");
    }

    public void addSugar() {
        System.out.println("addLemon");
    }
}

public class Tea {
    public void prepare() {
        boilWater();
        steepTeaBag();
        pourInCup();
        addLemon();
    }
    public void boilWater() {
        System.out.println("boil Water");
    }

    public void steepTeaBag() {
        System.out.println("steepTeaBag");
    }

    public void pourInCup() {
        System.out.println("pourInCup");
    }

    public void addLemon() {
        System.out.println("addLemon");
    }
}
~~~


#### v2
커피와 차는 prepare라는 일종의 템플릿을 가지고 있다.  
일련의 로직들의 호출순서와 로직을 담당한다. 
둘의 로직이 거의 비슷하므로, CaffeineBeverage 라는 인터페이스로 묶어보자.

~~~java
public abstract class CaffeineBeverage {

    final void prepare() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    private void boilWater() {
        System.out.println("boil water");
    }

    private void pourInCup() {
        System.out.println("pour in cup");
    }

    abstract void brew();
    abstract void addCondiments();
}

~~~

커피와 차의 변하는 부분인 brew(), addCondiments()는 상속클래스에서 구현한다.  

~~~java
public class Coffee extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("open coffee-stick and pour in cup");
    }

    @Override
    void addCondiments() {
        System.out.println("add sugar");
    }
}
~~~

클라이언트는 아래와 같다.

~~~java
@Test
void templateMethodPattern() {
    CaffeineBeverage coffee = new Coffee();
    CaffeineBeverage tea = new Tea();

    coffee.prepare();
    tea.prepare();
}
~~~


#### v3
템플릿메서드 패턴의 경우는 hook() 기능을 넣을 수 있다.  
템플릿메서드를 final로 관리하는 경우가 많기 때문에, 상속한 클래스에서 일종의 부가로직을 넣기 위한 용도이다.  
기본적으로 hook()은 아무 역할도 하지 않는다.

~~~java
public abstract class CaffeineBeverage {

    final void prepare() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();

        // hook
        if (hookCondition()) {
            hookAction();
        }
    }

    private void boilWater() {
        System.out.println("boil water");
    }

    private void pourInCup() {
        System.out.println("pour in cup");
    }

    abstract void brew();
    abstract void addCondiments();

    boolean hookCondition() {
        return true;
    }

    void hookAction() {}
}
~~~

이를 커피클래스는 50% 확률로 특정 action을 취하도록 할 수 있다.

~~~java
public class Coffee extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("open coffee-stick and pour in cup");
    }

    @Override
    void addCondiments() {
        System.out.println("add sugar");
    }

    @Override
    boolean hookCondition() {
        return RandomUtil.getPositiveInt() % 2 == 0;
    }

    @Override
    void hookAction() {
        System.out.println("you are lucky!");
    }
}
~~~

클라이언트 코드는 아래와 같다.

~~~java
@Test
void templateMethodPattern() {
    CaffeineBeverage coffee = new Coffee();
    coffee.prepare();
}
~~~