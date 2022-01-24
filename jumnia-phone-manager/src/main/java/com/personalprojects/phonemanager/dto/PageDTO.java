package com.personalprojects.phonemanager.dto;

import java.io.Serializable;
import java.util.List;

public class PageDTO implements Serializable{

	private List<PhoneDetailDTO> phones;
	private Integer total;
	
	public List<PhoneDetailDTO> getPhones() {
		return phones;
	}
	
	public void setPhones(List<PhoneDetailDTO> phones) {
		this.phones = phones;
	}
	
	public Integer getTotal() {
		return total;
	}
	
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "PageDTO [phones=" + phones + ", total=" + total + "]";
	}
	
	
}
