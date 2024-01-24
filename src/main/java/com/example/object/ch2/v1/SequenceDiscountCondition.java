package com.example.object.ch2.v1;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SEQ")
public class SequenceDiscountCondition extends DiscountCondition {

	@Column(name = "daily_seq")
	private Integer dailySequence;

	@Override
	public boolean isSatisfiedBy(Screening screening) {
		return screening.getSequence() == this.dailySequence;
	}
}
