package com.ihub.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {

	@Id
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
}
