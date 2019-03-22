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
import com.zucc.smart.valueObject.AreaVO;
import com.zucc.smart.valueObject.ParkingTypeVO;
import com.zucc.smart.valueObject.StreetVO;


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
    
    @RequestMapping(value = "/{user_name}/type", method = RequestMethod.GET)
    public ArrayList<ParkingTypeVO> getParkingType(@PathVariable("user_name") String user_name_obj) {
    	String user_name = new String (Decode.decode(user_name_obj));
    	log.info("/park/"+ user_name + "/type");
        ArrayList<ParkingTypeVO> list = new ArrayList<ParkingTypeVO>();
        
        list = parkingService.getParkingType();
        System.out.println(list.size() + "/" + list.get(0).getTypecode() + "/" + list.get(0).getTypename() + "/" + list.get(0).getAmount());
    	return list;
    }
    
    @RequestMapping(value = "/{user_name}/area", method = RequestMethod.GET)
    public ArrayList<AreaVO> getArea(@PathVariable("user_name") String user_name_obj) {
    	String user_name = new String (Decode.decode(user_name_obj));
    	log.info("/park/"+ user_name + "/area");
        ArrayList<AreaVO> list = new ArrayList<AreaVO>();
        
        list = parkingService.getArea();
        System.out.println(list.get(0).getBusinesscode() + "/" + list.get(0).getAreaname() + "/" + list.get(0).getAmount());
    	return list;
    }
    
    @RequestMapping(value = "/{user_name}/street", method = RequestMethod.GET)
    public ArrayList<StreetVO> getStreet(@PathVariable("user_name") String user_name_obj) {
    	String user_name = new String (Decode.decode(user_name_obj));
    	log.info("/park/"+ user_name + "/street");
    	ArrayList<StreetVO> list = new ArrayList<StreetVO>();
        
        list = parkingService.getStreet();
    	return list;
    }


}
