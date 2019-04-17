package com.zucc.smart.service;

import java.util.ArrayList;

import com.zucc.smart.domain.Map;
import com.zucc.smart.vObject.AreaVO;
import com.zucc.smart.vObject.ParkingTypeVO;
import com.zucc.smart.vObject.ParkingVO;
import com.zucc.smart.vObject.StreetVO;

public interface ParkingService {
	ArrayList<ParkingVO> getAllParking();
	
	ArrayList<String> getBusinesscode();

	ArrayList<ParkingTypeVO> getParkingType();

	ArrayList<AreaVO> getArea();
	
	ArrayList<StreetVO> getStreet();

	ArrayList<ParkingVO> parkingSearch(String searchWord, String source);

	ArrayList<ParkingTypeVO> typeSearch(String searchWord);

	ArrayList<StreetVO> streetSearch(String searchWord);

	ArrayList<AreaVO> AreaSearch(String searchWord);

//	ArrayList<Map> getParkingMap();

	ArrayList<Map> getParkingMap(String lng, String lat);

	void addParking(String parkcode, String streetcode, String businesscode, String parkname, String streetname,
			String areaname, String typename);

	boolean checkParkCode(String parkcode);

	void deleteParking(String parkcode);
}
