package com.example.object.ch3.v6;

public interface BasicRatePolicy extends RatePolicy {
	Long calculateCallFee(Call call);
}
