package com.example.patterns.D_Factory.button.v1;

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
