package com.zucc.smart.mapper;


import java.util.ArrayList;

import com.zucc.smart.domain.Parking;

public interface ParkingMapper {
	ArrayList<Parking> getAllParking();
	
	ArrayList<String> getBusinesscode();
}
