package com.example.object.ch3.v7;

import static org.junit.jupiter.api.Assertions.*;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class TaxableAdditionalRatePolicyTest {
	@Test
	void calculateCallFee() {
		DayOfWeekFeeCondition condition = new DayOfWeekFeeCondition(List.of(DayOfWeek.SATURDAY));

		RatePolicy policy = new TaxableAdditionalRatePolicy(
			new BasicRatePolicy(
				List.of(new FeeRule(
					new FeePerDuration(Duration.ofSeconds(10), 10),
					condition
			))), 1.1);

		DateTimeInterval interval = DateTimeInterval.of(
			LocalDateTime.of(2024, 3, 13, 15, 0, 0), // Wed
			LocalDateTime.of(2024, 3, 16, 17, 0, 0));

		Long result = policy.calculateCallFee(
			new Call(interval)
		);

		assertEquals(((Double)(10 * 6 * 60 * 17 * 1.1)).longValue(), result);
	}
}