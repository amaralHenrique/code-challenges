package com.personalprojects.phonemanager.enumerates;

public enum PhoneStateEnum {
	VALID("Valid"), 
	INVALID("Invalid");

	private String description;

	PhoneStateEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
