package com.example.object.ch3.v7;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class DateTimeInterval {
	private LocalDateTime from;
	private LocalDateTime to;

	public static DateTimeInterval of(LocalDateTime from, LocalDateTime to) {
		return new DateTimeInterval(from, to);
	}

	public static DateTimeInterval toMidnight(LocalDateTime from) {
		return of(from, LocalDateTime.of(from.toLocalDate(), LocalTime.MAX));
	}

	public static DateTimeInterval fromMidnight(LocalDateTime to) {
		return of(LocalDateTime.of(to.toLocalDate(), LocalTime.MIN), to);
	}

	public static DateTimeInterval during(LocalDate date) {
		return of(LocalDateTime.of(date, LocalTime.MIN), LocalDateTime.of(date, LocalTime.MAX));
	}

	public Duration duration() {
		return Duration.between(from, to);
	}

	public List<DateTimeInterval> splitByDay() {
		if (days() > 0) {
			return splitByDay(days());
		}

		return List.of(this);
	}

	public List<DateTimeInterval> splitByDay(long days) {
		List<DateTimeInterval> result = new ArrayList<>();
		addFirstDay(result);
		addMiddleDays(result, days);
		addLastDay(result);
		return result;
	}

	private long days() {
		// Duration.toDays()는 만 24시간 기준으로 하므로 아래와 같이 00시로 설정하여 일수를 계산
		return Duration.between(from.toLocalDate().atStartOfDay(), to.toLocalDate().atStartOfDay()).toDays();
	}

	private void addFirstDay(List<DateTimeInterval> result) {
		result.add(toMidnight(from));
	}

	private void addMiddleDays(List<DateTimeInterval> result, long days) {
		for (int loop = 1; loop < days; loop++) {
			result.add(during(from.toLocalDate().plusDays(loop)));
		}
	}

	private void addLastDay(List<DateTimeInterval> result) {
		result.add(fromMidnight(to));
	}
}
