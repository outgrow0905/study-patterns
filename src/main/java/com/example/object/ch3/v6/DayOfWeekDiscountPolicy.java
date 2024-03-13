package com.example.object.ch3.v6;

import java.util.List;

public class DayOfWeekDiscountPolicy implements BasicRatePolicy {
	List<DayOfWeekDiscountRule> rules;

	public DayOfWeekDiscountPolicy(List<DayOfWeekDiscountRule> rules) {
		this.rules = rules;
	}

	@Override
	public Long calculateCallFee(Call call) {
		long result = 0l;

		for (DateTimeInterval interval : call.splitByDay()) {
			for (DayOfWeekDiscountRule rule : rules) {
				result += rule.calculateFee(interval);
			}
		}

		return result;
	}
}
