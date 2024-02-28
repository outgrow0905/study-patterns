package com.example.object.ch3.v4;

import java.time.Duration;


import lombok.Getter;

@Getter
public class RegularPhone extends AbstractPhone {
	private Long amount; // 단위시간 (seconds) 당 금액 (KRW)
	private Duration seconds; // 단위시간

	public RegularPhone(Long amount, Duration seconds) {
		this.amount = amount;
		this.seconds = seconds;
	}

	@Override
	protected Long calculateCallFee(Call call) {
		return amount * (call.getDuration().getSeconds() / seconds.getSeconds());
	}

	@Override
	protected Long afterCalculate(long fee) {
		return fee;
	}
}
