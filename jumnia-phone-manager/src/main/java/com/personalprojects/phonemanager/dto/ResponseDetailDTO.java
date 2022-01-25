package com.personalprojects.phonemanager.dto;

public class ResponseDetailDTO {

	private String countryCode;
	private String countryName;
	private String state;
	private String phoneNumber;
	private String errorMessage;
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getReasonToInvalid() {
		return errorMessage;
	}
	public void setReasonToInvalid(String reasonToInvalid) {
		this.errorMessage = reasonToInvalid;
	}
	
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	@Override
	public String toString() {
		return "ResponseDetailDTO [countryCode=" + countryCode + ", countryName=" + countryName + ", state=" + state
				+ ", phoneNumber=" + phoneNumber + ", reasonToInvalid=" + errorMessage + "]";
	}
		
}
