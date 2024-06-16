package com.example.patterns.N_Visitor.v1;

public interface MailClient {
	void sendMail(String[] mailInfo);
	void receiveMail(String[] mailInfo);
	boolean accept(MailClientVisitor visitor);
}
