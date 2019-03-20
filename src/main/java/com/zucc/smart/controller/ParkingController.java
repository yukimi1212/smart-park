package com.zucc.smart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zucc.smart.domain.Parking;
import com.zucc.smart.service.ParkingService;
import com.zucc.smart.service.impl.Decode;


@RestController
@RequestMapping("/park")
public class ParkingController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	ParkingService parkingService;
    
    @RequestMapping(value = "/{user_name}/parking", method = RequestMethod.GET)
    public ArrayList<Parking> getParkingForm(@PathVariable("user_name") String user_name_obj) {
    	String user_name = new String (Decode.decode(user_name_obj));
    	log.info("/park/"+ user_name + "/parking");
        ArrayList<Parking> list = new ArrayList<Parking>();
        list = parkingService.getAllParking();
    	return list;
    }


}
