package com.example.object.ch3.v7;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class TimeOfTheDayFeeConditionTest {
	@Test
	void splitTimeIntervals() {
		DateTimeInterval interval = DateTimeInterval.of(
			LocalDateTime.of(2024, 3, 13, 15, 0, 0),
			LocalDateTime.of(2024, 3, 14, 17, 0, 0));

		TimeOfTheDayFeeCondition condition = new TimeOfTheDayFeeCondition(
			LocalTime.of(12, 0),
			LocalTime.of(18, 0)
		);

		List<DateTimeInterval> dateTimeIntervals = condition.splitTimeIntervals(interval);

		log.info("result: {}", dateTimeIntervals);
	}
}