package com.example.object.ch1.v1;

import java.util.ArrayList;
import java.util.List;

public class TicketOffice {
	private Long amount;
	private List<Ticket> tickets = new ArrayList<>();

	public TicketOffice(Long amount, List<Ticket> tickets) {
		this.amount = amount;
		this.tickets = tickets;
	}

	public void plusAmount(Long amount) {
		this.amount += amount;
	}

	public Long getTicketFee() {
		return tickets.get(0).getFee();
	}

	public Ticket sellTicket(Long amount) {
		plusAmount(amount);
		return tickets.remove(0);
	}
}
