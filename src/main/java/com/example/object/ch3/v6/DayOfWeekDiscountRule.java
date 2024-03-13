package com.example.object.ch3.v6;

import java.time.DayOfWeek;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DayOfWeekDiscountRule {
	private List<DayOfWeek> dayOfWeeks;
	private Duration duration;
	private long amount;

	public long calculateFee(DateTimeInterval interval) {
		if (dayOfWeeks.contains(interval.getFrom().getDayOfWeek())) {
			return amount * interval.duration().getSeconds() / duration.getSeconds();
		}
		return 0l;
	}
}
