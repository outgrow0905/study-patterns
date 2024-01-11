package com.example.object.ch2.v1;

public class Reservation {
	private Screening screening;
	private long fee;
	private int count;

	public long getTotalFee() {
		return fee * count;
	}
}