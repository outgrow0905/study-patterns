package com.example.object.ch2.v1;

import java.time.LocalDateTime;

public class Screening {
	private Movie movie;
	private int sequence;
	private LocalDateTime startTime;
	private LocalDateTime endTime;

	public Reservation reserve(int count) {
		return null;
	}

	public int getSequence() {
		return sequence;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public Long getMovieFee() {
		return movie.getFee();
	}
}
