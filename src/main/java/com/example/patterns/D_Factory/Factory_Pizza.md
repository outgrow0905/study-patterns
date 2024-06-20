#### Factory Pattern (example Pizza)
#### v1
피자가게를 오픈했다.  
간단하게 Pizza 인터페이스와 이를 구현한 두 종류의 피자가 있다.  

~~~java
public interface Pizza {
    void prepare();
    void bake();
    void cut();
    void box();
}

public class CheesePizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("prepare CheesePizza.");
    }

    @Override
    public void bake() {
        System.out.println("bake CheesePizza.");
    }

    @Override
    public void cut() {
        System.out.println("cut CheesePizza.");
    }

    @Override
    public void box() {
        System.out.println("box CheesePizza.");
    }
}
~~~

그리고, 피자를 판매하는 PizzaStore 클래스도 있다.

~~~java
public class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza = null;

        if ("cheese".equals(type)) {
            pizza = new CheesePizza();
        }
        if ("chicago".equals(type)) {
            pizza = new ChicagoPizza();
        }

        if (null == pizza) {
            throw new RuntimeException("We don't have that type of pizza.");
        }

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
~~~

아무래도 요즘 모짜렐라피자가 대세이다. 메뉴를 추가하자.  
그리고 시카고피자는 메뉴에서 제외하자. 안팔린다.  
근데 조금 불편하다. Pizza 종류가 추가되는 것인데 PizzaStore 클래스를 수정해야는게 전직 개발자로서 불편하다.    
SimplePizzaFactory를 만들어보자.

#### v2

~~~java
public class SimplePizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if ("cheese".equals(type)) {
            pizza = new CheesePizza();
        }
        if ("chicago".equals(type)) {
            pizza = new MozzarellaPizza();
        }

        if (null == pizza) {
            throw new RuntimeException("We don't create that type of pizza.");
        }

        return pizza;
    }
}
~~~

createPizza 메서드를 static으로 할지 말지 고민이 많았다.  
static으로 하면 PizzaStore에서 SimplePizzaFactory의 인스턴스 생성없이도 피자를 생성할 수 있는 장점이 있다.    
그럼에도 안한 이유는 다음과 같다.  
static으로 선언하면 SimplePizzaFactory를 상속하여 createPizza 행동을 변경할 수 없기 때문이다.  
PizzaStore가 아닌 PizzaDelivery에서 치즈피자를 주문하면 더블치즈피자를 준다고 가정해보자.
createPizza 메서드가 static 으로 되어있다면 SimplePizzaFactory를 상속해도 이를 변경할 수 없다.  

이쯤하고, PizzaStore의 코드는 아래와 같을 것이다.

~~~java
public class PizzaStore {
    private SimplePizzaFactory pizzaFactory;

    public PizzaStore(SimplePizzaFactory pizzaFactory) {
        this.pizzaFactory = pizzaFactory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = pizzaFactory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
~~~

이게 개선된 것인가? 단순히 createPizza 메서드만 다른 클래스로 분리한것 뿐이지 않은가?  
그렇지만은 않다. 좀 더 의미를 부여해보자.  
createPizza 메서드는 꼭 PizzaStore이 아니더라도 여러곳에서 호출할 수 있다.  
치킨을 같이 파는 ChickenAndPizzaStore에서 호출할 수도 있고, 위에서 처럼 피자배달전문업체인 PizzaDelivery에서 호출할 수도 있다.  
코드 재사용성 측면에서 개선이 조금은 되었다고 볼 수 있다.

아직 Factory 패턴은 시작도 안했다. 가봅시다.


#### v3
잠시 멈추고, v1에서 다른 방법으로 개선할 수는 없었는지 생각해보자.  
Pizza의 구상클래스를 만드는 부분을 v2처럼 factory로 위임하지 말고, 메서드로 뺄 수도 있을 것 같다.  
어차피 Pizza 구상클래스만 만들어서 리턴하면 되는데, 클래스든 메서드든 무슨 상관인가?  

~~~java
public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    abstract Pizza createPizza(String type);
}

public class CommonPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if ("cheese".equals(type)) {
            pizza = new CheesePizza();
        }
        if ("mozzarella".equals(type)) {
            pizza = new MozzarellaPizza();
        }

        if (null == pizza) {
            throw new RuntimeException("We don't sell that type of pizza.");
        }

        return pizza;
    }
}
~~~

v3와 다른 점은, 
factory 클래스들이 없어지고 다른 피자를 생성하는 피자가게가 필요하다면,  
PizzaStore 클래스를 상속하여 새로운 클래스를 만드는 방식으로 확장하는 것이다.   

이러한 방식을 Factory Method Pattern 이라고 한다. 이름이 직관적이다.  
구상클래스를 만드는 역할을 하는 Factory를 Method에서 한다는 말이니말이다.

Seoul 스타일 치즈피자와 모짜렐라 피자를 판매하는 SeoulPizzaStore를 연습으로 만들어보라.


#### v4
Factory Method Pattern은 v3까지이다. 
이제부터는 Abstract Factory Pattern을 연습해보자.  
이름이 v4이지만, Factory Method Pattern의 개선이나 호환은 아니라는 점을 미리 명심하자.

Pizza로 다른 이야기를 만들어보자.  
Pizza는 Sauce, Dough, Veggie[], Shrimp 으로 구성되어있다.  

모든 피자는 이 재료 내에서 만들어진다.  

예를 들어,   
치즈피자는 Sauce, Dough, Veggie[]로 구성되고,  
새우피자는 Sauce, Dough, Shrimp으로 구성된다.

지역별 피자는 정해진 Sauce, Dough, Veggie[], Shrimp 재료 내에서 만들어져야 한다고 생각해보자.  
예를 들어, NY스타일은 치즈피자를 만들든, 새우피자를 만들든 Sauce는 NYSauce를 사용해야 한다.

~~~java
public abstract class Pizza {
    String name;
    Dough dough;
    Sauce sauce;
    Shrimp shrimp;
    Veggie[] veggies;

    abstract void prepare();

    void bake() {
        System.out.println("bake for 25 minutes at 350F");
    }
    void cut() {
        System.out.println("cut the pizza into diagonal slices");
    }
    void box() {
        System.out.println("place the pizza in official pizza store box");
    }
}
~~~

피자재료 팩토리를 만들어보자.

~~~java
public interface PizzaIngredientFactory {
    Dough getDough();
    Sauce getSauce();
    Veggie[] getVeggies();
    Shrimp getShrimp();
}
~~~

뉴욕스타일 피자재료 팩토리를 만들어보자.

~~~java
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough getDough() {
        return new NYStyleDough();
    }

    @Override
    public Sauce getSauce() {
        return new NYStyleSauce();
    }

    @Override
    public Veggie[] getVeggies() {
        return new Veggie[]{new Tomato(), new Olive()};
    }

    @Override
    public Shrimp getShrimp() {
        return new BlackShrimp();
    }
}
~~~

치즈피자와 새우피자를 만들어보자.  

~~~java
public class CheesePizza extends Pizza {

    private PizzaIngredientFactory pizzaIngredientFactory;

    public CheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    void prepare() {
        dough = pizzaIngredientFactory.getDough();
        sauce = pizzaIngredientFactory.getSauce();
        veggies = pizzaIngredientFactory.getVeggies();
    }
}

public class ShrimpPizza extends Pizza{

    PizzaIngredientFactory pizzaIngredientFactory;

    public ShrimpPizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    void prepare() {
        dough = pizzaIngredientFactory.getDough();
        sauce = pizzaIngredientFactory.getSauce();
        shrimp = pizzaIngredientFactory.getShrimp();
    }
}
~~~

PizzaStore는 v3과 동일하다.

~~~java
public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    abstract Pizza createPizza(String type);
}
~~~

NYPizzaStore를 만들어보자.
~~~java
public class NYPizzaStore extends PizzaStore{

    NYPizzaIngredientFactory factory = new NYPizzaIngredientFactory();

    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;

        if ("cheese".equals(type)) {
            pizza = new CheesePizza(factory);
        }

        if ("shrimp".equals(type)) {
            pizza = new ShrimpPizza(factory);
        }

        if (null == pizza) {
            throw new RuntimeException("We don't sell that type of pizza.");
        }

        return pizza;
    }
}
~~~

클라이언트 코드는 아래와 같을 것이다.

~~~java
class PizzaStoreTest {
    @Test
    void orderPizza() {
        PizzaStore nyPizzaStore = new NYPizzaStore();
        Pizza cheesePizza = nyPizzaStore.orderPizza("cheese");
        Pizza shrimpPizza = nyPizzaStore.orderPizza("shrimp");
    }
}
~~~