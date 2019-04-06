package com.zucc.smart.vObject;

public class RecordVO {
	private String id;
	private String berthcode;		//车位编号
	private String cph;
	private String parkname;		//停车场编号
	private String streetname;		//街道编号
	private String areaname;	//区域编号
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
	public String getParkname() {
		return parkname;
	}
	public void setParkname(String parkname) {
		this.parkname = parkname;
	}
	public String getStreetname() {
		return streetname;
	}
	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
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
