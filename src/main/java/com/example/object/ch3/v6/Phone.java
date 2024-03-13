package com.example.object.ch3.v6;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Phone {
	private List<Call> calls = new ArrayList<>();

	public RatePolicy ratePolicy;

	public Phone(RatePolicy ratePolicy) {
		this.ratePolicy = ratePolicy;
	}

	public void call(Call call) {
		calls.add(call);
	}

	public Long calculateFee() {
		long result = 0L;

		for (Call call : calls) {
			result += ratePolicy.calculateCallFee(call);
		}

		return result;
	}
}
