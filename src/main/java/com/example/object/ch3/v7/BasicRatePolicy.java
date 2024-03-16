package com.example.object.ch3.v7;

import java.util.List;

public class BasicRatePolicy implements RatePolicy {

	private List<FeeRule> rules;

	public BasicRatePolicy(List<FeeRule> rules) {
		this.rules = rules;
	}

	@Override
	public Long calculateCallFee(Call call) {
		long result = 0;
		for (FeeRule rule : rules) {
			result += rule.calculateFeeByRule(call.getInterval());
		}
		return result;
	}
}
