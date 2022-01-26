package com.personalprojects.phonemanager.services;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.personalprojects.phonemanager.enumerates.OrderDirectionEnum;

@Service
public class CustomerService {

	private static final String PHONE_COLUMN = "phone";

	public static Sort sortByPhone(String orderDirectionFilter) {
		
		OrderDirectionEnum orderDirection;
		Sort sort;
		
		try {
			orderDirection = OrderDirectionEnum.valueOf(orderDirectionFilter);
		} catch(Exception e) {
			orderDirection = null;
		}
		
		if(orderDirection == null)
			sort = Sort.by(Sort.Direction.ASC, PHONE_COLUMN);
		else
			sort = Sort.by(Sort.Direction.valueOf(orderDirection.name()), PHONE_COLUMN);
		
		return sort;
	}

}
