package com.personalprojects.phonemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personalprojects.phonemanager.dto.FilterDTO;
import com.personalprojects.phonemanager.dto.PageDTO;
import com.personalprojects.phonemanager.entities.Customer;
import com.personalprojects.phonemanager.repositories.CustomerRepository;
import com.personalprojects.phonemanager.services.PhoneManagerService;

@RestController
@RequestMapping(value = "/customers")
public class PhoneManagerController {

	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private PhoneManagerService pmService;
	
	@GetMapping
	public ResponseEntity<List<Customer>> findAll(){
		
		List<Customer> list = repository.findAll();
		
		return new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/retrieve/list")
	public ResponseEntity<PageDTO> getListedPage(@RequestBody(required = false) FilterDTO filter) throws Exception {
		
		return ResponseEntity.ok(pmService.getPagedList(filter));
		
	}
	
	
	
}
