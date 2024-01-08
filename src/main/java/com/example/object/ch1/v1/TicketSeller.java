package com.example.object.ch1.v1;

public class TicketSeller {
	private TicketOffice ticketOffice;

	public TicketSeller(TicketOffice ticketOffice) {
		this.ticketOffice = ticketOffice;
	}

	public Ticket sellTicket(Invitation invitation, Long amount) {
		return ticketOffice.sellTicket(amount);
	}

	public Long getTicketPrice() {
		return ticketOffice.getTicketFee();
	}
}
