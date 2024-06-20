#### Factory Pattern (example Button)
#### v1
팩토리 패턴의 구조를 복습해보자.  
버튼이라는 클래스가 있고 이 클래스는 `html`, `windows` 등 여러 환경에서 사용된다.  
운영체제에 따라 생성방식이 달라져야하기 때문에 기본 `Button` 인터페이스를 운영체제에 따라 상속해서 생성한다.

~~~java
public interface Button {
	void render();
	void onClick();
}

public class HtmlButton implements Button{
	public void render() {
		System.out.println("<button>Test Button</button>");
		onClick();
	}

	public void onClick() {
		System.out.println("Click! Button says - 'Hello World!'");
	}
}

public class WindowsButton implements Button{
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	JButton button;

	@Override
	public void render() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel("Hello World!");
		label.setOpaque(true);
		label.setBackground(new Color(235, 233, 126));
		label.setFont(new Font("Dialog", Font.BOLD, 44));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		frame.getContentPane().add(panel);
		panel.add(label);
		onClick();
		panel.add(button);

		frame.setSize(320, 200);
		frame.setVisible(true);
		onClick();
	}

	@Override
	public void onClick() {
		button = new JButton("Exit");
		button.addActionListener(e -> {
			frame.setVisible(false);
			System.exit(0);
		});
	}
}
~~~

이를 사용하는곳은 `Dialog`라는 클래스이다.  
이 클래스의 역할은 `Button` 인터페이스르 가지고 수많은 메서드를 제공한다.  
`Button`의 실제 구현체가 `html` 이든 `windows` 이든 관계없이 제공하는 메서드가 많다.  
`Dialog`의 역할이 `Button`을 만들어내는 `factory`가 아니라는 의미이다.  

마치 아래의 예시와 같다.  

~~~java
public abstract class Dialog {
	void functionA() {
		System.out.println("Dialog functionA");
	}

	void functionB() {
		System.out.println("Dialog functionB");
	}

	void functionC() {
		System.out.println("Dialog functionC");
	}

	abstract Button createButton();
}
~~~

`functionA`, `functionB`는 `Button`의 메스드를 활용한 작업일 수 있고,
나머지 `functionC`부터 `functionZ`까지는 `Button`과 아무런 관련이 없는 메서드일 수 있다.  





#### Reference 
- https://refactoring.guru/ko/design-patterns/factory-method/java/example