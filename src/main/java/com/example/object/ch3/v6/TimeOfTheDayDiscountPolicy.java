package com.example.object.ch3.v6;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cglib.core.Local;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeOfTheDayDiscountPolicy implements BasicRatePolicy {

	private List<LocalTime> starts;
	private List<LocalTime> ends;
	private List<Duration> durations;
	private List<Long> amounts;

	public TimeOfTheDayDiscountPolicy(List<LocalTime> starts, List<LocalTime> ends, List<Duration> durations,
		List<Long> amounts) {
		this.starts = starts;
		this.ends = ends;
		this.durations = durations;
		this.amounts = amounts;
	}

	@Override
	public Long calculateCallFee(Call call) {
		Long result = 0L;
		for (DateTimeInterval interval : call.splitByDay()) {
			for (int loop = 0; loop < starts.size(); loop++) {
				LocalTime from = from(interval, starts.get(loop));
				LocalTime to = to(interval, ends.get(loop));

				if (from.isAfter(to)) {
					continue;
				}

				result += amounts.get(loop)
					* Duration.between(from, to).getSeconds()
					/ durations.get(loop).getSeconds();
			}
		}

		return result;
	}

	private LocalTime from(DateTimeInterval interval, LocalTime from) {
		return interval.getFrom().toLocalTime().isBefore(from) ?
			from :
			interval.getFrom().toLocalTime();
	}

	private LocalTime to(DateTimeInterval interval, LocalTime to) {
		return interval.getTo().toLocalTime().isAfter(to) ?
			to :
			interval.getTo().toLocalTime();
	}
}
