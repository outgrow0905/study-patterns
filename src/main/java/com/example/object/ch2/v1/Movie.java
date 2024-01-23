package com.example.object.ch2.v1;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_id")
	private Long movieId;

	@Column(name = "movie_name")
	private String name;
	@Column(name = "fee")
	private Long fee;

	@OneToOne
	@JoinColumn(name = "discount_policy_id")
	private DiscountPolicy discountPolicy;

	public long calculateFee(Screening screening) {
		return discountPolicy.calculateDiscountAmount(screening);
	}

	public Long getFee() {
		return fee;
	}
}