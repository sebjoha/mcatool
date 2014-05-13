package com.exxeta.mca.model;

import java.math.BigDecimal;

public class ExchangeRate {
	
	Currency from;
	Currency to;
	
	BigDecimal rate;

	public Currency getFrom() {
		return from;
	}

	public void setFrom(Currency from) {
		this.from = from;
	}

	public Currency getTo() {
		return to;
	}

	public void setTo(Currency to) {
		this.to = to;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	
	
	
}
