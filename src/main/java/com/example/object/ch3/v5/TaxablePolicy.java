package com.example.object.ch3.v5;

public class TaxablePolicy extends AdditionalRatePolicy{
	private double taxRate;

	public TaxablePolicy(RatePolicy next, double taxRate) {
		super(next);
		this.taxRate = taxRate;
	}

	@Override
	public Long calculateCallFee(Call call) {
		return ((Double)(next.calculateCallFee(call) * taxRate)).longValue();
	}
}
