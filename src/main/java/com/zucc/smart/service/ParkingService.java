package com.zucc.smart.service;

import java.util.ArrayList;

import com.zucc.smart.domain.Parking;
import com.zucc.smart.valueObject.AreaVO;
import com.zucc.smart.valueObject.ParkingTypeVO;
import com.zucc.smart.valueObject.StreetVO;

public interface ParkingService {
	ArrayList<Parking> getAllParking();
	
	ArrayList<String> getBusinesscode();

	ArrayList<ParkingTypeVO> getParkingType();

	ArrayList<AreaVO> getArea();
	
	ArrayList<StreetVO> getStreet();

	ArrayList<Parking> parkingSearch(String searchWord);

	ArrayList<ParkingTypeVO> typeSearch(String searchWord);

	ArrayList<StreetVO> streetSearch(String searchWord);

	ArrayList<AreaVO> AreaSearch(String searchWord);
}
