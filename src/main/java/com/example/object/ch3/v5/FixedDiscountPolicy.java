package com.example.object.ch3.v5;

import java.time.Duration;

public class FixedDiscountPolicy implements BasicRatePolicy {
	private Long amount; // 단위시간 (seconds) 당 금액 (KRW)
	private Duration seconds; // 단위시간

	public FixedDiscountPolicy(Long amount, Duration seconds) {
		this.amount = amount;
		this.seconds = seconds;
	}

	@Override
	public Long calculateCallFee(Call call) {
		return amount * (call.getDuration().getSeconds() / seconds.getSeconds());
	}
}
