package com.example.object.ch3.v7;

import java.time.Duration;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FeePerDuration {
	private Duration duration;
	private long amount;

	public long calculateFeePerDuration(Duration duration) {
		return duration.getSeconds() / this.duration.getSeconds() * amount;
	}
}
