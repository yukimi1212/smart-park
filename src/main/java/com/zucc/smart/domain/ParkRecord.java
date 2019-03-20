package com.zucc.smart.domain;

public class ParkRecord {
	private String id;
	private String berthcode;		//车位编号
	private String cph;
	private String parkcode;		//停车场编号
	private String streetcode;		//街道编号
	private String businesscode;	//区域编号
	private String inserttime;
	private String dealtime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBerthcode() {
		return berthcode;
	}
	public void setBerthcode(String berthcode) {
		this.berthcode = berthcode;
	}
	public String getCph() {
		return cph;
	}
	public void setCph(String cph) {
		this.cph = cph;
	}
	public String getParkcode() {
		return parkcode;
	}
	public void setParkcode(String parkcode) {
		this.parkcode = parkcode;
	}
	public String getStreetcode() {
		return streetcode;
	}
	public void setStreetcode(String streetcode) {
		this.streetcode = streetcode;
	}
	public String getBusinesscode() {
		return businesscode;
	}
	public void setBusinesscode(String businesscode) {
		this.businesscode = businesscode;
	}
	public String getInserttime() {
		return inserttime;
	}
	public void setInserttime(String inserttime) {
		this.inserttime = inserttime;
	}
	public String getDealtime() {
		return dealtime;
	}
	public void setDealtime(String dealtime) {
		this.dealtime = dealtime;
	}
}	
