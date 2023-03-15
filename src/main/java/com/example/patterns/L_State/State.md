#### State
뽑기기계를 만들어보자.  
동전을 넣으고 래버를 돌리면 구슬이 나오는 기계이다.  
돈을 넣었다가 레버를 돌리지 않고 환불되는 기능도 있다.  



#### v1
디자인 패턴없이 구현하면 아래와 같은 뽑기기계가 탄생할 것이다.

~~~java
public class GumballMachine {
    final static int SOLD_OUT = 0;
    final static int NO_COIN = 1;
    final static int HAS_COIN = 2;
    final static int SOLD = 3;

    int state = SOLD_OUT;
    int count = 0;

    public GumballMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = NO_COIN;
        }
    }

    public void insertCoin() {
        if (state == HAS_COIN) {
            System.out.println("you already inserted coin.");
        } else if (state == NO_COIN) {
            state = HAS_COIN;
            System.out.println("you inserted coin.");
        } else if (state == SOLD_OUT) {
            System.out.println("no gumball now.");
        } else if (state == SOLD) {
            System.out.println("gumball is coming out. please wait.");
        }
    }

    public void ejectCoin() {
        if (state == HAS_COIN) {
            state = NO_COIN;
            System.out.println("coin is ejected.");
        } else if (state == NO_COIN) {
            System.out.println("no coin to eject.");
        } else if (state == SOLD_OUT) {
            System.out.println("no gumball now. no coin to eject.");
        } else if (state == SOLD) {
            System.out.println("gumball is coming out. can't eject now.");
        }
    }

    public void turnLever() {
        if (state == HAS_COIN) {
            state = SOLD;
            System.out.println("you turned lever. gumball is coming out.");
            dispense();
        } else if (state == NO_COIN) {
            System.out.println("insert coin first.");
        } else if (state == SOLD_OUT) {
            System.out.println("no gumball now. sorry.");
        } else if (state == SOLD) {
            System.out.println("gumball is coming out. please wait.");
        }
    }

    public void dispense() {
        if (state == HAS_COIN) {
            System.out.println("turn lever first.");
        } else if (state == NO_COIN) {
            System.out.println("insert coin first.");
        } else if (state == SOLD_OUT) {
            System.out.println("no gumball now.");
        } else if (state == SOLD) {
            count--;
            if (count == 0) {
                System.out.println("gumball is coming out. all gumballs are sold out.");
                state = SOLD_OUT;
            } else {
                System.out.println("gumball is coming out.");
                state = NO_COIN;
            }
        }
    }
}
~~~



#### v2
새로운 기능을 넣어서 1/10 확률로 gumball 2개가 반환되도록 하려면 어떻게 고쳐야 할까?

~~~java
public void turnLever(){
        if (state == HAS_COIN) {
            if (winner()) {
                state=WINNNER_SOLD; 
            } else {
                state=SOLD;   
            };
        }
}
~~~

위와 같은 방향으로 고쳐야 하곘다. 이게 끝일까?  
dispense() 메서드애도 if (state == WINNER_SOLD) 가 추가되어야 할 것이다.  
그리고 모든 다른 메서드에도 if문이 추가될 것이다. 디자인 패턴을 적용해보자.

~~~java
public interface State {
    void insertCoin();
    void ejectCoin();
    void turnLever();
    void dispense();
}
~~~

이를 상속받아 상태별 클래스를 만들어보자.

~~~java
public class SoldState implements State {
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("gumball is coming out. please wait.");
    }

    @Override
    public void ejectCoin() {
        System.out.println("gumball is coming out. can't eject now.");
    }

    @Override
    public void turnLever() {
        System.out.println("gumball is coming out. please wait.");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        System.out.println("gumball is coming out.");

        if (gumballMachine.isEmpty()) {
            gumballMachine.setCurrentStatus(gumballMachine.getSoldOutStatus());
            System.out.println("all gumball sold out.");
        } else {
            gumballMachine.setCurrentStatus(gumballMachine.getNoCoinStatus());
        }
    }
}
~~~

나머지 state는 직접 구현해보고,  
이제 GumbleMachine을 다시 작성해보자.

~~~java
public class GumballMachine {

    State soldOutStatus;
    State noCoinStatus;
    State soldStatus;
    State hasCoinStatus;

    State currentStatus = soldOutStatus;

    int count = 0;

    public GumballMachine(int count) {
        soldOutStatus = new SoldOutState(this);
        noCoinStatus = new NoCoinState(this);
        soldStatus = new SoldState(this);
        hasCoinStatus = new HasCoinState(this);

        this.count = count;
        if (count > 0) {
            currentStatus = noCoinStatus;
        }
    }

    public void insertCoin() {
        currentStatus.insertCoin();
    }

    public void ejectCoin() {
        currentStatus.ejectCoin();
    }

    public void turnLever() {
        currentStatus.turnLever();
        currentStatus.dispense();
    }

    public void setCurrentStatus(State currentStatus) {
        this.currentStatus = currentStatus;
    }

    public State getSoldOutStatus() {
        return soldOutStatus;
    }

    public State getNoCoinStatus() {
        return noCoinStatus;
    }

    public State getSoldStatus() {
        return soldStatus;
    }

    public State getHasCoinStatus() {
        return hasCoinStatus;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void releaseBall() {
        System.out.println("a gumball is comes rolling out the slot.");
        if (count > 0) {
            count--;
        }
    }
}
~~~

테스트코드로 정상작동을 확인해보자.

~~~java
@Test
void gumballMachine() {
    GumballMachine gumballMachine = new GumballMachine(5);

    gumballMachine.insertCoin();
    gumballMachine.turnLever();

    System.out.println("====================");

    gumballMachine.insertCoin();
    gumballMachine.ejectCoin();
    gumballMachine.turnLever(); // fail

    System.out.println("====================");

    gumballMachine.insertCoin();
    gumballMachine.turnLever();
    gumballMachine.insertCoin();
    gumballMachine.turnLever();
    gumballMachine.ejectCoin(); // fail

    System.out.println("====================");

    gumballMachine.insertCoin();
    gumballMachine.insertCoin(); // fail
    gumballMachine.turnLever();
    gumballMachine.insertCoin();
    gumballMachine.turnLever();
    gumballMachine.insertCoin(); // fail
    gumballMachine.turnLever(); // fail
}
~~~