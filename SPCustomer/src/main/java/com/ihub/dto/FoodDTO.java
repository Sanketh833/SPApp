package com.ihub.dto;

public class FoodDTO {
	private int fid;
	private String ftype;
	private int fcost;
	private String aid; 

	
	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFtype() {
		return ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	public int getFcost() {
		return fcost;
	}

	public void setFcost(int fcost) {
		this.fcost = fcost;
	}


}
