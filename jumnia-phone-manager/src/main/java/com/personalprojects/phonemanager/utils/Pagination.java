package com.personalprojects.phonemanager.utils;

import java.util.ArrayList;
import java.util.List;

import com.personalprojects.phonemanager.dto.FilterDTO;
import com.personalprojects.phonemanager.dto.PageDTO;
import com.personalprojects.phonemanager.dto.ResponseDetailDTO;
import com.personalprojects.phonemanager.enumerates.ErrorEnum;

public class Pagination {
	
	public static final Integer DEFAULT_PAGE_SIZE = 3;
	public static final Integer DEFAULT_PAGE_NUMBER = 1;

	public static PageDTO retrievePage(List<ResponseDetailDTO> orderedList, FilterDTO filter) {

		PageDTO page = new PageDTO();
		page.setTotal(orderedList.size());
		
		if(orderedList.isEmpty()) {
			page.setPhones(orderedList);
			page.setMessage(ErrorEnum.ERROR_PAGING_001.getMessage());
			return page;
		}
		
		List<ResponseDetailDTO> result;
		
		Integer pageNumber = filter.getPageNumber() != null ? filter.getPageNumber() : DEFAULT_PAGE_NUMBER;
		Integer pageSize = filter.getPageSize() != null ? filter.getPageSize() : DEFAULT_PAGE_SIZE;
		Integer maxIndex = orderedList.size() <  pageNumber * pageSize ? orderedList.size() : pageNumber * pageSize;
		Integer initIndex = pageSize * (pageNumber-1) <= 0 ? 0 : pageSize * (pageNumber-1);
		
		if(initIndex >= maxIndex) {
			
			page.setPhones(new ArrayList<>());
			page.setMessage(ErrorEnum.ERROR_PAGING_001.getMessage());
			return page;
		}			
		result = orderedList.subList(initIndex, maxIndex);
		
		page.setPhones(result);
		
		return page;
		
	}
	
}
 