package com.personalprojects.phonemanager.dto;

public class ResponseDetailDTO {

	private String countryCode;
	private String state;
	private String phoneNumber;
	private String reasonToInvalid;
	
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
		return reasonToInvalid;
	}
	public void setReasonToInvalid(String reasonToInvalid) {
		this.reasonToInvalid = reasonToInvalid;
	}
	
	@Override
	public String toString() {
		return "PhoneDetailDTO [countryCode=" + countryCode + ", state=" + state + ", phoneNumber=" + phoneNumber
				+ ", reasonToInvalid=" + reasonToInvalid + "]";
	}
		
}
