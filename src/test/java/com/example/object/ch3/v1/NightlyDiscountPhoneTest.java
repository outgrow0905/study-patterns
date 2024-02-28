package com.example.object.ch3.v1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class NightlyDiscountPhoneTest {

	@Test
	void calculateFee() {
		Call call1 = new Call(
			LocalDateTime.of(2024, 1, 1, 22, 10, 0),
			LocalDateTime.of(2024, 1, 1, 22, 11, 0));

		Call call2 = new Call(
			LocalDateTime.of(2024, 1, 1, 7, 10, 0),
			LocalDateTime.of(2024, 1, 1, 7, 11, 0));

		NightlyDiscountPhone phone = new NightlyDiscountPhone(5L, 10L, Duration.ofSeconds(10));
		phone.call(call1);
		phone.call(call2);

		assertEquals(90, phone.calculateFee());
	}

}