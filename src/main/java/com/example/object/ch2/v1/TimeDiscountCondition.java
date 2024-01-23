package com.example.object.ch2.v1;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@DiscriminatorValue("TIME")
public class TimeDiscountCondition extends DiscountCondition{

	@Column(name = "discount_start_time")
	private LocalDateTime discountStartTime;
	@Column(name = "discount_end_time")
	private LocalDateTime discountEndTime;

	@Override
	public boolean isSatisfiedBy(Screening screening) {
		if (screening.getStartTime().getDayOfWeek() == DayOfWeek.MONDAY
			&& screening.getStartTime().toLocalTime().isAfter(LocalTime.MIDNIGHT)
			&& screening.getStartTime().toLocalTime().isBefore(LocalTime.NOON)) {
			return true;
		}
		return false;
	}
}
