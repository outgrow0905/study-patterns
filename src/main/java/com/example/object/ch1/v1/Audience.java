package com.example.object.ch1.v1;

public class Audience {
	private Bag bag;

	public Audience(Bag bag) {
		this.bag = bag;
	}

	public void buyTicket(TicketSeller ticketSeller) {
		if (bag.hasInvitation()) {
			Ticket ticket = ticketSeller.sellTicket(bag.getInvitation(), null);
			bag.setTicket(ticket);
			return;
		}

		Long ticketPrice = ticketSeller.getTicketPrice();
		bag.minusAmount(ticketPrice);
		Ticket ticket = ticketSeller.sellTicket(null, ticketPrice);
		bag.setTicket(ticket);
	}
}
