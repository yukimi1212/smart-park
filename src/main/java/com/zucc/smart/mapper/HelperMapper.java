package com.zucc.smart.mapper;

import java.util.ArrayList;
import java.util.Collection;

public interface HelperMapper {
	String getStreetName(String streetcode);
	
	String getAreaName(String areaname);
	
	String getStreetCode(String streetname);
	
	String getBusinesscode(String businesscode);
	
	String getTypecode(String typecode);
	
	String getAreaNameByStreetcode(String streetcode);
	
	String getParkingName(String parkcode);

	ArrayList<String> getParkingnameTags();
	
	ArrayList<String> getTypenameTags();
	
	ArrayList<String> getStreetnameTags();
	
	ArrayList<String> getAreanameTags();	
}
