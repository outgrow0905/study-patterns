package com.example.object.ch3.v5;

import java.time.Duration;


public class TimeOfTheDayDiscountPolicy implements BasicRatePolicy {
	private static final int LATE_NIGHT_HOUR_START = 22;
	private static final int LATE_NIGHT_HOUR_END = 6;

	private Long nightlyAmount; // 심야 단위시간 (seconds) 당 금액 (KRW)
	private Long regularAmount; // 일반 단위시간 (seconds) 당 금액 (KRW)
	private Duration seconds; // 단위시간

	public TimeOfTheDayDiscountPolicy(Long nightlyAmount, Long regularAmount, Duration seconds) {
		this.nightlyAmount = nightlyAmount;
		this.regularAmount = regularAmount;
		this.seconds = seconds;
	}

	@Override
	public Long calculateCallFee(Call call) {
		if (LATE_NIGHT_HOUR_END < call.getFrom().getHour()
			&& call.getFrom().getHour() < LATE_NIGHT_HOUR_START
		) {
			return regularAmount * (call.getDuration().getSeconds() / seconds.getSeconds());
		} else {
			return nightlyAmount * (call.getDuration().getSeconds() / seconds.getSeconds());
		}
	}
}
