package com.example.object.ch2.v1;

public abstract class DiscountPolicy {
	private DiscountConditionGroup discountConditionGroup;

	// template method
	public long calculateDiscountAmount(Screening screening) {
		if (discountConditionGroup.isSatisfiedBy(screening)) {
			return getDiscountAmount(screening);
		}

		return 0;
	}

	abstract protected long getDiscountAmount(Screening screening);
}
