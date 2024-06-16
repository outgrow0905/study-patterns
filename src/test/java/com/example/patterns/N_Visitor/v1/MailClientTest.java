package com.example.patterns.N_Visitor.v1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MailClientTest {
	@Test
	void sendMail() {
		MailClient chromeClient = new ChromeMailClient();
		MailClientVisitor windowVisitor = new WindowMailClientVisitor();
		MailClientVisitor macVisitor = new MacMailClientVisitor();
		chromeClient.accept(windowVisitor);
		chromeClient.accept(macVisitor);

		MailClient whaleClient = new WhaleMailClient();
		whaleClient.accept(windowVisitor);
		whaleClient.accept(macVisitor);
	}
}