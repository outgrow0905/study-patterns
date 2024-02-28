package com.example.object.ch3.v2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class NightlyDiscountPhone {
	private static final int LATE_NIGHT_HOUR_START = 22;
	private static final int LATE_NIGHT_HOUR_END = 6;

	private Long nightlyAmount; // 심야 단위시간 (seconds) 당 금액 (KRW)
	private Long regularAmount; // 일반 단위시간 (seconds) 당 금액 (KRW)
	private Duration seconds; // 단위시간
	private List<Call> calls = new ArrayList<>();
	private Double taxRate; // 세율

	public NightlyDiscountPhone(Long nightlyAmount, Long regularAmount, Duration seconds, Double taxRate) {
		this.nightlyAmount = nightlyAmount;
		this.regularAmount = regularAmount;
		this.seconds = seconds;
		this.taxRate = taxRate;
	}

	public void call(Call call) {
		calls.add(call);
	}

	 public Long calculateFee() {
		Long result = 0L;
		for (Call call : calls) {
			if (LATE_NIGHT_HOUR_END < call.getFrom().getHour()
					&& call.getFrom().getHour() < LATE_NIGHT_HOUR_START
				) {
				result += regularAmount * (call.getDuration().getSeconds() / seconds.getSeconds());
			} else {
				result += nightlyAmount * (call.getDuration().getSeconds() / seconds.getSeconds());
			}
		}

		 return ((Double)(result * taxRate)).longValue();
	 }
}
