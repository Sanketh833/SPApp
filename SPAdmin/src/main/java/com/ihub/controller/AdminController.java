package com.ihub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ihub.dto.AdminDTO;
import com.ihub.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	

//	create admin
	@PostMapping("/adminpost")
	public AdminDTO createadmin(@RequestBody AdminDTO adminDTO) {
		
		adminService.createadmin(adminDTO);
		return adminDTO;

	}

//	login
	@PostMapping("/adminlogin")
	public Boolean loginadmin(@RequestBody AdminDTO adminDTO) {
	
		return adminService.loginadmin(adminDTO);
	}
}
