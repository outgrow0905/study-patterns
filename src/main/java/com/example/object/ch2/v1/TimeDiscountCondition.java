package com.example.object.ch2.v1;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("TIME")
public class TimeDiscountCondition extends DiscountCondition{

	@Column(name = "discount_start_time")
	private LocalDateTime discountStartTime;
	@Column(name = "discount_end_time")
	private LocalDateTime discountEndTime;

	@Override
	public boolean isSatisfiedBy(Screening screening) {
		if (screening.getStartTime().getDayOfWeek() == this.discountStartTime.getDayOfWeek()
			&& screening.getStartTime().isAfter(this.discountStartTime)
			&& screening.getStartTime().isBefore(this.discountEndTime)) {
			return true;
		}
		return false;
	}
}
