#### Command
리모컨 회사 사장이 되어보자.  
수많은 가전업체에서 우리회사의 리모컨을 사용하고 싶어 한다.  
TV, 에어컨, 냉장고 등 여러 회사에서 우리 리모컨을 사용하지만, 사실 같은 리모컨이다.  
같은 리모컨이지만 TV를 켜고 끌 수 있는 기능, 에어컨을 켜고 끌 수 있는 기능, 냉장고를 열고 닫는 기능을 넣은 것이다.  
버튼은 두 개 뿐이다. 


#### v1
에어컨, 냉장고, tv 클래스는 아래와 같다. 

~~~java
public class AirConditioner {
    public void on() {
        System.out.println("turn on the air conditioner");
    }

    public void off() {
        System.out.println("turn off the air conditioner");
    }
}

public class Refrigerator {
    public void open() {
        System.out.println("open the refrigerator");
    }

    public void close() {
        System.out.println("close the refrigerator");
    }
}

public class Television {
    public void on() {
        System.out.println("turn on the tv");
    }

    public void off() {
        System.out.println("turn off the tv");
    }
}
~~~

에어컨 리모컨을 만들어보자.

~~~java
public class RemoteController {
    
    private AirConditioner airConditioner;

    public RemoteController(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    public void turnOnAirConditioner() {
        this.airConditioner.on();
    }
    
    public void turnOffAirConditioner() {
        this.airConditioner.on();
    }
}
~~~

이러면, 가전의 종류마다 리모컨 클래스를 새로 만들어야 한다. 이건 아니지.
커맨드 패턴을 사용할 때이다.

#### v2
~~~java
public interface Command {
    void execute();
}

public class RemoteController {

    private Command button1;
    private Command button2;

    public RemoteController(Command button1, Command button2) {
        this.button1 = button1;
        this.button2 = button2;
    }

    public void button1Pressed() {
        this.button1.execute();
    }

    public void button2Pressed() {
        this.button2.execute();
    }
}
~~~

느낌이 오는가?   
Command를 구현한 객체를 리모컨에 넣어주기만 하면 execute 메서드 호출을 통해 어떤 행동이든 할 수 있게 되었다.  
리모컨은 에어컨, 냉장고, tv 어떤 클래스에도 의존하지 않고 오로지 Command 인터페이스에 의존한다.

에어컨을 다시 구현해보자.

~~~java
public class TurnOnAirConditionerCommand implements Command {

    private AirConditioner airConditioner;

    public TurnOnAirConditionerCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        this.airConditioner.on();
    }
}

public class TurnOffAirConditionerCommand implements Command{
    private AirConditioner airConditioner;

    public TurnOffAirConditionerCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        this.airConditioner.off();
    }
}
~~~

클라이언트는 아래와 같을 것이다.

~~~java
class RemoteControllerTest {
    @Test
    void commandPattern() {
        AirConditioner airConditioner = new AirConditioner();

        RemoteController airConditionerRemoteController =
                new RemoteController(
                        new TurnOnAirConditionerCommand(airConditioner),
                        new TurnOffAirConditionerCommand(airConditioner));

        airConditionerRemoteController.button1Pressed();
        airConditionerRemoteController.button2Pressed();
    }
}
~~~


#### v3
리모컨 장사가 잘되어서 신제품을 개발하였다.  
생김새는 똑같다. 하지만, 하나의 여러개의 명령어를 저장할 수 있는 리모컨이다.  
업체들은 신기해했지만, 사실 기존의 리모컨클래스에서 변경된 코드는 한줄도 없다.  

버튼1을 누르면 에어컨이 켜지고 냉장고 문이 열리고,
버튼2를 누르면 에어컨이 꺼지고 냉장고문이 닫히는 리모컨을 만들어보자.  

~~~java
public class MegaCommand implements Command {
    private List<Command> commands;

    public MegaCommand(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }
}
~~~

클라이언트 코드는 아래와 같다.

~~~java
class RemoteControllerTest {
@Test
void megaCommand() {
    AirConditioner airConditioner = new AirConditioner();
    Refrigerator refrigerator = new Refrigerator();

    RemoteController remoteController =
            new RemoteController(
                    new MegaCommand(
                            Lists.newArrayList(
                                    new TurnOnAirConditionerCommand(airConditioner),
                                    new OpenRefrigeratorCommand(refrigerator)
                            )),
                    new MegaCommand(
                            Lists.newArrayList(
                                    new TurnOffAirConditionerCommand(airConditioner),
                                    new CloseRefrigeratorCommand(refrigerator)
                            ))
            );

     remoteController.button1Pressed();
     remoteController.button2Pressed();
    }
}
~~~

#### v4
혼자 풀어보라.   
리모컨에 버튼 하나만 누르면 이전 상태로 되돌릴 수 있는 되돌리기 버튼을 추가해보자.

~~~java
// hint
public interface Command {
    void execute();
    void undo();
}
~~~