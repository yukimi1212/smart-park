package com.zucc.smart.mapper;

import java.util.ArrayList;
import java.util.Collection;

public interface HelperMapper {
	String getStreetName(String streetcode);
	
	String getAreaName(String areaname);
	
	String getStreetCode(String streetname);
	
	String getBusinessCode(String businesscode);
	
	String getTypeCode(String typecode);
	
	String getAreaNameByStreetCode(String streetcode);
	
	String getParkingName(String parkcode);

	ArrayList<String> getParkingNameTags();
	
	ArrayList<String> getTypeNameTags();
	
	ArrayList<String> getStreetNameTags();
	
	ArrayList<String> getAreaNameTags();

	ArrayList<String> getAreaCodeTags();

	ArrayList<String> getStreetCodeTags();

	ArrayList<String> getCarTypeTags();

	ArrayList<String> getParkingCodeTags();

	ArrayList<String> getUserRecordIDTags(String cph);

	ArrayList<String> getUserCphTags(String user_id);
}
