package com.ihub.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihub.dto.RoomDTO;
import com.ihub.entity.Room;
import com.ihub.exceptionhandler.IhubException;
import com.ihub.repository.RoomRepo;

@Service
public class RoomService {

	@Autowired
	RoomRepo roomRepo;

//	post method
	public RoomDTO postroommapping(RoomDTO roomDTO) throws NoSuchElementException {
		try {
			Room room = roomDTO.DTOtoEntityconversion();
			roomRepo.save(room);

		} catch (Exception e) {
			throw new NoSuchElementException();
		}
		return roomDTO;
	}

//	get method
	public RoomDTO getroommapping(Integer rid) throws IhubException {
		try {
			Room room = roomRepo.getReferenceById(rid);
			return RoomDTO.roomEntitytoDTO(room);
		

		} catch (Exception e) {
			throw new IhubException(200, "Data is missing");
		}
	}

// delete method	
	public Boolean deleteroommapping(Integer rid) {

		try {
			roomRepo.deleteById(rid);
			return true;
		} catch (Exception e) {

			return false;
		}

	}

	public RoomDTO updateroom(Integer rid, RoomDTO roomDTO) {

		Room entityroom = roomRepo.findById(rid).get();

		entityroom.setRent(roomDTO.getRent());
		entityroom.setNoofrooms(roomDTO.getNoofrooms());
		entityroom.setType(roomDTO.getType());

		roomRepo.save(entityroom);

		return roomDTO;
	}

}