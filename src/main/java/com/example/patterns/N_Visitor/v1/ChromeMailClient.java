package com.example.patterns.N_Visitor.v1;

public class ChromeMailClient implements MailClient{
	@Override
	public void sendMail(String[] mailInfo) {

	}

	@Override
	public void receiveMail(String[] mailInfo) {

	}

	@Override
	public boolean accept(MailClientVisitor visitor) {
		visitor.visit(this);
		return true;
	}
}
