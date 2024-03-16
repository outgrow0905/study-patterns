package com.example.object.ch3.v7;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FeeRule {
	private FeePerDuration feePerDuration;
	private FeeCondition condition;

	public long calculateFeeByRule(DateTimeInterval interval) {
		return condition.splitTimeIntervals(interval)
			.stream()
			.map(each -> feePerDuration.calculateFeePerDuration(each.duration()))
			.reduce(Long::sum).get();
	}
}
