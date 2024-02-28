package com.example.object.ch3.v4;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public abstract class AbstractPhone {
	private List<Call> calls = new ArrayList<>();

	public void call(Call call) {
		calls.add(call);
	}

	public Long calculateFee() {
		long result = 0L;

		for (Call call : calls) {
			result += calculateCallFee(call);
		}

		return afterCalculate(result);
	}

	protected abstract Long calculateCallFee(Call call);
	protected abstract Long afterCalculate(long fee);
}
