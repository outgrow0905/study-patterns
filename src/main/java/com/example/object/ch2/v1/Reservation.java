package com.example.object.ch2.v1;

import lombok.ToString;

@ToString
public class Reservation {
	private Screening screening;
	private Long fee;
	private Integer count;
	private Long totalFee;

	public Long getTotalFee() {
		return this.fee * this.count;
	}

	public Reservation(Screening screening, Long fee, Integer count) {
		this.screening = screening;
		this.fee = fee;
		this.count = count;
		this.totalFee = getTotalFee();
	}
}