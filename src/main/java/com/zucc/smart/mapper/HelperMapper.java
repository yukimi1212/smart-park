package com.zucc.smart.mapper;

public interface HelperMapper {
	String getStreetName(String streetcode);
	
	String getAreaName(String areaname);
	
	String getAreaNameByStreetcode(String streetcode);
	
	String getParkingName(String parkcode);
}
