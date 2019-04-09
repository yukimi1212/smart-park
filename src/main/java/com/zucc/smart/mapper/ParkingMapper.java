package com.zucc.smart.mapper;


import java.util.ArrayList;
import java.util.HashMap;

import com.zucc.smart.domain.Parking;

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

	ArrayList<Parking> searchParkcodeByParkname(String searchWord);

	ArrayList<Parking> searchStreetcodeByStreetname(String string);
	
	ArrayList<Parking> searchBusinesscodeByAreaname(String string);

	ArrayList<Parking> getTypeCode(String parkcode);
	
	String getParkcode(String parkname);

	ArrayList<Parking> getParkcodeByTypecode(String typecode);
	
	ArrayList<Parking> getParkcodeForLat(String lat);
	
	ArrayList<Parking> getParkcodeForLng(String lng);
	
	void updateLng(String lng, String parkcode);
	
	void updateLat(String lat, String parkcode);

	ArrayList<Parking> getParkingSearch(String up_lng, String down_lng, String up_lat, String down_lat);

	void addParking(String parkcode, String streetcode, String businesscode, String parkname, String streetname,
			String areaname, String typecode, String parking_amount, String lng, String lat);

	int checkParkCode(String parkcode);
}
