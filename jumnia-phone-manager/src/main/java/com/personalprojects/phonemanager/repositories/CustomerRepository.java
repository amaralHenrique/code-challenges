package com.personalprojects.phonemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personalprojects.phonemanager.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
