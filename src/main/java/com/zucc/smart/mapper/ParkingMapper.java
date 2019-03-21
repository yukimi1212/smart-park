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
}
