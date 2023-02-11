package com.ihub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihub.dto.FoodDTO;
import com.ihub.entity.Food;
import com.ihub.repository.FoodRepo;

@Service
public class FoodService {

	@Autowired
	FoodRepo foodRepo;

//	post method
	public List<FoodDTO> registerfood(List<FoodDTO> foodDTO) {

		List<Food> food = FoodDTO.DtotoEntity(foodDTO);
		foodRepo.saveAll(food);
		return foodDTO;

	}

//	get method

	public FoodDTO gettherorderedfood(Integer fid) {

		Food food = foodRepo.findById(fid).get();

		return FoodDTO.EntitytoDTOconversion(food);
	}

//	get aid method

	public List<FoodDTO> getfoodfromAid(String aid) {

		List<Food> foodlist = foodRepo.findById(aid);

		return FoodDTO.foodEntitytoDTO(foodlist);
	}

// delete method

	public Boolean deleteroommapping(Integer fid) {

		try {
			foodRepo.deleteById(fid);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public Boolean removefoodlist(String aid) {

		try {
			foodRepo.deleteAllById(aid);
			return true;
		} catch (Exception e) {

			return false;
		}

	}

//	update method

	public FoodDTO updateroommapping(Integer fid, FoodDTO foodDTO) {

		Food food = foodRepo.getReferenceById(fid);

		food.setFcost(foodDTO.getFcost());
		food.setFtype(foodDTO.getFtype());
		food.setAid(foodDTO.getAid());

		foodRepo.save(food);
		return foodDTO;
	}

	public List<FoodDTO> updatefoodlist(String aid, List<FoodDTO> foodDTO) {

		List<Food> food = foodRepo.findById(aid);

		food = FoodDTO.DtotoEntity(foodDTO);

		foodRepo.saveAll(food);
		return foodDTO;

	}

}
