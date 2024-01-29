package com.example.object.ch2.v1;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public class Screening {
	private Movie movie;
	private int sequence;
	private LocalDateTime startTime;
	private LocalDateTime endTime;

	public Reservation reserve(int count) {
		return new Reservation(
			this
		, movie.calculateFee(this)
		, count);
	}

	public int getSequence() {
		return sequence;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}
}
