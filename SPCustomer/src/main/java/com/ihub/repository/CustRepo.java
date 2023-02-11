package com.ihub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ihub.entity.Customer;

public interface CustRepo extends JpaRepository<Customer, String>{

}
