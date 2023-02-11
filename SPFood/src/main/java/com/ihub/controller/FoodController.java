package com.ihub.controller;

import java.util.List;

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

import com.ihub.dto.FoodDTO;
import com.ihub.service.FoodService;

@RestController
@RequestMapping("/food")

public class FoodController {

	@Autowired
	FoodService foodService;
	Log logger = LogFactory.getLog(this.getClass());

	@PostMapping("/foodpost")
	public List<FoodDTO> registerfood(@RequestBody List<FoodDTO> foodDTO) {

		logger.info("Order the Food" + foodDTO);
		return foodService.registerfood(foodDTO);
	}

	@GetMapping("/getfood/{fid}")
	public FoodDTO gettherorderedfood(@PathVariable("fid") Integer fid) {

		logger.info("Get the rdred food");
		return foodService.gettherorderedfood(fid);

	}

	@GetMapping("/getcustfood/{aid}")
	public List<FoodDTO> getfoodfromAid(@PathVariable("aid") String aid) {

		logger.info("Get all the ordered food list of the customer");
		return foodService.getfoodfromAid(aid);

	}

	@DeleteMapping("/deletefood/{fid}")
	public Boolean deletefoodmapping(@PathVariable("fid") Integer fid) {

		logger.info("Cancel the order");
		return foodService.deleteroommapping(fid);
	}

	@DeleteMapping("/removefoodlist/{aid}")
	public Boolean removefoodlist(@PathVariable("aid") String aid) {

		logger.info("Delete the ordered food list of customer");
		return foodService.removefoodlist(aid);
	}

	@PutMapping("/updatefood/{fid}")
	public FoodDTO updatefoodmapping(@PathVariable("fid") Integer fid, @RequestBody FoodDTO foodDTO) {
		logger.info("update all the ordered food of customer" + fid + foodDTO);
		return foodService.updateroommapping(fid, foodDTO);

	}

	@PutMapping("/updatefoodlist/{aid}")
	public List<FoodDTO> updatefoodlist(@PathVariable("aid") String aid, @RequestBody List<FoodDTO> foodDTO) {
		logger.info("update the food order" + aid + foodDTO);
		return foodService.updatefoodlist(aid, foodDTO);

	}

}
