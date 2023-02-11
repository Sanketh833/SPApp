package com.ihub.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihub.dto.AdminDTO;
import com.ihub.entity.Admin;

import com.ihub.repository.AdminRepo;

@Service
public class AdminService {

	@Autowired
	AdminRepo adminRepo;
	
	public AdminDTO createadmin(AdminDTO adminDTO) {
		Admin admin = AdminDTO.DTOtoEntityconversion(adminDTO);
	
		adminRepo.save(admin);
		return adminDTO;
		
	}

	public Boolean loginadmin(AdminDTO adminDTO) {
		
		Boolean flag = false;
		Optional<Admin> admin = adminRepo.findById(adminDTO.getAdminid());
		 
		if(admin.isPresent() && admin.get() != null && admin.get().getAdminpswd().equals(adminDTO.getAdminpswd()))
		{
			flag = true;
		} 
			return flag;
			
		
		
		
	}

}
