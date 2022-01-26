package com.personalprojects.phonemanager.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;

import com.personalprojects.phonemanager.dto.FilterDTO;
import com.personalprojects.phonemanager.dto.ResponseDetailDTO;
import com.personalprojects.phonemanager.entities.Customer;
import com.personalprojects.phonemanager.enumerates.ErrorEnum;

public class MockUtils {

	private static final String INVALID_FILTER = "INVALID";
	private static final String INVALID_STATE = "Invalid";
	private static final String PHONE_COLUMN = "phone";
	private static final String COUNTRY_UNKNOWN = "UNKNOWN";
	private static final String INVALID_PHONE_NUMBER_1 = "(250) 975751054";
	private static final String INVALID_PHONE_NUMBER_2 = "(31) 975751054";
	
	public static FilterDTO mockFilterDTOWithStateInvalid() {
		FilterDTO filter = new FilterDTO();
		
		filter.setFilterByState(INVALID_FILTER);
		filter.setPageNumber(1);
		filter.setPageSize(5);
		
		return filter;
	}
	
	
	public static Sort mockSort() {
		return Sort.by(Sort.Direction.ASC, PHONE_COLUMN);
	}
	
	public static List<Customer> mockCustomerList(){
		
		List<Customer> list = new ArrayList<Customer>();
		Customer customer;
		
		customer = new Customer(1L, "Test1_name", "(237) 697151594");
		list.add(customer);
		customer = new Customer(2L, "Test2_name", "(237) 677046616");
		list.add(customer);
		customer = new Customer(3L, "Test3_name", "(258) 847651504");
		list.add(customer);
		customer = new Customer(4L, "Test4_name", INVALID_PHONE_NUMBER_1);
		list.add(customer);
		customer = new Customer(5L, "Test5_name", INVALID_PHONE_NUMBER_2);
		list.add(customer);
		
		return list;
	}
	
	public static List<ResponseDetailDTO> mockResponseDetailInvalidFilter(){
		
		List<ResponseDetailDTO> list =  new ArrayList<>();
		ResponseDetailDTO item;

		item = new ResponseDetailDTO();
		item.setCountryCode("250");
		item.setCountryName(COUNTRY_UNKNOWN);
		item.setState(INVALID_STATE);
		item.setPhoneNumber(INVALID_PHONE_NUMBER_1);
		item.setReasonToInvalid(ErrorEnum.ERROR_VALIDATE_002.getMessage());
		
		list.add(item);
		
		item = new ResponseDetailDTO();
		item.setCountryCode("31)");
		item.setCountryName(COUNTRY_UNKNOWN);
		item.setState(INVALID_STATE);
		item.setPhoneNumber(INVALID_PHONE_NUMBER_2);
		item.setReasonToInvalid(ErrorEnum.ERROR_VALIDATE_002.getMessage());
		
		list.add(item);
				
		return list;
	}
	
}
