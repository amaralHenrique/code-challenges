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
	
	public static PhoneStateEnum fromString(String description) {
		PhoneStateEnum result = null;
		
		if(description != null)
			for(PhoneStateEnum phoneState : PhoneStateEnum.values()) {
				if(description.equalsIgnoreCase(phoneState.description)) {
					result = phoneState;
					break;
				}
					
			}
				return result;
	}
}
