package com.zucc.smart.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import com.zucc.smart.domain.Parking;
import com.zucc.smart.mapper.ParkingMapper;
import com.zucc.smart.service.ParkingService;

@Service
public class ParkingServiceImpl implements ParkingService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    ParkingMapper parkingMapper;    
	
	@Override
	public ArrayList<Parking> getAllParking() {
		log.info("getAllParking: ");
        ArrayList<Parking> list = parkingMapper.getAllParking();
        return list;
	}

	@Override
	public ArrayList<String> getBusinesscode() {
		log.info("getBusinesscode: ");
		ArrayList<String> list = parkingMapper.getBusinesscode();
		return list;
	}

}
