package com.example.object.ch2.v1;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("AMOUNT")
public class AmountDiscountPolicy extends DiscountPolicy {
	@Column(name = "discount_amount")
	private Long amount;
	@Override
	protected long getDiscountAmount(Movie movie) {
		return this.amount;
	}
}
