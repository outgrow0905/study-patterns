package com.example.object.ch2.v1;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("RATIO")
public class PercentDiscountPolicy extends DiscountPolicy {
	@Column(name = "discount_ratio")
	private Double percent;
	@Override
	protected long getDiscountAmount(Screening screening) {
		return Math.round(screening.getMovieFee() * this.percent / 100);
	}
}