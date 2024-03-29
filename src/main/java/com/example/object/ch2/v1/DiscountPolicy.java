package com.example.object.ch2.v1;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discount_type")
public abstract class DiscountPolicy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "discount_policy_id")
	private Long discountPolicyId;
	@OneToOne
	@JoinColumn(name = "discount_condition_group_id", nullable = false)
	private DiscountConditionGroup discountConditionGroup;

	// template method
	public long calculateDiscountAmount(Screening screening, Movie movie) {
		if (discountConditionGroup.isSatisfiedBy(screening)) {
			return movie.getFee() - getDiscountAmount(movie);
		}

		return movie.getFee();
	}

	abstract protected long getDiscountAmount(Movie movie);
}
