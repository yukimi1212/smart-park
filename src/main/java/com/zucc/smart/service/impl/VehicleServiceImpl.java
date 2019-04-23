package com.zucc.smart.service.impl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zucc.smart.domain.Vehicle;
import com.zucc.smart.mapper.VehicleMapper;
import com.zucc.smart.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	private static final Logger log = LoggerFactory.getLogger(VehicleServiceImpl.class);
	 
	@Autowired
    VehicleMapper vehicleMapper;
	
	@Override
	public ArrayList<Vehicle> getUserVehicle(String user_id) {
		log.info("getUserVehicle：" + user_id);
		ArrayList<Vehicle> list = new ArrayList<Vehicle>();
		list = vehicleMapper.getUserVehicle(user_id);
		return list;
	}

	@Override
	public ArrayList<Vehicle> getUserVehicleForAdmin(String check_id) {
		log.info("getUserVehicleForAdmin：" + check_id);
		ArrayList<Vehicle> list = new ArrayList<Vehicle>();
		list = vehicleMapper.getUserVehicleForAdmin(check_id);
		return list;
	}
	
	@Override
	public void deleteVehicle(String cph) {
		log.info("deleteVehicle：" + cph);
		vehicleMapper.deleteVehicle(cph);
	}

	@Override
	public void addVehicle(String cph, String cartype, String user_id) {
		log.info("addVehicle：" + cph + "   " + cartype + "   " + user_id);
		vehicleMapper.addVehicle(cph, cartype, user_id);
	}

}
