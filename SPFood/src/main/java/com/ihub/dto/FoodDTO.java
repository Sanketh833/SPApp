package com.ihub.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ihub.entity.Food;

public class FoodDTO {
	private int fid;
	private String ftype;
	private int fcost;
	private String aid; 

	
	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFtype() {
		return ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	public int getFcost() {
		return fcost;
	}

	public void setFcost(int fcost) {
		this.fcost = fcost;
	}

	public static Food DTOtoEntityconversion(FoodDTO foodDTO) {
		// TODO Auto-generated method stub

		Food food = new Food();

		food.setFid(foodDTO.getFid());
		food.setFcost(foodDTO.getFcost());
		food.setFtype(foodDTO.getFtype());
		food.setAid(foodDTO.getAid());

		return food;
	}

	// Entity to DTO
	public static FoodDTO EntitytoDTOconversion(Food food) {

		FoodDTO foodDTO = new FoodDTO();
		foodDTO.setFid(food.getFid());
		foodDTO.setFcost(food.getFcost());
		foodDTO.setFtype(food.getFtype());
		foodDTO.setAid(food.getAid());
		return foodDTO;
	}

	public static List<Food> DtotoEntity(List<FoodDTO> foodDTO) {

		List<Food> foodlist = new ArrayList<Food>();
		for (int i = 0; i < foodDTO.size(); i++) {

			Food food = FoodDTO.DTOtoEntityconversion(foodDTO.get(i));
			foodlist.add(food);

		}
		return foodlist;

	}

	public static List<FoodDTO> foodEntitytoDTO(List<Food> food) {


		List<FoodDTO> foodDTOlist = new ArrayList<FoodDTO>();
		for (int i = 0; i < food.size(); i++) {
			FoodDTO foodDTO = FoodDTO.EntitytoDTOconversion(food.get(i));
			foodDTOlist.add(foodDTO);
		}

		return foodDTOlist;
	}
}
