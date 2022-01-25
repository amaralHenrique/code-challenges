package com.personalprojects.phonemanager.dto;

import java.io.Serializable;
import java.util.List;

public class FilterDTO implements Serializable{
	private static final long serialVersionUID = 3440139395619453552L;

	private List<String> filterByCountryName;
	
	private String filterByState;
	
	private String orderDirection;
	
	private Integer pageSize;
	
	private Integer pageNumber;
	
	public FilterDTO(List<String> filterByCountryName, String filterByState, String orderDirection, Integer pageSize,
			Integer pageNumber) {
		super();
		this.filterByCountryName = filterByCountryName;
		this.filterByState = filterByState;
		this.orderDirection = orderDirection;
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
	}

	public List<String> getFilterByCountryName() {
		return filterByCountryName;
	}

	public void setFilterByCountryName(List<String> filterByCountryName) {
		this.filterByCountryName = filterByCountryName;
	}

	public String getFilterByState() {
		return filterByState;
	}

	public void setFilterByState(String filterByState) {
		this.filterByState = filterByState;
	}

	public String getOrderDirection() {
		return orderDirection;
	}

	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	@Override
	public String toString() {
		return "FilterDTO [filterByCountryName=" + filterByCountryName + ", filterByState=" + filterByState
				+ ", orderDirection=" + orderDirection + ", pageSize=" + pageSize + ", pageNumber=" + pageNumber + "]";
	}
	
		
}
