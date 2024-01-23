package com.example.object.ch2.v1;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discount_condition_type")
public abstract class DiscountCondition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "discount_condition_group_id")
	private Long id;

	@Column(name = "discount_condition_seq")
	private Integer discountConditionSequence;

	abstract boolean isSatisfiedBy(Screening screening);
}
