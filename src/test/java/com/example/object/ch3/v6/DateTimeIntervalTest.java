package com.example.object.ch3.v6;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class DateTimeIntervalTest {
	@Test
	void toDays() {
		// 1일 2시간 경과
		LocalDateTime t1 = LocalDateTime.of(2024, 3, 13, 10, 0, 0);
		LocalDateTime t2 = LocalDateTime.of(2024, 3, 14, 22, 0, 0);
		assertEquals(1, Duration.between(t1, t2).toDays());

		// 22시간 경과
		t1 = LocalDateTime.of(2024, 3, 13, 1, 0, 0);
		t2 = LocalDateTime.of(2024, 3, 13, 23, 0, 0);
		assertEquals(0, Duration.between(t1, t2).toDays());

		// 1일 23시간 경과
		t1 = LocalDateTime.of(2024, 3, 13, 22, 0, 0);
		t2 = LocalDateTime.of(2024, 3, 15, 21, 0, 0);
		assertEquals(1, Duration.between(t1, t2).toDays());
	}

	@Test
	void splitByDays() {
		// 1일 23시간 경과
		LocalDateTime from = LocalDateTime.of(2024, 3, 13, 22, 0, 0);
		LocalDateTime to = LocalDateTime.of(2024, 3, 15, 21, 0, 0);

		DateTimeInterval dateTimeInterval = DateTimeInterval.of(from, to);
		List<DateTimeInterval> dateTimeIntervals = dateTimeInterval.splitByDay();

		log.info("date: {}", dateTimeIntervals.size());
	}
}