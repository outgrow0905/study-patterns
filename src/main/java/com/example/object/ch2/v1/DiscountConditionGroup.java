package com.example.object.ch2.v1;

import java.util.List;

public class DiscountConditionGroup {

	private List<DiscountCondition> discountConditions;

	public boolean isSatisfiedBy(Screening screening) {
		return discountConditions.stream()
			.anyMatch(discountCondition -> discountCondition.isSatisfiedBy(screening));
	}
}
