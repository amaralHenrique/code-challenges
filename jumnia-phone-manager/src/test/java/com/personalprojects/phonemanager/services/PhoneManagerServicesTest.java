package com.personalprojects.phonemanager.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.personalprojects.phonemanager.dto.FilterDTO;
import com.personalprojects.phonemanager.dto.PageDTO;
import com.personalprojects.phonemanager.repositories.CustomerRepository;
import com.personalprojects.phonemanager.utils.MockUtils;

@RunWith(MockitoJUnitRunner.class)
public class PhoneManagerServicesTest {

	@Mock
	private CustomerRepository repository;
	
	@Mock
	private CustomerService service;
	
	@InjectMocks
	private PhoneManagerService phoneManagerService;
	
	@Test
	public void generatePagedListWithInvalidFilter() throws Exception {
		
		PageDTO expected =  new PageDTO();
		expected.setTotal(2);
		expected.setPhones(MockUtils.mockResponseDetailInvalidFilter());		
		
		FilterDTO filter = MockUtils.mockFilterDTOWithStateInvalid();
		when(repository.findAll(CustomerService.sortByPhone(filter.getOrderDirection()))).thenReturn(MockUtils.mockCustomerList());
		
		PageDTO actual = phoneManagerService.getPagedList(filter);
		
		assertEquals(expected.getTotal(), actual.getTotal());
		assertEquals(expected.getPhones().size(), actual.getPhones().size());
		assertEquals(expected.getMessage(), actual.getMessage());
		assertNotNull(actual.getPhones().get(0).getReasonToInvalid());
		
	}
	
}
