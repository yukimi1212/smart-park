package com.zucc.smart.mapper;

import java.util.ArrayList;

import com.zucc.smart.domain.Vehicle;

public interface VehicleMapper {
	ArrayList<Vehicle> getUserVehicle(String user_id);
	
	int getVehicleCount(String user_id);

	void deleteVehicle(String cph);

	void addVehicle(String cph, String cartype, String user_id);

	ArrayList<Vehicle> getUserVehicleForAdmin(String check_id);
}
