package com.example.object.ch1.v1;

public class Bag {
	private Long amount;
	private Invitation invitation;
	private Ticket ticket;

	public Bag(Long amount) {
		this.amount = amount;
	}

	public Bag(Long amount, Invitation invitation) {
		this.amount = amount;
		this.invitation = invitation;
	}

	public void minusAmount(Long amount) {
		this.amount -= amount;
	}

	public boolean hasInvitation() {
		return this.invitation != null;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Invitation getInvitation() {
		return invitation;
	}
}
