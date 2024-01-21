package com.example.object.ch2.v1;

public class Movie {
	private String name;
	private long fee;
	private DiscountPolicy discountPolicy;

	public long calculateFee(Screening screening) {
		return discountPolicy.calculateDiscountAmount(screening);
	}
}
