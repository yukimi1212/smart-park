package com.zucc.smart.service;

import java.util.ArrayList;

import com.zucc.smart.domain.Map;
import com.zucc.smart.valueObject.AreaVO;
import com.zucc.smart.valueObject.ParkingTypeVO;
import com.zucc.smart.valueObject.ParkingVO;
import com.zucc.smart.valueObject.StreetVO;

public interface ParkingService {
	ArrayList<ParkingVO> getAllParking();
	
	ArrayList<String> getBusinesscode();

	ArrayList<ParkingTypeVO> getParkingType();

	ArrayList<AreaVO> getArea();
	
	ArrayList<StreetVO> getStreet();

	ArrayList<ParkingVO> parkingSearch(String searchWord);

	ArrayList<ParkingTypeVO> typeSearch(String searchWord);

	ArrayList<StreetVO> streetSearch(String searchWord);

	ArrayList<AreaVO> AreaSearch(String searchWord);

	ArrayList<Map> getParkingMap();
}
