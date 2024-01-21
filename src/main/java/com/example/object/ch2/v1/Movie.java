package com.example.object.ch2.v1;

import java.util.List;

public abstract class Movie {
	private String name;
	private Long fee;
	private List<DiscountCondition> discountConditions;

	public long calculateFee(Screening screening) {
		if (discountConditions.stream()
			.anyMatch(discountCondition -> discountCondition.isSatisfiedBy(screening))) {
			return fee - getDiscountFee(this);
		}
		return fee;
	}

	public Long getFee() {
		return fee;
	}

	abstract protected long getDiscountFee(Movie movie);
}
