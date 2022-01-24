package com.personalprojects.phonemanager.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.personalprojects.phonemanager.dto.FilterDTO;
import com.personalprojects.phonemanager.dto.PhoneDetailDTO;
import com.personalprojects.phonemanager.entities.Customer;
import com.personalprojects.phonemanager.enumerates.CountryCodesEnum;
import com.personalprojects.phonemanager.enumerates.CountryCodesRegexEnum;
import com.personalprojects.phonemanager.enumerates.ErrorEnum;
import com.personalprojects.phonemanager.enumerates.PhoneStateEnum;

@Service
public class PhoneManagerService {
	
	private Pattern pattern;

	public List<PhoneDetailDTO> getPagedList(FilterDTO filter) throws Exception {

		// gerar uma grande lista, já ordenada

		// List<List<PhoneDetailDTO>> pagination
		// Pageable pageable = Pageable.ofSize(filter.getPageSize());

		// Page page = repository.findAll(pageable.next());
		//TEST SECTION
		List<Customer> list = new ArrayList<Customer>();
		Customer customer = new Customer(1L, "Test1_name", "(237) 697151594");
		list.add(customer);
		customer = new Customer(2L, "Test2_name", "(237) 677046616");
		list.add(customer);
		customer = new Customer(3L, "Test3_name", "(258) 847651504");
		list.add(customer);
		//END OF TEST SECTION
		
		List<PhoneDetailDTO> response = this.buildPhoneDetail(list);
		
		return response;

	}

	private List<PhoneDetailDTO> buildPhoneDetail(List<Customer> customers) throws Exception {

//		Pattern pattern = Pattern.compile(CountryCodesRegexEnum.READABLE_COUNTRY.getDescription());
//		boolean bool =  pattern.matcher("(237) 697151594").matches();
//		bool =  pattern.matcher("(237)").matches();
//		bool =  pattern.matcher("(27) ").matches();
//		bool =  pattern.matcher("(").matches();
		
		List<PhoneDetailDTO> result = new ArrayList<>();

		for (Customer customer : customers) {
			String phone = customer.getPhone();
			
			String countryCode = phone.substring(0, 5);
			//PhoneDetailDTO detail = new PhoneDetailDTO();

			pattern = Pattern.compile(CountryCodesRegexEnum.READABLE_COUNTRY.getDescription());
			if (!pattern.matcher(countryCode).matches())
				throw new Exception(ErrorEnum.ERROR_VALIDATE_001.getMessage());
						
			CountryCodesEnum country = CountryCodesEnum.fromString(countryCode);
			if(country == null)
				throw new Exception(ErrorEnum.ERROR_VALIDATE_002.getMessage());
			
			PhoneDetailDTO detail = this.buildDTO(country, phone);		

			result.add(detail);
		}

		return result;
	}
	
	private boolean validateRegex(CountryCodesRegexEnum regex, String phone) {
		pattern = Pattern.compile(regex.getDescription());
		return pattern.matcher("(237) 697151594").matches();
	}

	private PhoneDetailDTO buildDTO(CountryCodesEnum countryCode, String phone) {
		PhoneDetailDTO detail = new PhoneDetailDTO();
		CountryCodesRegexEnum countryRegex = CountryCodesRegexEnum.valueOf(countryCode.toString());
		
		detail.setCountryCode(countryCode.getDescription()); //AVALIAR REMOVER O PARENTESE PARA TER UM RETORNO CLEAN AO FRONT
		detail.setPhoneNumber(phone);
		
		if(validateRegex(countryRegex, phone))
			detail.setState(PhoneStateEnum.VALID.getDescription());
		else
			detail.setState(PhoneStateEnum.INVALID.getDescription());
		
		return detail;
	}
	
}
