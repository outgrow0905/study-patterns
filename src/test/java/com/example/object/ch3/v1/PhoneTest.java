package com.example.object.ch3.v1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class PhoneTest {
	@Test
	void calculateFee() {
		Call call = new Call(
			LocalDateTime.of(2024, 1, 1, 12, 10, 0),
			LocalDateTime.of(2024, 1, 1, 12, 20, 10));
		Phone phone = new Phone(10L, Duration.ofSeconds(10));
		phone.call(call);

		assertEquals(610, phone.calculateFee());
	}
}