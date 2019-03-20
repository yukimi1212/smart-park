package com.zucc.smart.mapper;

import com.zucc.smart.domain.ParkingType;

public interface ParkingTypeMapper {
	ParkingType getAllType();
	
	String getTypeName(String typecode);	
}
