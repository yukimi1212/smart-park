package com.zucc.smart.vObject;

public class ParkingVO {
	private String parkcode;
	private String streetcode;
	private String businesscode;
	private String parkname;
    private String streetname;
    private String areaname;
	private String typename;
	private int parking_amount;
	private int parking_rest;
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
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public int getParking_amount() {
		return parking_amount;
	}
	public void setParking_amount(int parking_amount) {
		this.parking_amount = parking_amount;
	}
	public int getParking_rest() {
		return parking_rest;
	}
	public void setParking_rest(int parking_rest) {
		this.parking_rest = parking_rest;
	}
}
