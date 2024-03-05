package com.example.object.ch3.v5;

public interface BasicRatePolicy extends RatePolicy {
	Long calculateCallFee(Call call);
}
