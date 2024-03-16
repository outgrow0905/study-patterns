package com.example.object.ch3.v7;

public abstract class AdditionalRatePolicy implements RatePolicy {
	private RatePolicy next;

	public AdditionalRatePolicy(RatePolicy next) {
		this.next = next;
	}

	@Override
	public Long calculateCallFee(Call call) {
		return afterCalculated(next.calculateCallFee(call));
	}

	protected abstract Long afterCalculated(Long amount);
}
