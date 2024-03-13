package com.example.object.ch3.v6;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class TimeOfTheDayDiscountPolicyTest {
	@Test
	void calculateCallFee() {
		Call call = new Call(
			DateTimeInterval.of(
				LocalDateTime.of(2024, 3, 13, 18, 0, 0),
				LocalDateTime.of(2024, 3, 13, 23, 0, 0))
		);

		TimeOfTheDayDiscountPolicy policy = new TimeOfTheDayDiscountPolicy(
			List.of(LocalTime.of(0, 0, 0), LocalTime.of(19, 0, 0))
			, List.of(LocalTime.of(19, 0, 0), LocalTime.MAX)
			, List.of(Duration.ofSeconds(10), Duration.ofSeconds(10))
			, List.of(10l, 5l)
		);


		log.info("result: {}", policy.calculateCallFee(call));
		// 시간 * 분 * 10초로 나눈 단위 * 금액
		assertEquals((1 * 60 * 6 * 10) + (4 * 60 * 6 * 5), policy.calculateCallFee(call));
	}
}