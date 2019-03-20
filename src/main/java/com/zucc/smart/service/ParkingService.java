package com.zucc.smart.service;

import java.util.ArrayList;

import com.zucc.smart.domain.Parking;

public interface ParkingService {
	ArrayList<Parking> getAllParking();
	
	ArrayList<String> getBusinesscode();
}
