package com.ihub.dto;

import com.ihub.entity.Admin;

public class AdminDTO {

	private String adminid;
	private String adminname;
	private String adminpswd;

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getAdminpswd() {
		return adminpswd;
	}

	public void setAdminpswd(String adminpswd) {
		this.adminpswd = adminpswd;
	}

	public static Admin DTOtoEntityconversion(AdminDTO adminDTO) {

		
		Admin admin = new Admin();
		
		admin.setAdminid(adminDTO.getAdminid());
		admin.setAdminname(adminDTO.getAdminname());
		admin.setAdminpswd(adminDTO.getAdminpswd());
		
		return admin;
	}
		

}
