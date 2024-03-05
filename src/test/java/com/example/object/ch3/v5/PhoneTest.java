package com.example.object.ch3.v5;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class PhoneTest {
	@Test
	void calculateFeeByFixedDiscountPolicy() {
		Call call = new Call(
			LocalDateTime.of(2024, 1, 1, 12, 10, 0),
			LocalDateTime.of(2024, 1, 1, 12, 20, 10));

		Phone phone = new Phone(new FixedDiscountPolicy(10L, Duration.ofSeconds(10)));
		phone.call(call);

		assertEquals(610, phone.calculateFee());
	}

	@Test
	void calculateFeeByFixedDiscountPolicyAndTaxablePolicy() {
		Call call = new Call(
			LocalDateTime.of(2024, 1, 1, 12, 10, 0),
			LocalDateTime.of(2024, 1, 1, 12, 20, 10));

		Phone phone = new Phone(
			new TaxablePolicy(new FixedDiscountPolicy(10L, Duration.ofSeconds(10)), 1.1));
		phone.call(call);

		assertEquals(610 + 61, phone.calculateFee());
	}

	@Test
	void calculateFeeByTimeOfTheDayDiscountPolicy() {
		Call call1 = new Call(
			LocalDateTime.of(2024, 1, 1, 22, 10, 0),
			LocalDateTime.of(2024, 1, 1, 22, 11, 0));

		Call call2 = new Call(
			LocalDateTime.of(2024, 1, 1, 7, 10, 0),
			LocalDateTime.of(2024, 1, 1, 7, 11, 0));

		Phone phone = new Phone(new TimeOfTheDayDiscountPolicy(5L, 10L, Duration.ofSeconds(10)));
		phone.call(call1);
		phone.call(call2);

		assertEquals(60 + 30, phone.calculateFee());
	}

	@Test
	void calculateFeeByTimeOfTheDayDiscountPolicyAndTaxablePolicy() {
		Call call1 = new Call(
			LocalDateTime.of(2024, 1, 1, 22, 10, 0),
			LocalDateTime.of(2024, 1, 1, 22, 11, 0));

		Call call2 = new Call(
			LocalDateTime.of(2024, 1, 1, 7, 10, 0),
			LocalDateTime.of(2024, 1, 1, 7, 11, 0));

		Phone phone = new Phone(
			new TaxablePolicy(new TimeOfTheDayDiscountPolicy(5L, 10L, Duration.ofSeconds(10)), 1.1));
		phone.call(call1);
		phone.call(call2);

		assertEquals(60 + 6 + 30 + 3, phone.calculateFee());
	}
}