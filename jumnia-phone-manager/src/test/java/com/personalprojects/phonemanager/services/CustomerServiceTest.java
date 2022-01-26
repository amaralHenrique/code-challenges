package com.personalprojects.phonemanager.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Sort;

import com.personalprojects.phonemanager.enumerates.OrderDirectionEnum;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
	
	private final String PHONE_COLUMN = "phone";
	
	@Mock
	private CustomerService customerService;
	
	@Test
	public void shouldReturnSortAsc() {
		
		Sort expected = Sort.by(Sort.Direction.ASC, PHONE_COLUMN);
		
		String input = OrderDirectionEnum.ASC.name();
		Sort actual = CustomerService.sortByPhone(input);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void shouldReturnSortDesc() {
		
		Sort expected = Sort.by(Sort.Direction.DESC, PHONE_COLUMN);
		
		String input = OrderDirectionEnum.DESC.name();
		Sort actual = CustomerService.sortByPhone(input);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void shouldReturnSortAscWithoutFilter() {
		
		Sort expected = Sort.by(Sort.Direction.ASC, PHONE_COLUMN);
		
		String input = null;
		Sort actual = CustomerService.sortByPhone(input);
		
		assertEquals(expected, actual);
		
	}
	
}
