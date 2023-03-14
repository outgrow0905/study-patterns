#### Composite
팬케이크와 스테이크 예시가 끝나지 않았다.  
장사가 더 잘되어 늦은 저녁에는 술집을 하기로 하였다.  
이 술집의 이름은 코다차야이다.  
컨셉이 있는 술집인데, 술집 안에 여러개의 매장이 입정해있는 컨셉이다.  
코다차야 안에는 분식집도 있고, 횟집도 있다.

기존의 코드 수정없이 코다차야를 합병할 수 있을까?


#### v1
MenuItem의 메서드들로 추상클래스를 만들어보자.

~~~java
public abstract class MenuComponent {
    String getName() {
        throw new UnsupportedOperationException();
    }

    String getDescription() {
        throw new UnsupportedOperationException();
    }

    boolean isVegetarian(){
        throw new UnsupportedOperationException();
    }

    double getPrice(){
        throw new UnsupportedOperationException();
    }

    
    void addComposition(MenuComponent menuComposition) {
        throw new UnsupportedOperationException(); // MenuItem에는 없지만 추가한다. 아래에서 설명한다.
    }

    void print() {
        throw new UnsupportedOperationException(); // MenuItem에는 없지만 추가한다. 아래에서 설명한다.
    }
}
~~~

그리고 MenuItem은 기존코드 변경없이 이를 상속할 수 있다.  
print 메서드는 아래와 같이 구현해두자.

~~~java
public class MenuItem extends MenuComponent {
    
    ...
    
    @Override
    void print() {
        System.out.println("MenuItem{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", vegetarian=" + vegetarian +
                ", price=" + price +
                '}');
    }
}
~~~

Menu(Composite)를 만들어보자.  
MenuComponent에서 MenuItem이 사용하지 않았던 그 부분을 구현하여 만들어보자.

~~~java
public class Menu extends MenuComponent {
    String name;
    String description;
    List<MenuComponent> menuComponents = new ArrayList<>();

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    void addComposition(MenuComponent menuComposition) {
        menuComponents.add(menuComposition);
    }

    @Override
    void print() {
        System.out.println("Menu{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}');

        for (MenuComponent menuComponent : menuComponents) {
            menuComponent.print(); // 재귀
        }
    }
}
~~~

List<MenuComponent> menuComponents = new ArrayList<>();  
부분이 이 패턴의 핵심이다.  
MenuComponent 컬랙션을 가지고 있기 때문에, 이 안에는 MenuItem, Menu 둘 다 들어갈 수 있다.


MenuItem을 사용하던 팬케이크와 스테이크 클래스는 Menu 클래스를 이용하도록 변경해보자.

~~~java
public class PancakeHouseMenu extends Menu {
    public PancakeHouseMenu(String name, String description) {
        super(name, description);
        addComposition(new MenuItem("King pancake set", "pancake with eggs and toast, coffee", true, 3.99));
        addComposition(new MenuItem("Queen pancake set", "pancake with sausage, milk", false, 2.99));
        addComposition(new MenuItem("Blueberry pancake", "pancake with blueberries", true, 1.99));
        addComposition(new MenuItem("Waffle", "waffle with apple syrup", true, 1.49));
    }
}

public class PancakeHouseMenu extends Menu {
    public PancakeHouseMenu(String name, String description) {
        super(name, description);
        addComposition(new MenuItem("King pancake set", "pancake with eggs and toast, coffee", true, 3.99));
        addComposition(new MenuItem("Queen pancake set", "pancake with sausage, milk", false, 2.99));
        addComposition(new MenuItem("Blueberry pancake", "pancake with blueberries", true, 1.99));
        addComposition(new MenuItem("Waffle", "waffle with apple syrup", true, 1.49));
    }
}
~~~

웨이터는 아래와 같을 것이다.

~~~java
public class Waiter {
    List<Menu> menus = new ArrayList<>();

    public Waiter(List<Menu> menus) {
        this.menus = menus;
    }

    public void printMenu() {
        for (Menu menu : menus) {
            menu.print();
        }
    }
}
~~~

이제야 코다차야를 만들 시간이다.

~~~java
public class KodachayaMenu extends Menu {
    public KodachayaMenu(String name, String description) {
        super(name, description);
        Menu kimbob = new Menu("Kimbab heaven", "welcome");
        kimbob.addComposition(new MenuItem("Kimbob", "common Kimbob", true, 1.49));
        kimbob.addComposition(new MenuItem("Toppokki", "common Toppokki", true, 0.99));

        Menu seafood = new Menu("Seafood heaven", "welcome");
        seafood.addComposition(new MenuItem("seaweed", "seaweed", true, 0.49));
        seafood.addComposition(new MenuItem("squid", "squid", true, 4.49));

        addComposition(kimbob);
        addComposition(seafood);
    }
}
~~~

클라이언트 코드를 만들자.

~~~java
@Test
void waiter() {
    Waiter waiter = new Waiter(
            Arrays.asList(new PancakeHouseMenu("Pancake House Menu", "Welcome"),
                    new SteakHouseMenu("Steak House Menu", "Welcome"),
                    new KodachayaMenu("Kodachaya Menu", "Welcome"))
    );
    waiter.printMenu();
}
~~~