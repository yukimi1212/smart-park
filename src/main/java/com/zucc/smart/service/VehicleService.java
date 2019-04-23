package com.zucc.smart.service;

import java.util.ArrayList;

import com.zucc.smart.domain.Vehicle;

public interface VehicleService {
	ArrayList<Vehicle> getUserVehicle(String user_id);

	void deleteVehicle(String cph);

	void addVehicle(String cph, String cartype, String user_id);

	ArrayList<Vehicle> getUserVehicleForAdmin(String check_id);
}
