package com.example.object.ch3.v7;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TimeOfTheDayFeeCondition implements FeeCondition{
	private LocalTime from;
	private LocalTime to;

	@Override
	public List<DateTimeInterval> splitTimeIntervals(DateTimeInterval interval) {
		return interval.splitByDay()
			.stream()
			.filter(each -> from(each).isBefore(to(each)))
			.map(each -> DateTimeInterval.of(
				LocalDateTime.of(each.getFrom().toLocalDate(), from(each)),
				LocalDateTime.of(each.getFrom().toLocalDate(), to(each))
			))
			.collect(Collectors.toList());
	}

	private LocalTime from(DateTimeInterval interval) {
		return interval.getFrom().toLocalTime().isBefore(from) ?
			from :
			interval.getFrom().toLocalTime();
	}

	private LocalTime to(DateTimeInterval interval) {
		return interval.getTo().toLocalTime().isAfter(to) ?
			to :
			interval.getTo().toLocalTime();
	}
}
