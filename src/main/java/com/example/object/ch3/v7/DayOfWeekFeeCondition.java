package com.example.object.ch3.v7;

import java.time.DayOfWeek;
import java.util.List;
import java.util.stream.Collectors;

public class DayOfWeekFeeCondition implements FeeCondition{

	private List<DayOfWeek> dayOfWeeks;

	public DayOfWeekFeeCondition(List<DayOfWeek> dayOfWeeks) {
		this.dayOfWeeks = dayOfWeeks;
	}

	@Override
	public List<DateTimeInterval> splitTimeIntervals(DateTimeInterval interval) {
		return interval.splitByDay()
			.stream()
			.filter(each -> dayOfWeeks.contains(each.getFrom().getDayOfWeek()))
			.collect(Collectors.toList());
	}
}
