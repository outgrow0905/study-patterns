package com.example.object.ch2.v1;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class DiscountConditionGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "discount_condition_group_id")
	private Long discountConditionGroupId;

	@OneToMany
	@JoinColumn(name = "discount_condition_id")
	private List<DiscountCondition> discountConditions;

	public boolean isSatisfiedBy(Screening screening) {
		return discountConditions.stream()
			.anyMatch(discountCondition -> discountCondition.isSatisfiedBy(screening));
	}
}
