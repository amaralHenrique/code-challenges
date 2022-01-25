package com.personalprojects.phonemanager.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.personalprojects.phonemanager.dto.FilterDTO;
import com.personalprojects.phonemanager.dto.ResponseDetailDTO;
import com.personalprojects.phonemanager.entities.Customer;
import com.personalprojects.phonemanager.enumerates.CountryCodesEnum;
import com.personalprojects.phonemanager.enumerates.CountryCodesRegexEnum;
import com.personalprojects.phonemanager.enumerates.ErrorEnum;
import com.personalprojects.phonemanager.enumerates.PhoneStateEnum;

@Service
public class PhoneManagerService {

	private Pattern pattern;

	public Set<ResponseDetailDTO> getPagedList(FilterDTO filter) throws Exception {

		// gerar uma grande lista, já ordenada

		// List<List<PhoneDetailDTO>> pagination
		// Pageable pageable = Pageable.ofSize(filter.getPageSize());

		// Page page = repository.findAll(pageable.next());
		// TEST SECTION
		List<Customer> list = new ArrayList<Customer>();
		Customer customer = new Customer(1L, "Test1_name", "(237) 697151594");
		list.add(customer);
		customer = new Customer(2L, "Test2_name", "(237) 677046616");
		list.add(customer);
		customer = new Customer(3L, "Test3_name", "(258) 847651504");
		list.add(customer);
		customer = new Customer(4L, "Test4_name", "(250) 975751054");
		list.add(customer);
		customer = new Customer(5L, "Test5_name", "(31) 975751054");
		list.add(customer);
		// END OF TEST SECTION

		Set<ResponseDetailDTO> response = this.buildPhoneDetail(list, filter);

		return response;

	}

	private Set<ResponseDetailDTO> buildPhoneDetail(List<Customer> customers, FilterDTO filter) throws Exception {

		// VALIDAR SE OS FILTROS SAO VALIDOS

		Set<ResponseDetailDTO> result = new HashSet<>();
		Map<CountryCodesEnum, List<ResponseDetailDTO>> countryMapping = new HashMap<>();
		Map<PhoneStateEnum, List<ResponseDetailDTO>> stateMapping = new HashMap<>();

		for (Customer customer : customers) {
			String phone = customer.getPhone();
			String countryCode = phone.substring(1, 4); // Talvez melhorar isso com um split de ) e pegar o [0]
			String invalidCause = "";
			CountryCodesEnum country;

			pattern = Pattern.compile(CountryCodesRegexEnum.READABLE_COUNTRY.getDescription());
			if (!pattern.matcher(countryCode).matches()) {
				// throw new Exception(ErrorEnum.ERROR_VALIDATE_001.getMessage());
				country = CountryCodesEnum.UNKNOWN;
				invalidCause = ErrorEnum.ERROR_VALIDATE_001.getMessage();
			}

			country = CountryCodesEnum.fromString(countryCode);
			if (country == null) {
				// throw new Exception(ErrorEnum.ERROR_VALIDATE_002.getMessage());
				country = CountryCodesEnum.UNKNOWN;
				invalidCause = ErrorEnum.ERROR_VALIDATE_002.getMessage();
			}

			ResponseDetailDTO detail = this.buildDTO(country, phone);

			if (PhoneStateEnum.INVALID.equals(PhoneStateEnum.fromString(detail.getState())))
				detail.setReasonToInvalid(invalidCause);

			if (countryMapping.containsKey(country)) { // Avaliar colocar uma validacao se ha filtro para a situacao
				List<ResponseDetailDTO> filteredCountryList = countryMapping.get(country);
				filteredCountryList.add(detail);
				countryMapping.put(country, filteredCountryList); // AVALIAR SE ESSA LINHA É REALMENTE NECESSARIA
			} else {
				List<ResponseDetailDTO> filteredCountryList = new ArrayList<>();
				filteredCountryList.add(detail);
				countryMapping.put(country, filteredCountryList);
			}

			PhoneStateEnum phoneState = PhoneStateEnum.fromString(detail.getState());

			if (stateMapping.containsKey(phoneState)) {// Avaliar colocar uma validacao se ha filtro para a situacao
				List<ResponseDetailDTO> filteredStateList = stateMapping.get(phoneState);
				filteredStateList.add(detail);
				stateMapping.put(phoneState, filteredStateList);
			} else {
				List<ResponseDetailDTO> filteredStateList = new ArrayList<>();
				filteredStateList.add(detail);
				stateMapping.put(phoneState, filteredStateList);
			}

		}

		if (filter.getFilterByCountryName() != null)
			for (String countrySelected : filter.getFilterByCountryName()) {
				CountryCodesEnum current = CountryCodesEnum.valueOf(countrySelected);
				List<ResponseDetailDTO> filteredList = countryMapping.get(current);
				if (filteredList != null)
					result.addAll(filteredList);
			}

		if (filter.getFilterByState() != null) {
			PhoneStateEnum filterState = PhoneStateEnum.valueOf(filter.getFilterByState());
			List<ResponseDetailDTO> filteredList = stateMapping.get(filterState);
			if (filteredList != null) {
				if (result.isEmpty())
					result.addAll(filteredList);
				else
					result.retainAll(filteredList);
			}
		}

		return result;
	}

	private boolean validateRegex(CountryCodesRegexEnum regex, String phone) {
		pattern = Pattern.compile(regex.getDescription());
		return pattern.matcher(phone).matches();
	}

	private ResponseDetailDTO buildDTO(CountryCodesEnum countryCode, String phone) {
		ResponseDetailDTO detail = new ResponseDetailDTO();

		if (CountryCodesEnum.UNKNOWN.equals(countryCode)) {
			detail.setCountryCode(phone.substring(1, 4));
			detail.setPhoneNumber(phone);
			detail.setState(PhoneStateEnum.INVALID.getDescription());
			detail.setCountryName(CountryCodesEnum.UNKNOWN.name());

			return detail;
		}

		CountryCodesRegexEnum countryRegex = CountryCodesRegexEnum.valueOf(countryCode.toString());

		detail.setCountryCode(countryCode.getDescription());
		detail.setPhoneNumber(phone);
		detail.setCountryName(countryCode.name());

		if (validateRegex(countryRegex, phone))
			detail.setState(PhoneStateEnum.VALID.getDescription());
		else
			detail.setState(PhoneStateEnum.INVALID.getDescription());

		return detail;
	}

}
