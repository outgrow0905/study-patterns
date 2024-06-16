package com.example.patterns.N_Visitor.v1;

public class MacMailClientVisitor implements MailClientVisitor {
	@Override
	public void visit(WhaleMailClient mailClient) {
		System.out.println("mac mail client from whale mac client");
	}

	@Override
	public void visit(ChromeMailClient mailClient) {
		System.out.println("mac mail client from chrome mac client");
	}
}