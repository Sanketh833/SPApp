package com.ihub.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihub.dto.CustomerDTO;
import com.ihub.dto.FoodDTO;
import com.ihub.dto.RoomDTO;
import com.ihub.entity.Customer;

import com.ihub.exceptionhandler.IhubException;
import com.ihub.feign.FeignFood;
import com.ihub.feign.FeignService;
import com.ihub.feign.FeignService2;
import com.ihub.repository.CustRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CustomerService {

	@Autowired
	CustRepo custRepo;

	@Autowired
	FeignService feignService;

	@Autowired
	FeignService2 feignService2;

	@Autowired
	FeignFood feignFood;

	Log logger = LogFactory.getLog(this.getClass());
	public static final String CUSTOMER = "customer";

//	post method

	public CustomerDTO postcustomermapping(CustomerDTO customerDTO) throws IhubException {

		try {

			Customer cust = CustomerDTO.DTOtoEntityconversion(customerDTO);
			custRepo.save(cust);
			logger.info("Saving customer details to repo" + cust);

			RoomDTO rdto = feignService.postroommapping(customerDTO.getRoomDTO());
			logger.info("creating  room details from room by feign method" + rdto);

			List<FoodDTO> foodDTO = feignFood.registerfood(customerDTO.getFoodDTO());
			logger.info("creating all the food order for customer from food method through feign" + foodDTO);

		} catch (Exception e) {
			throw new IhubException();
		}
		return customerDTO;

	}

//	get method
	@CircuitBreaker(name = CUSTOMER, fallbackMethod = "customerfallback")
	public CustomerDTO getcustomermapping(String aid) {

		try {

			Customer centity = custRepo.getReferenceById(aid);

			CustomerDTO cdto = CustomerDTO.customerEntitytoDTO(centity);
			logger.info("Getting all the customer details from repo" + cdto);
			custRepo.save(centity);

			RoomDTO roomDTO = feignService.getroommapping(centity.getRid());
			logger.info("Getting all the room details " + roomDTO);

			List<FoodDTO> foodDTO = feignFood.getfoodfromAid(centity.getAid());
			logger.info("Getting all the ordered food list" + foodDTO);
			cdto.setRoomDTO(roomDTO);
			cdto.setFoodDTO(foodDTO);

			return cdto;

		} catch (Exception e) {

			throw new NoSuchElementException();

		}
	}

// delete method	
	public Boolean deletecustomermapping(String aid) {

		try {

			Customer customer = custRepo.getReferenceById(aid);
			CustomerDTO.customerEntitytoDTO(customer);

			custRepo.deleteById(aid);

			feignService.deletecustomermapping(customer.getRid());
			feignFood.removefoodlist(aid);
			return true;
		} catch (Exception e) {

			return false;
		}

	}
//	update method

	public CustomerDTO updatecustomermapping(String aid, CustomerDTO customerDTO) {

		Customer entitycust = custRepo.findById(aid).get();

		entitycust.setAge(customerDTO.getAge());
		entitycust.setCadress(customerDTO.getCadress());
		entitycust.setCname(customerDTO.getCname());
		entitycust.setMobile(customerDTO.getMobile());
		custRepo.save(entitycust);

		RoomDTO roomDTO = feignService.updateroom(entitycust.getRid(), customerDTO.getRoomDTO());
		List<FoodDTO> foodDTO = feignFood.updatefoodlist(aid, customerDTO.getFoodDTO());

		customerDTO.setRoomDTO(roomDTO);
		customerDTO.setFoodDTO(foodDTO);
		return customerDTO;
	}

	public String customerfallback(Exception exception) {
		return "Fall Back occured";
	}
}
