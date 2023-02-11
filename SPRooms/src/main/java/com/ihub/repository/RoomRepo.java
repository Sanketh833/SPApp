package com.ihub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ihub.entity.Room;

public interface RoomRepo extends JpaRepository<Room, Integer>{

}
