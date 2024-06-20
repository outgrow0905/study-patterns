package com.example.patterns.D_Factory.button.v1;

public class HtmlButton implements Button{
	public void render() {
		System.out.println("<button>Test Button</button>");
		onClick();
	}

	public void onClick() {
		System.out.println("Click! Button says - 'Hello World!'");
	}
}
