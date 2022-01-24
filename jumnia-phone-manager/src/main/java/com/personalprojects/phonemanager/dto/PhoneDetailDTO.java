package com.personalprojects.phonemanager.dto;

public class PhoneDetailDTO {

	private String countryCode;
	private String state;
	private String phoneNumber;
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
	@Override
	public String toString() {
		return "PhoneDetailDTO [countryCode=" + countryCode + ", state=" + state + ", phoneNumber=" + phoneNumber + "]";
	}
		
}
