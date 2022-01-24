package com.personalprojects.phonemanager.enumerates;

public enum CountryCodesEnum {
	CAMEROON("(237)"), 
	ETHIOPIA("(251)"),
	MOROCCO("(212)"), 
	MOZAMBIQUE("(258)"), 
	UGANDA("(256)");

	private String description;

	CountryCodesEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	public static CountryCodesEnum fromString(String description) {
		CountryCodesEnum result = null;
		
		if(description != null)
			for(CountryCodesEnum countryCode : CountryCodesEnum.values()) {
				if(description.equalsIgnoreCase(countryCode.description)) {
					result = countryCode;
					break;
				}
					
			}
				return result;
	}
	
}
