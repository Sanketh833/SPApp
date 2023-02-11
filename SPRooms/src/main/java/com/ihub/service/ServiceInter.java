package com.ihub.service;

import java.util.NoSuchElementException;

import com.ihub.dto.RoomDTO;
import com.ihub.entity.Room;
import com.ihub.exceptionhandler.IhubException;

public interface ServiceInter {
//	1
//	2
//	3
//	4
//	5
//	
	public RoomDTO postroommapping(RoomDTO roomDTO) throws NoSuchElementException ;
	public RoomDTO getroommapping(Integer rid) throws IhubException ;
	void add();
	
}
