package com.personalprojects.phonemanager.enumerates;

public enum ErrorEnum {

	ERROR_VALIDATE_001("V001", "The phone number could not be validated"),
	ERROR_VALIDATE_002("V002", "Unknown country code"),
	ERROR_IO_001("I001","Unkown filter option selected"),
	ERROR_PAGING_001("P001", "There are no data available");
	
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
