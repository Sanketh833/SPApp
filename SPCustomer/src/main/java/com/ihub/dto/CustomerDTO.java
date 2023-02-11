package com.ihub.dto;

import java.util.ArrayList;
import java.util.List;

import com.ihub.entity.Customer;

public class CustomerDTO {

	private String aid;
	private String cname;
	private String cadress;
	private int age;
	private String mobile;

	private RoomDTO roomDTO;
	private List<FoodDTO> foodDTO;



	public List<FoodDTO> getFoodDTO() {
		return foodDTO;
	}

	public void setFoodDTO(List<FoodDTO> foodDTO) {
		this.foodDTO = foodDTO;
	}

	public RoomDTO getRoomDTO() {
		return roomDTO;
	}

	public void setRoomDTO(RoomDTO roomDTO) {
		this.roomDTO = roomDTO;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCadress() {
		return cadress;
	}

	public void setCadress(String cadress) {
		this.cadress = cadress;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	// DTO to entity conversion

	public static Customer DTOtoEntityconversion(CustomerDTO customerDTO) {
		Customer customer = new Customer();

		customer.setAge(customerDTO.getAge());
		customer.setAid(customerDTO.getAid());
		customer.setCadress(customerDTO.getCadress());
		customer.setCname(customerDTO.getCname());
		customer.setMobile(customerDTO.getMobile());
		customer.setRid(customerDTO.getRoomDTO().getRid());


		return customer;

	}

//		entity to DTO conversion
	public static CustomerDTO customerEntitytoDTO(Customer centity) {


		CustomerDTO customerDTO = new CustomerDTO();

		customerDTO.setAid(centity.getAid());
		customerDTO.setAge(centity.getAge());
		customerDTO.setCadress(centity.getCadress());
		customerDTO.setCname(centity.getCname());
		customerDTO.setMobile(centity.getMobile());


		return customerDTO;

	}

	public static List<Customer> DtotoEntity(List<CustomerDTO> customerDTO) {

		List<Customer> custlist = new ArrayList<Customer>();
		for (int i = 0; i < customerDTO.size(); i++) {

			Customer cust = CustomerDTO.DTOtoEntityconversion(customerDTO.get(i));
			custlist.add(cust);

		}
		return custlist;

	}
}
