#### Factory
Factory를 사용하여 리팩토링을 해보자.


#### Scenario
먼저 예제 Node 객체들은 아래와 같다.

~~~java
public interface Node {
}

public class StringNode implements Node{
}

public class SpecialStringNode implements Node {
    Node node;

    public SpecialStringNode(Node node) {
        this.node = node;
    }
}
~~~

Node를 구현한 StringNode, SpecialStringNode가 있다.  
SpecialStringNode를 보니 아무래도 Decorator Pattern이 틀림없다.  
이제 이 클래스들이 어떻게 생성되는지 알아보자.


~~~java
public class Parser {
    private boolean doSpecialThing;

    public boolean isDoingSpecialThing() {
        return doSpecialThing;
    }

    public void setDoSpecialThing(boolean doSpecialThing) {
        this.doSpecialThing = doSpecialThing;
    }
}
~~~

먼저 Parser가 있다. boolean 변수 하나를 가지고 있다. 무언가 특별한 행동을 하는지여부를 관리하는 것으로 보인다.

~~~java
public class StringParser {
    Parser parser;

    public StringParser(Parser parser) {
        this.parser = parser;
    }

    public Node createStringNode() {
        return StringNode.createStringNode(parser.isDoingSpecialThing());
    }
}

public class StringNode implements Node {
    public static Node createStringNode(boolean isDoSpecialThing) {
        if (isDoSpecialThing) {
            return new StringNode();
        }

        return new SpecialStringNode(new StringNode());
    }
}
~~~

다음으로 StringParser가 있다. 위의 Parser를 변수로 가지고 있다.  
그리고, Parser의 doSpecialThing 변수를 StringNode로 전달하여 Node를 생성하는 createStringNode 메서드가 있다.  

StringNode를 살펴보니 여기서 Decorator Pattern을 통해 Node를 생성하는 팩토리메서드가 있다.

여기까지 살펴보니,  
StringParser 입장에서 Node를 생성하는데 아래와 같은 의존관계가 있는 것 같다.  
- 변수로 가지고 있는 Parser가 필요하다.  
- 특히, 변수로 가지고 있는 Parser의 특정 변수 doSpecialThing이 필요하다.

어떤 문제가 있는 것일까?  
만약, WonderfulStringNode가 추가된다고 가정해보자. 어디를 수정해야 할까?  

- Parser에 doWonderfulThing 변수가 추가되어야 할 것이다.
- Parser에 doWonderfulThing 변수의 getter/setter도 추가해야 한다.
- StringNode 입장에서 WonderfulStringNode를 생성하기 위해 createStringNode 팩토리메서드의 인터페이스도 수정해야 한다.
- 위의 변화에 따라 StringParser도 Parser의 doWonderfulThing을 createStringNode 메서드에 전달하기 위해 코드를 수정해야 한다.

여기까지의 테스트코드는 아래와 같다.

~~~java
@Test
void createNode() {
    // stringNode
    Parser parser = new Parser();
    parser.setDoSpecialThing(false);
    StringParser stringParser = new StringParser(parser);
    Node stringNode = stringParser.createStringNode();
    assertTrue(stringNode instanceof StringNode);

    // specialStringNode
    parser.setDoSpecialThing(true);
    Node specialStringNode = stringParser.createStringNode();
    assertTrue(specialStringNode instanceof SpecialStringNode);
}
~~~