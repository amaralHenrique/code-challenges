package com.personalprojects.phonemanager.enumerates;

public enum CountryCodesRegexEnum {

	READABLE_COUNTRY("\\d{3}"),
	CAMEROON("\\(237\\)\\ ?[2368]\\d{7,8}$"), 
	ETHIOPIA("\\(251\\)\\ ?[1-59]\\d{8}$"),
	MOROCCO("\\(212\\)\\ ?[5-9]\\d{8}$"), 
	MOZAMBIQUE("\\(258\\)\\ ?[28]\\d{7,8}$"), 
	UGANDA("\\(256\\)\\ ?\\d{9}$");

	private String description;

	CountryCodesRegexEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
