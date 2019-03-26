package com.zucc.smart.mapper;

import java.util.ArrayList;

import com.zucc.smart.domain.Vehicle;

public interface VehicleMapper {
	ArrayList<Vehicle> getUserVehicle(String user_id);
	
	int getVehicleCount(String user_id);
}
