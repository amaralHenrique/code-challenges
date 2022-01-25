package com.personalprojects.phonemanager.utils;

import java.util.List;

import com.personalprojects.phonemanager.dto.FilterDTO;
import com.personalprojects.phonemanager.dto.ResponseDetailDTO;

public class Pagination {
	
	public static final Integer DEFAULT_PAGE_SIZE = 3;
	public static final Integer DEFAULT_PAGE_NUMBER = 3;

	public static List<ResponseDetailDTO> retrievePage(List<ResponseDetailDTO> orderedList, FilterDTO filter) {

		if(orderedList.isEmpty())
			return orderedList;
		
		List<ResponseDetailDTO> result;
		
		Integer pageNumber = filter.getPageNumber() != null ? filter.getPageNumber() : DEFAULT_PAGE_NUMBER;
		Integer pageSize = filter.getPageSize() != null ? filter.getPageSize() : DEFAULT_PAGE_SIZE;
		Integer maxIndex = orderedList.size() <  pageNumber * pageSize ? orderedList.size() : pageNumber * pageSize;
		Integer initIndex = maxIndex - pageSize < 0 ? 0 : (1+maxIndex) - pageSize;
		
		result = orderedList.subList(initIndex, maxIndex);
		
		
		return result;
		
	}
	
}
 