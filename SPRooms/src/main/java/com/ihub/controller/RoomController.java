package com.ihub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ihub.dto.RoomDTO;
import com.ihub.exceptionhandler.IhubException;
import com.ihub.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {

	@Autowired
	RoomService roomService;

	@PostMapping("/roompost")
	public RoomDTO postroommapping(@RequestBody RoomDTO roomDTO) {

		return roomService.postroommapping(roomDTO);

	}

	@GetMapping("/getroom/{rid}")
	public RoomDTO getroommapping(@PathVariable("rid") Integer rid) throws IhubException {

		return roomService.getroommapping(rid);

	}

	@DeleteMapping("/deleteroom/{rid}")
	public Boolean deletecustomermapping(@PathVariable("rid") Integer rid) {

		return roomService.deleteroommapping(rid);
	}

	@PutMapping("/updateroom/{rid}")
	public RoomDTO updateroom(@PathVariable("rid") Integer rid, @RequestBody RoomDTO roomDTO) {

		return roomService.updateroom(rid, roomDTO);

	}
}
