	package com.ihub.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ihub.dto.CustomerDTO;

import com.ihub.exceptionhandler.IhubException;
import com.ihub.feign.FeignService2;
import com.ihub.service.CustomerService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	FeignService2 feignService2;

	Log logger = LogFactory.getLog(this.getClass());
//	public static final String CUSTOMER = "customer";

	@PostMapping("/custpost")

	public CustomerDTO postcustomermapping(@RequestBody CustomerDTO customerDTO) throws IhubException {

		logger.info("creating cutomer" + customerDTO);

		customerDTO = customerService.postcustomermapping(customerDTO);

		return customerDTO;

	}

	@GetMapping("/getcustomer/{aid}")
//	@CircuitBreaker(name = CUSTOMER, fallbackMethod = "customerfallback")
	public CustomerDTO getcustomermapping(@PathVariable("aid") String aid) {

		logger.info("Getting indivicual customer details" + aid);

		return customerService.getcustomermapping(aid);

	}

	@DeleteMapping("/deletecustomer/{aid}")
	public Boolean deletecustomermapping(@PathVariable("aid") String aid) {

		logger.info("Delete customer details" + aid);
		return customerService.deletecustomermapping(aid);
	}

	@PutMapping("/updatecustomer/{aid}")
	public CustomerDTO updatecustomermapping(@PathVariable("aid") String aid, @RequestBody CustomerDTO customerDTO) {
		logger.info("Update customer details" + aid + customerDTO);
		return customerService.updatecustomermapping(aid, customerDTO);

	}

//	public String customerfallback(Exception e) {
//		return "Fall Back occured";
//	}

}
