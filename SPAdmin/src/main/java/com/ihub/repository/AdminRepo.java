package com.ihub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ihub.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, String>{

}
