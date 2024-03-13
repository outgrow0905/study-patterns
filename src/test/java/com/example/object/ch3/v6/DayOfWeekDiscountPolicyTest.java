package com.example.object.ch3.v6;

import static org.junit.jupiter.api.Assertions.*;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

class DayOfWeekDiscountPolicyTest {
	@Test
	void calculateCallFee() {
		Call call = new Call(
			// 2024.3.13 Wed
			DateTimeInterval.of(
				LocalDateTime.of(2024, 3, 13, 18, 0, 0),
				LocalDateTime.of(2024, 3, 14, 6, 0, 0))
		);

		DayOfWeekDiscountPolicy policy = new DayOfWeekDiscountPolicy(
			List.of(new DayOfWeekDiscountRule(
				List.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY),
				Duration.ofSeconds(10),
				10),
				new DayOfWeekDiscountRule(
					List.of(DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY),
					Duration.ofSeconds(10),
					5
				))
		);

		assertEquals(32399, policy.calculateCallFee(call));
	}
}