package com.personalprojects.phonemanager.dto;

import java.io.Serializable;
import java.util.List;

public class PageDTO implements Serializable{
	private static final long serialVersionUID = 1581513715335397977L;
	
	private List<ResponseDetailDTO> phones;
	private Integer total;
	private String Message;
		
	public List<ResponseDetailDTO> getPhones() {
		return phones;
	}
	
	public void setPhones(List<ResponseDetailDTO> phones) {
		this.phones = phones;
	}
	
	public Integer getTotal() {
		return total;
	}
	
	public void setTotal(Integer total) {
		this.total = total;
	}
		
	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	@Override
	public String toString() {
		return "PageDTO [phones=" + phones + ", total=" + total + ", Message=" + Message + "]";
	}
	
	
}
