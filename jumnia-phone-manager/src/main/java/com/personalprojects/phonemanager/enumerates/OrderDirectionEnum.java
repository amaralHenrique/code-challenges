package com.personalprojects.phonemanager.enumerates;

public enum OrderDirectionEnum {

	ASC("Ascending"),
	DESC("Descending");
	
	private String description;
	
	OrderDirectionEnum(String description) {
		this.description = description;
	}
		
	public String getDescription() {
		return description;
	}
}
