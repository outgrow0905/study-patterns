package com.example.object.ch3.v7;

import static org.junit.jupiter.api.Assertions.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class DayOfWeekFeeConditionTest {

	@Test
	void splitTimeIntervals() {
		DateTimeInterval interval = DateTimeInterval.of(
			LocalDateTime.of(2024, 3, 13, 15, 0, 0), // Wed
			LocalDateTime.of(2024, 3, 16, 17, 0, 0));

		DayOfWeekFeeCondition condition = new DayOfWeekFeeCondition(List.of(DayOfWeek.WEDNESDAY, DayOfWeek.SATURDAY));

		List<DateTimeInterval> result = condition.splitTimeIntervals(interval);

		log.info("result: {}", result);
	}
}