package com.example.object.ch3.v3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public abstract class AbstractPhone {
	private List<Call> calls = new ArrayList<>();
	private Double taxRate; // 세율

	public AbstractPhone(Double taxRate) {
		this.taxRate = taxRate;
	}

	public void call(Call call) {
		calls.add(call);
	}

	public Long calculateFee() {
		long result = 0L;

		for (Call call : calls) {
			result += calculateCallFee(call);
		}

		return ((Double)(result * taxRate)).longValue();
	}

	protected abstract Long calculateCallFee(Call call);
}
