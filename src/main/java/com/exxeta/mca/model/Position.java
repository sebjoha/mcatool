package com.exxeta.mca.model;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

//Compound Key based on orgID, bu and currency
public class Position {

//	@SuppressWarnings("unused")
//	private int id;	
	
public Position(){}
	
	// CloseOfBusinessDate
	int COBDate;
	
	//Organisation ID
	private int orgID;
	
	//BU ID
	private int bu;
	
	//Currency of the position as a String
	private Currency currency;
	
	//Type: Asset or Income/Liability
	private String actCd;
	
	//Amount of the position
	private BigDecimal amount;
	
	//Levelled Amount
	private BigDecimal blcd_amount;
	
	//Levelled Currency
	private String blcd_currency;

	public int getOrgID() {
		return orgID;
	}

	public void setOrgID(int orgID) {
		this.orgID = orgID;
	}

	public int getBu() {
		return bu;
	}

	public void setBu(int bu) {
		this.bu = bu;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = Currency.valueOf(currency);
	}
	
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	// public AccountCategory getType() {
	// 	return actcat;
	// }

	// public void setType(AccountCategory type) {
	// 	this.actcat = type;
	// }

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getblcd_amount() {
		return blcd_amount;
	}
	

	public void setblcd_amount(BigDecimal blcd_amount) {
		this.blcd_amount = blcd_amount;
	}
	
	public String getblcd_currency() {
		return blcd_currency;
	}

	public void setblcd_currency(String blcd_currency) {
		this.blcd_currency = blcd_currency;
	}
	
	public void setblcd_currency(Currency blcd_currency) {
		this.blcd_currency = blcd_currency.toString();
	}
	
	public String getActCd() {
		return actCd;
	}

	public void setActCd(String actCd) {
		this.actCd = actCd;
	}
	
	public int getCOBDate() {
		return COBDate;
	}

	public void setCOBDate(int date) {
		COBDate = date;
	}
	
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
