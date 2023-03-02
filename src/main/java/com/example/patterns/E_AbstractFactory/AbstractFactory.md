#### Abstract Factory
컴퓨터를 판매하는 판매상이 되어보자.  
컴퓨터는 모니터, 키보드, 마우스로 구성되어 있다.
삼섬, LG 두 가지 컴퓨터를 판매하며,  
삼성컴퓨터는 삼성 모니터, 삼성 키보드, 삼성 마우스로 팔아야 한다.  
LG도 마찬가지이다.  

#### v1
코드를 그냥 짜면 아래와 같이 판매하게 될 것이다.

~~~java
public class ComputerSeller {
    public Computer orderComputer(String brand) {
        Computer computer = null;

        if ("samsung".equals(brand)) {
            computer = new Computer(
                    new SamsungMonitor(),
                    new SamsungKeyboard(),
                    new SamsungMouse());
        }

        if ("lg".equals(brand)) {
            computer = new Computer(
                    new LGMonitor(),
                    new LGKeyboard(),
                    new LGMouse());
        }

        if (null == computer) {
            throw new RuntimeException("we don't sell apple");
        }

        computer.examine();

        return computer;
    }
}
~~~


#### v2
v1을 팩토리 메서드 패턴으로 바꾸면 아래와 같을 것이다.

~~~java
public abstract class ComputerSeller {
    public Computer orderComputer() {
        Computer computer = getComputer();

        computer.examine();

        return computer;
    }

    abstract Computer getComputer();
}

public class SamsungComputerSeller extends ComputerSeller{
    @Override
    Computer getComputer() {
        return new Computer(
                new SamsungMonitor(),
                new SamsungKeyboard(),
                new SamsungMouse()
        );
    }
}
~~~



#### v3
v1을 추상 팩토리 패턴으로 바꾸면 아래와 같을 것이다.

Computer는 factory를 생성자로 주입받고,   
모니터, 키보드, 마우스를 factory로부터 주입받는 구조로 될 것이다.

~~~java
public class Computer {

    Monitor monitor;
    Keyboard keyboard;
    Mouse mouse;

    ComputerComponentFactory computerComponentFactory;

    public Computer(ComputerComponentFactory computerComponentFactory) {
        this.computerComponentFactory = computerComponentFactory;
    }

    public Computer() {
        this.monitor = computerComponentFactory.getMonitor();
        this.keyboard = computerComponentFactory.getKeyboard();
        this.mouse = computerComponentFactory.getMouse();
    }

    public void examine() {
        System.out.println("examine this computer's condition");
    }
}

public interface ComputerComponentFactory {
    Monitor getMonitor();
    Keyboard getKeyboard();
    Mouse getMouse();
}
~~~

삼성 팩토리를 예시로 살펴보자.

~~~java
public class SamsungComputerComponentFactory implements ComputerComponentFactory {
    @Override
    public Monitor getMonitor() {
        return new SamsungMonitor();
    }

    @Override
    public Keyboard getKeyboard() {
        return new SamsungKeyboard();
    }

    @Override
    public Mouse getMouse() {
        return new SamsungMouse();
    }
}
~~~

클라이언트는 아래와 같을 것이다.

~~~java
public class ComputerSeller {

    ComputerComponentFactory computerComponentFactory;

    public ComputerSeller(ComputerComponentFactory computerComponentFactory) {
        this.computerComponentFactory = computerComponentFactory;
    }

    public Computer orderComputer() {
        Computer computer = new Computer(computerComponentFactory);

        computer.examine();

        return computer;
    }
}
~~~