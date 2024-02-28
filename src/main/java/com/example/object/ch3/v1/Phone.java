package com.example.object.ch3.v1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Phone {
	private Long amount; // 단위시간 (seconds) 당 금액 (KRW)
	private Duration seconds; // 단위시간
	private List<Call> calls = new ArrayList<>();

	public Phone(Long amount, Duration seconds) {
		this.amount = amount;
		this.seconds = seconds;
	}

	public void call(Call call) {
		calls.add(call);
	}

	public Long calculateFee() {
		Long result = 0L;

		for (Call call : calls) {
			result += amount * (call.getDuration().getSeconds() / seconds.getSeconds());
		}

		return result;
	}
}
