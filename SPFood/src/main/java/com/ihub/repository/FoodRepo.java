package com.ihub.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ihub.entity.Food;

public interface FoodRepo extends JpaRepository<Food, Integer> {

	@Query(value = "SELECT * FROM saiprabha.food where fid having aid = ?1 ", nativeQuery = true)
	public List <Food> findById(String aid);

	@Modifying
	@Transactional
	@Query(value = "delete from saiprabha.food  where aid = ?1 ", nativeQuery = true)
	
	public void deleteAllById(String aid);
	
	

}
