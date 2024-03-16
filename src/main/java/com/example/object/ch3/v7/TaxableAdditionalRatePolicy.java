package com.example.object.ch3.v7;

public class TaxableAdditionalRatePolicy extends AdditionalRatePolicy {
	private double taxRate;

	public TaxableAdditionalRatePolicy(RatePolicy next, double taxRate) {
		super(next);
		this.taxRate = taxRate;
	}

	@Override
	protected Long afterCalculated(Long amount) {
		return ((Double)(amount * taxRate)).longValue();
	}
}
