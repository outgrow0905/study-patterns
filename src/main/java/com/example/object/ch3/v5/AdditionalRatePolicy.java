package com.example.object.ch3.v5;

public abstract class AdditionalRatePolicy implements RatePolicy {
	protected RatePolicy next;

	public AdditionalRatePolicy(RatePolicy next) {
		this.next = next;
	}
}
