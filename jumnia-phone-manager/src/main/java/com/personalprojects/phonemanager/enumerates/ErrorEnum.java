package com.personalprojects.phonemanager.enumerates;

public enum ErrorEnum {

	ERROR_VALIDATE_001("001", "The phone number could not be validated"),
	ERROR_VALIDATE_002("002", "Unknown country code");
	
	private String code;
	private String message;
	
	private ErrorEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
		
}
