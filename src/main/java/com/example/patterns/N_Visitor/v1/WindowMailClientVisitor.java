package com.example.patterns.N_Visitor.v1;

public class WindowMailClientVisitor implements MailClientVisitor {
	@Override
	public void visit(WhaleMailClient mailClient) {
		System.out.println("window mail client from whale mail client");
	}

	@Override
	public void visit(ChromeMailClient mailClient) {
		System.out.println("window mail client from chrome mail client");
	}
}
