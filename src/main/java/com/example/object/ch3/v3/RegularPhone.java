package com.example.object.ch3.v3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


import lombok.Getter;

@Getter
public class RegularPhone extends AbstractPhone {
	private Long amount; // 단위시간 (seconds) 당 금액 (KRW)
	private Duration seconds; // 단위시간

	public RegularPhone(Long amount, Duration seconds, Double taxRate) {
		super(taxRate);
		this.amount = amount;
		this.seconds = seconds;
	}

	@Override
	protected Long calculateCallFee(Call call) {
		return amount * (call.getDuration().getSeconds() / seconds.getSeconds());
	}
}
