package com.ihub.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ihub.dto.FoodDTO;

@FeignClient(value = "foodFiegn", url = "http://localhost:8082/food")

public interface FeignFood {

	@PostMapping("/foodpost")
	List<FoodDTO> registerfood(@RequestBody List<FoodDTO> foodDTO);

	@GetMapping("/getcustfood/{aid}")
	List<FoodDTO> getfoodfromAid(@PathVariable("aid") String aid);
	
	@DeleteMapping("/removefoodlist/{aid}")
	public Boolean removefoodlist(@PathVariable("aid") String aid);

	@PutMapping("/updatefoodlist/{aid}")
	public List<FoodDTO> updatefoodlist(@PathVariable("aid") String aid, @RequestBody List<FoodDTO> foodDTO);

}
