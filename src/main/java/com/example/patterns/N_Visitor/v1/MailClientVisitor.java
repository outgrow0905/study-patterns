package com.example.patterns.N_Visitor.v1;

public interface MailClientVisitor {
	void visit(ChromeMailClient mailClient);
	void visit(WhaleMailClient mailClient);
}
