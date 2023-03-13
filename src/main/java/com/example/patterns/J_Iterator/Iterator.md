#### Iterator
레스토랑을 인수하였다.  
점심에는 펜케이크 카페이고 저녁에는 스테이크 하우스가 된다.  
두 가게를 인수하여 각 가게의 사장이 정해진 시간대에 와서 장사하도록 한 것이다.  

메뉴판은 하나로 제공하기 위해서 두 가게 사장들에게 아래의 클래스를 제공하였다.

~~~java
public class MenuItem {
    String name;
    String description;
    boolean vegetarian;
    double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public double getPrice() {
        return price;
    }
}
~~~


#### v1
두 가게 사장에게 메뉴작성을 시켰더니 아래와 같이 작성해왔다.  

~~~java
public class PancakeHouseMenu {
    ArrayList<MenuItem> menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList<>();
        addMenuItem("King pancake set", "pancake with eggs and toast, coffee", true, 3.99);
        addMenuItem("Queen pancake set", "pancakw with sausage, milk", false, 2.99);
        addMenuItem("blueberry pancake", "pancake with blueberries", true, 1.99);
        addMenuItem("waffle", "waffle with apple syrup", true, 1.49);
    }

    public void addMenuItem(String name, String description, boolean vegetarian, double price){
        menuItems.add(new MenuItem(name, description, vegetarian, price));
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }
}

public class SteakHouseMenu {
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public SteakHouseMenu() {
        menuItems = new MenuItem[MAX_ITEMS];

        addMenuItem("black steak", "lamb", false, 45.99);
        addMenuItem("white steak", "duck", false, 24.99);
        addMenuItem("blue steak", "pig", false, 12.49);
    }

    public void addMenuItem(String name, String description, boolean vegetarian, double price){
        if (menuItems.length >= MAX_ITEMS) {
            throw new RuntimeException("menu is full");
        }

        menuItems[numberOfItems] = new MenuItem(name, description, vegetarian, price);
        numberOfItems++;
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }
}
~~~

같은 MenuItem을 주었건만, 팬케이크 사장은 ArrayList에 저장하고 스테이크 사장은 배열에 저장하였다.
이제 점심부터 저녁까지 일하는 웨이터는 손님이 메뉴를 보여달라고 하면, 어떻게 해야 할까?  

웨이터는 아래 요구를 수행할 수 있어야 한다.

~~~java
void printMenu();
void printLunchMenu();
void printDinnerMenu();
~~~

구현해보자. 

~~~java
public class Waiter {

    PancakeHouseMenu pancakeHouseMenu;
    SteakHouseMenu steakHouseMenu;

    public Waiter(PancakeHouseMenu pancakeHouseMenu, SteakHouseMenu steakHouseMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.steakHouseMenu = steakHouseMenu;
    }

    void printMenu() {
        printLunchMenu();
        printDinnerMenu();
    }

    void printLunchMenu() {
        for (int i = 0; i < pancakeHouseMenu.getMenuItems().size(); i++) {
            System.out.println("name: " + pancakeHouseMenu.getMenuItems().get(i).getName());
            System.out.println("description: " + pancakeHouseMenu.getMenuItems().get(i).getDescription());
            System.out.println("price: " + pancakeHouseMenu.getMenuItems().get(i).getPrice());
        }
    }

    void printDinnerMenu() {
        for (int i = 0; i < steakHouseMenu.numberOfItems; i++) {
            System.out.println("name: " + steakHouseMenu.getMenuItems()[i].getName());
            System.out.println("description: " + steakHouseMenu.getMenuItems()[i].getDescription());
            System.out.println("price: " + steakHouseMenu.getMenuItems()[i].getPrice());
        }
    }
}
~~~

각 가게 사장들이 서로 다른 컬랙션에 저장하다보니, 웨이터(클라이언트) 입장에서 죽을맛이다.  
구체적으로 아래의 것들이 죽을맛이다.

~~~
- PancakeHouseMenu, SteakHouseMenu 구체 클래스에 의존도가 심하다.
- PancakeHouseMenu, SteakHouseMenu 클래스의 MenuItem을 보관하는 컬랙션의 구조를 알아야 한다.
- PancakeHouseMenu, SteakHouseMenu 클래스의 컬랙션구조에 따라 MenuItem 조회로직을 직접 구현해야 한다.
~~~

가게 사장들의 코드를 수정하지 않고, 클라이언트가 편해질 방법은 없을까?


#### v2
웨이터 입장에서는 두 클래스가 MenuItem을 어떤 컬랙션에 보관하는지 조금도 알 바 아니다.   
다만 MenuItem을 달라고 하면 받아길 바랄 뿐이다.  
두 클래스에 아래의 두 메서드를 추가해보자.

~~~java
void hasNext();
MenuItem next();
~~~

팬케이크는 아래와 같이 구현하였다. 

~~~java
    boolean hasNext() {
        return position < menuItems.size();
    }

    MenuItem next() {
        MenuItem menuItem = menuItems.get(position++);
        return menuItem;
    }
~~~

스테이크는 아래와 같이 구현하였다.

~~~java
    boolean hasNext() {
        return position < numberOfItems;
    }

    MenuItem next() {
        return menuItems[position++];
    }
~~~

웨이터는 얼마나 편해졌을까?

~~~java
void printLunchMenu() {
    while(pancakeHouseMenu.hasNext()) {
        MenuItem menuItem = pancakeHouseMenu.next();
        System.out.println("name: " + menuItem.getName());
        System.out.println("description: " + menuItem.getDescription());
        System.out.println("price: " + menuItem.getPrice());
    }
}

void printDinnerMenu() {
    while (steakHouseMenu.hasNext()) {
        MenuItem menuItem = steakHouseMenu.next();
        System.out.println("name: " + menuItem.getName());
        System.out.println("description: " + menuItem.getDescription());
        System.out.println("price: " + menuItem.getPrice());
    }
}
~~~



#### v3
펜케이크 사장님, 스테이크 사장님도 짜증이 난다.  
이런 메뉴조회로직은 위임하는게 좋을 것 같다.

인터페이스로 분리해보자.

~~~java
public interface Iterator {
    boolean hasNext();
    MenuItem next();
}
~~~

펜케이스 사장님의 코드는 아래와 같이 변경될 것이다.

~~~java
//    boolean hasNext() {
//        return position < menuItems.size();
//    }
//
//    MenuItem next() {
//        MenuItem menuItem = menuItems.get(position++);
//        return menuItem;
//    }

public Iterator createIterator() {
    return new Iterator() {
        @Override
        public boolean hasNext() {
            return position < menuItems.size();
        }

        @Override
        public MenuItem next() {
            return menuItems.get(position++);
        }
    };
}
~~~


#### v4
익명클래스로 구현하기 보다는 제대로 해보자.

~~~java
public interface Iterator {
    boolean hasNext();
    MenuItem next();
}

public class ListIterator implements Iterator {

    ArrayList<MenuItem> menuItems;
    int position = 0;

    public ListIterator(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return position < menuItems.size();
    }

    @Override
    public MenuItem next() {
        return menuItems.get(position++);
    }
}

public class ArrayIterator implements Iterator {

    MenuItem[] menuItems;
    int position = 0;

    public ArrayIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if (null == menuItems[position]) {
            return false;
        }

        return position < menuItems.length;
    }

    @Override
    public MenuItem next() {
        return menuItems[position++];
    }
}
~~~

펜케이크, 스테이크 사장님들의 코드는 아래와 같이 Iterator로 위임하게 된다.

~~~java
public class PancakeHouseMenu {
    ArrayList<MenuItem> menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList<>();
        addMenuItem("King pancake set", "pancake with eggs and toast, coffee", true, 3.99);
        addMenuItem("Queen pancake set", "pancake with sausage, milk", false, 2.99);
        addMenuItem("blueberry pancake", "pancake with blueberries", true, 1.99);
        addMenuItem("waffle", "waffle with apple syrup", true, 1.49);
    }

    public void addMenuItem(String name, String description, boolean vegetarian, double price){
        menuItems.add(new MenuItem(name, description, vegetarian, price));
    }

    public Iterator createIterator() {
        return new ListIterator(menuItems);
    }
}

public class SteakHouseMenu {
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public SteakHouseMenu() {
        menuItems = new MenuItem[MAX_ITEMS];

        addMenuItem("black steak", "lamb", false, 45.99);
        addMenuItem("white steak", "duck", false, 24.99);
        addMenuItem("blue steak", "pig", false, 12.49);
    }

    public void addMenuItem(String name, String description, boolean vegetarian, double price){
        if (numberOfItems >= MAX_ITEMS) {
            throw new RuntimeException("menu is full");
        }

        menuItems[numberOfItems] = new MenuItem(name, description, vegetarian, price);
        numberOfItems++;
    }

    public Iterator createIterator() {
        return new ArrayIterator(menuItems);
    }
}
~~~

웨이터는 아래와 같이 변하겠다.

~~~java
public class Waiter {

    PancakeHouseMenu pancakeHouseMenu;
    SteakHouseMenu steakHouseMenu;

    public Waiter(PancakeHouseMenu pancakeHouseMenu, SteakHouseMenu steakHouseMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.steakHouseMenu = steakHouseMenu;
    }

    void printMenu() {
        printLunchMenu();
        printDinnerMenu();
    }

    void printLunchMenu() {
        Iterator iterator = pancakeHouseMenu.createIterator();

        while(iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            System.out.println("name: " + menuItem.getName());
            System.out.println("description: " + menuItem.getDescription());
            System.out.println("price: " + menuItem.getPrice());
        }
    }

    void printDinnerMenu() {
        Iterator iterator = steakHouseMenu.createIterator();

        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            System.out.println("name: " + menuItem.getName());
            System.out.println("description: " + menuItem.getDescription());
            System.out.println("price: " + menuItem.getPrice());
        }
    }
}
~~~


#### v5
웨이터 입장에서는 이제 팬케이크, 스테이크 클래스를 몰라도 될 것 같다.  
createIterator의 인터페이스를 만들고 펜케이크, 스테이크 클래스가 상속하게 하자.

~~~java
public interface Menu {
    Iterator createIterator();
}
~~~

펜케이크, 스테이크 클래스에서 구현해보자.

~~~java
public class PancakeHouseMenu implements Menu{
    ArrayList<MenuItem> menuItems;

    ...

    @Override
    public Iterator createIterator() {
        return new ListIterator(menuItems);
    }
}

public class SteakHouseMenu implements Menu {
    MenuItem[] menuItems;

    ...
    
    @Override
    public Iterator createIterator() {
        return new ArrayIterator(menuItems);
    }
}
~~~

웨이터 코드는 아래와 같이 간결화된다.

~~~java
public class Waiter {

    ArrayList<Menu> menuItems;
    
    public Waiter(ArrayList<Menu> menuItems) {
        this.menuItems = menuItems;
    }

    void printMenu() {
        Iterator iterator = menuItems.iterator(); // java.util.Iterator
        while (iterator.hasNext()) {
            com.example.patterns.J_Iterator.v5.Iterator menuIterator = ((Menu) iterator.next()).createIterator();
            while(menuIterator.hasNext()) {
                MenuItem menuItem = menuIterator.next();
                System.out.println("name: " + menuItem.getName());
                System.out.println("description: " + menuItem.getDescription());
                System.out.println("price: " + menuItem.getPrice());
            }
        }
    }
}
~~~

클라이언트 코드는 아래와 같다.

~~~
@Test
void waiter() {
    PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
    SteakHouseMenu steakHouseMenu = new SteakHouseMenu();
    Waiter waiter = new Waiter(new ArrayList<>(List.of(pancakeHouseMenu, steakHouseMenu)));

    waiter.printMenu();
}
~~~