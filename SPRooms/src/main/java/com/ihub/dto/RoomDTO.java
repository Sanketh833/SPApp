package com.ihub.dto;

import com.ihub.entity.Room;

public class RoomDTO {

	private int rid;
	private String type;
	private int rent;
	private int noofrooms;


//	Entity to DTO

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public int getNoofrooms() {
		return noofrooms;
	}

	public void setNoofrooms(int noofrooms) {
		this.noofrooms = noofrooms;
	}
	

	public static RoomDTO roomEntitytoDTO(Room r) {
		// TODO Auto-generated method stub
		RoomDTO roomDTO = new RoomDTO();

		roomDTO.setRid(r.getRid());
		roomDTO.setRent(r.getRent());
		roomDTO.setNoofrooms(r.getNoofrooms());
		roomDTO.setType(r.getType());

		return roomDTO;
	}

//	DTO to entity

	public Room DTOtoEntityconversion() {
		// TODO Auto-generated method stub
		
		
		Room room = new Room();
		
		room.setRid(this.getRid());
		room.setRent(this.getRent());
		room.setType(this.getType());
		room.setNoofrooms(this.getNoofrooms());
		
		return room;
	}

}
