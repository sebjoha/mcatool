package com.exxeta.mca.model;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class Account {
	
	String accoutNumber;
	AccountCategory category;
	
	public String getAccoutNumber() {
		return accoutNumber;
	}
	public void setAccoutNumber(String accoutNumber) {
		this.accoutNumber = accoutNumber;
	}
	public AccountCategory getCategory() {
		return category;
	}
	public void setCategory(AccountCategory category) {
		this.category = category;
	}
	
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
