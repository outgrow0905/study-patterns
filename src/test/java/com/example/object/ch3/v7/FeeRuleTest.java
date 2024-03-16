package com.example.object.ch3.v7;

import static org.junit.jupiter.api.Assertions.*;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class FeeRuleTest {
	@Test
	void timeOfTheDayFeeCondition() {
		FeeRule feeRule = new FeeRule(
			new FeePerDuration(Duration.ofSeconds(10), 10),
			new TimeOfTheDayFeeCondition(
				LocalTime.of(12, 0),
				LocalTime.of(18, 0)
			)
		);

		long result = feeRule.calculateFeeByRule(DateTimeInterval.of(
			LocalDateTime.of(2024, 3, 13, 15, 0, 0),
			LocalDateTime.of(2024, 3, 14, 17, 0, 0)));

		assertEquals(10 * 6 * 60 * 8, result);
	}

	@Test
	void dayOfWeekFeeCondition() {
		FeeRule feeRule = new FeeRule(
			new FeePerDuration(Duration.ofSeconds(10), 10),
			new DayOfWeekFeeCondition(
				List.of(DayOfWeek.SATURDAY)
			)
		);

		long result = feeRule.calculateFeeByRule(DateTimeInterval.of(
			LocalDateTime.of(2024, 3, 13, 15, 0, 0), // Wed
			LocalDateTime.of(2024, 3, 16, 17, 0, 0)));// Sat

		assertEquals(10 * 6 * 60 * 17, result);
	}
}