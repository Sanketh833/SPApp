package com.ihub.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ihub.dto.RoomDTO;

@FeignClient(value = "roomFiegn", url ="http://localhost:8086/room" )

public interface FeignService {
	
	
	@PostMapping("/roompost")
	RoomDTO postroommapping(@RequestBody RoomDTO roomDTO) ;

	@GetMapping("/getroom/{rid}")
	RoomDTO getroommapping(@PathVariable("rid") Integer rid); 
	

	@DeleteMapping("/deleteroom/{rid}")
	public Boolean deletecustomermapping(@PathVariable("rid") Integer rid) ;
		

	@PutMapping("/updateroom/{rid}")
	public RoomDTO updateroom(@PathVariable("rid") Integer rid, @RequestBody RoomDTO roomDTO) ;

		
}
