package com.zucc.smart.mapper;

import java.util.ArrayList;

import com.zucc.smart.domain.ParkingType;

public interface ParkingTypeMapper {
	ArrayList<ParkingType> getAllType();
	
	String getTypeName(String typecode);

	ArrayList<ParkingType> searchType(String typecode);	
	
	String getTypeCode(String typename);
}
