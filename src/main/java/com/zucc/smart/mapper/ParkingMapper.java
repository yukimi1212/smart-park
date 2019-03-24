package com.zucc.smart.mapper;


import java.util.ArrayList;
import java.util.HashMap;

import com.zucc.smart.domain.Parking;
import com.zucc.smart.valueObject.StreetVO;

public interface ParkingMapper {
	ArrayList<Parking> getAllParking();
	
	ArrayList<String> getBusinesscode();

	ArrayList<HashMap<String, Object>> getTypeCount();

	ArrayList<HashMap<String, Object>> getAreaCount();

	ArrayList<HashMap<String, Object>> getStreetCount();

	String getAreaName(String businesscode);
	
	String getStreetName(String streetcode);

	String getAreaNameByStreetcode(String streetcode);

	ArrayList<Parking> parkingSearch(String search);

	String getOneTypeCount(String typecode);

	ArrayList<HashMap<String, String>> searchStreet(String searchWord);

	String getOneStreetCount(String streetcode);
	
	String getOneAreaCount(String BUSINESSCODE);

	ArrayList<HashMap<String, String>> searchArea(String searchWord);

	ArrayList<Parking> searchParkNameByParkCode(String searchWord);

	ArrayList<Parking> searchStreetNameByStreetCode(String string);
	
	ArrayList<Parking> searchAreaNameByBusinesscode(String string);

}
