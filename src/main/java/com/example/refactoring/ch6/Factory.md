### Factory
Factory를 사용하여 리팩토링을 해보자.


### Scenario
#### v1
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
    String a;
    
    public StringParser(Parser parser) {
        this.parser = parser;
    }

    public Node createStringNode() {
        return StringNode.createStringNode(parser.isDoingSpecialThing(), a);
    }
}
~~~

다음으로 StringParser가 있다. 위의 Parser를 변수로 가지고 있다.  
그리고 StringParser 자체 인스턴스변수 a도 있다.
그리고, Parser의 doSpecialThing 변수와 인스턴스변수 a를 StringNode로 전달하여 Node를 생성하는 createStringNode 메서드가 있다.  

~~~java
public class StringNode implements Node {
    public static Node createStringNode(boolean isDoSpecialThing, String a) {
        if (isDoSpecialThing) {
            return new StringNode();
        }

        return new SpecialStringNode(new StringNode());
    }
}
~~~

StringNode를 살펴보니 여기서 Decorator Pattern을 통해 Node를 생성하는 팩토리메서드가 있다.  
(a는 아무것도 하지 않지만, StringParser와의 의존성을 위해 억지로 넣었다.)

여기까지 살펴보니,  
StringParser 입장에서 Node를 생성하는데 아래와 같은 의존관계가 있는 것 같다.  

~~~
- 변수로 가지고 있는 Parser가 필요하다.  
- 특히, 변수로 가지고 있는 Parser의 특정 변수 doSpecialThing이 필요하다.
~~~

어떤 문제가 있는 것일까?  
만약, WonderfulStringNode가 추가된다고 가정해보자. 어디를 수정해야 할까?  

~~~
- Parser에 doWonderfulThing 변수가 추가되어야 할 것이다.
- Parser에 doWonderfulThing 변수의 getter/setter도 추가해야 한다.
- StringNode 입장에서 WonderfulStringNode를 생성하기 위해 createStringNode 팩토리메서드의 인터페이스도 수정해야 한다.
- 위의 변화에 따라 StringParser도 Parser의 doWonderfulThing을 createStringNode 메서드에 전달하기 위해 코드를 수정해야 한다.
~~~

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


#### v2
위의 구조를 고치라고 한다면 어디서부터 고쳐야 할 지 쉽지 않다.  
책을 따라가보자.  
StringParser가 StringNode를 직접 호출하여 Node 객체를 생성하는 부분부터 고친다.  
StringNode가 아닌 NodeFactory를 만들어서 일단 StringNode와의 연관관계를 끊어보자.  

~~~java
public class NodeFactory {
    public Node createStringNode(boolean isDoingSpecialThing, String a) {
        if (isDoingSpecialThing) {
            return new SpecialStringNode(new StringNode());
        }

        return new StringNode();
    }
}

public class StringNode implements Node {
    ...
//    public static Node createStringNode(boolean isDoSpecialThing, String a) {
//        if (isDoSpecialThing) {
//            return new SpecialStringNode(new StringNode());
//        }
//
//        return new StringNode();
//    }
}
~~~

그리고 StringParser는 아래와 같이 변경하게 된다.

~~~java
public Node createStringNode() {
    NodeFactory nodeFactory = new NodeFactory();
    return nodeFactory.createStringNode(parser.isDoingSpecialThing(), a);
//  return StringNode.createStringNode(parser.isDoingSpecialThing(), a);
}
~~~

더 이상 변경할 수 있는것이 눈에 보이는가?  
솔직히 모르겠다. 책을 따라 좀더 해보자.  


#### v3
Parser의 doSpecialThing 변수를 아래의 객체로 변경한다.

~~~java
public class DoSpecialThingOption {
    
    private boolean doSpecialThing;

    public boolean isDoingSpecialThing() {
        return doSpecialThing;
    }

    public void setDoSpecialThing(boolean doSpecialThing) {
        this.doSpecialThing = doSpecialThing;
    }
}
~~~

Parser는 아래와 같이 기존 boolean 변수를 위의 객체로 변경한다.

~~~java
public class Parser {
//    private boolean doSpecialThing;
//
//    public boolean isDoingSpecialThing() {
//        return doSpecialThing;
//    }
//
//    public void setDoSpecialThing(boolean doSpecialThing) {
//        this.doSpecialThing = doSpecialThing;
//    }
    
    private DoSpecialThingOption doSpecialThingOption;

    public DoSpecialThingOption getDoSpecialThingOption() {
        return doSpecialThingOption;
    }

    public void setDoSpecialThingOption(DoSpecialThingOption doSpecialThingOption) {
        this.doSpecialThingOption = doSpecialThingOption;
    }
}
~~~

이렇게 변경하면 Parser의 isDoingSpecialThing 메서드를 사용하던 클라이언트인 StringParser의 코드도 변경해야 한다.

~~~java
public Node createStringNode() {
    NodeFactory nodeFactory = new NodeFactory();
    return nodeFactory.createStringNode(parser.getDoSpecialThingOption().isDoingSpecialThing(), a);
//  return nodeFactory.createStringNode(parser.isDoingSpecialThing(), a);
}
~~~

테스트코드는 아래와 같다.

~~~java
@Test
void createNode() {
    DoSpecialThingOption option = new DoSpecialThingOption();
    option.setDoSpecialThing(false);
    Parser parser = new Parser();
    parser.setDoSpecialThingOption(option);
    StringParser stringParser = new StringParser(parser);
    Node stringNode = stringParser.createStringNode();
    assertTrue(stringNode instanceof  StringNode);

    option.setDoSpecialThing(true);
    Node specialStringNode = stringParser.createStringNode();
    assertTrue(specialStringNode instanceof SpecialStringNode);
}
~~~

대관절 코드만 복잡해지고 개선된 부분이라고는 눈을 씻고 찾아봐도 모르겠다.

~~~java
public Node createStringNode() {
    NodeFactory nodeFactory = new NodeFactory();
    return nodeFactory.createStringNode(parser.getDoSpecialThingOption().isDoingSpecialThing(), a);
//  return nodeFactory.createStringNode(parser.isDoingSpecialThing(), a);
}
~~~

에서 ```nodeFactory.createStringNode(parser.getDoSpecialThingOption().isDoingSpecialThing(), a)```부분을 살펴보자.  
DoSpecialThingOption 객체에게 a 변수만 전달해주면 Node 객체를 만들수 있을 것 같다.  

#### v4
~~~java
public class DoSpecialThingOption {
    ...
    
    public Node createStringNode(String a) {
        return StringNode.createStringNode(doSpecialThing, a);
    }
}
~~~

이에 맞추어 StringParser도 고쳐보자.
~~~java
public Node createStringNode() {
    return parser.getDoSpecialThingOption().createStringNode(a);
//  NodeFactory nodeFactory = new NodeFactory();
//  return nodeFactory.createStringNode(parser.getDoSpecialThingOption().isDoingSpecialThing(), a);
}
~~~

#### v5
책을 읽으면서 여기가 가장 마법같았다.  
NodeFactory를 삭제하면서 DoSpecialThingOption의 이름을 NodeFactory로 바꾼다.

~~~java
public class NodeFactory {
    private boolean doSpecialThing;

    public boolean isDoingSpecialThing() {
        return doSpecialThing;
    }

    public void setDoSpecialThing(boolean doSpecialThing) {
        this.doSpecialThing = doSpecialThing;
    }

    public Node createStringNode(String a) {
        return StringNode.createStringNode(doSpecialThing, a);
    }
}
~~~

그리고 Parser도 이에 맞춰 변경한다.

~~~java
public class Parser {
//    private DoSpecialThingOption doSpecialThingOption;
//
//    public DoSpecialThingOption getDoSpecialThingOption() {
//        return doSpecialThingOption;
//    }
//
//    public void setDoSpecialThingOption(DoSpecialThingOption doSpecialThingOption) {
//        this.doSpecialThingOption = doSpecialThingOption;
//    }
    
    private NodeFactory nodeFactory;

    public NodeFactory getNodeFactory() {
        return nodeFactory;
    }

    public void setNodeFactory(NodeFactory nodeFactory) {
        this.nodeFactory = nodeFactory;
    }
}
~~~

StringParser는 아래처럼 하면서 마무리한다.

~~~java
public Node createStringNode() {
    return parser.getNodeFactory().createStringNode(a);
}
~~~

테스트코드는 아래와 같다.

~~~java
@Test
void createNode() {
    NodeFactory nodeFactory = new NodeFactory();
    nodeFactory.setDoSpecialThing(false);
    Parser parser = new Parser();
    parser.setNodeFactory(nodeFactory);
    StringParser stringParser = new StringParser(parser);
    Node stringNode = stringParser.createStringNode();
    assertTrue(stringNode instanceof StringNode);

    nodeFactory.setDoSpecialThing(true);
    Node specialStringNode = stringParser.createStringNode();
    assertTrue(specialStringNode instanceof SpecialStringNode);
}
~~~

### Summary
v1에서 제기했던 '만약 WonderfulStringNode가 추가된다면?'의 문제점을 다시 나열해보자.

~~~
- Parser에 doWonderfulThing 변수가 추가되어야 할 것이다.
    > NodeFactory에 doWonderfulThing 변수가 추가된다.
- Parser에 doWonderfulThing 변수의 getter/setter도 추가해야 한다.
    > NodeFactory에 doWonderfulThing 변수의 getter/setter를 추가한다.
- StringNode 입장에서 WonderfulStringNode를 생성하기 위해 createStringNode 팩토리메서드의 인터페이스도 수정해야 한다.
    > WonderfulStringNode를 생성하기 위해 NodeFactory의 로직을 수정한다.
- 위의 변화에 따라 StringParser도 Parser의 doWonderfulThing을 createStringNode 메서드에 전달하기 위해 코드를 수정해야 한다.
    > doWonderfulThing 변수는 NodeFactory에 있다. NodeFactory Setter를 통해 doWonderfulThing 변수를 세팅한다. 
~~~

대단하다.