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
@RequestMapping("/search")
public class SearchController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	ParkingService parkingService;
    
    @RequestMapping(value = "/form/user/{user_name}", method = RequestMethod.GET)
    public ArrayList<Parking> getFormSearch(@PathVariable("user_name") String user_name_obj, String searchWord) {
    	String user_name = new String (Decode.decode(user_name_obj));
    	log.info("/search/form/user/" + user_name + "-----" + searchWord);
    	
    	ArrayList<Parking> list = new ArrayList<Parking>();
		list = parkingService.parkingSearch(searchWord);		
		return list;
    }

    @RequestMapping(value = "/type/user/{user_name}", method = RequestMethod.GET)
    public ArrayList<ParkingTypeVO> getTypeSearch(@PathVariable("user_name") String user_name_obj, String searchWord) {
    	String user_name = new String (Decode.decode(user_name_obj));
    	log.info("/search/type/user/" + user_name + "-----" + searchWord);
    	
    	ArrayList<ParkingTypeVO> list = new ArrayList<ParkingTypeVO>();
		list = parkingService.typeSearch(searchWord);		
		return list;
    }
    
    @RequestMapping(value = "/area/user/{user_name}", method = RequestMethod.GET)
    public ArrayList<AreaVO> getAreaSearch(@PathVariable("user_name") String user_name_obj, String searchWord) {
    	String user_name = new String (Decode.decode(user_name_obj));
    	log.info("/search/area/user/" + user_name + "-----" + searchWord);
    	
    	ArrayList<AreaVO> list = new ArrayList<AreaVO>();
		list = parkingService.AreaSearch(searchWord);		
		return list;
    }
    
    @RequestMapping(value = "/street/user/{user_name}", method = RequestMethod.GET)
    public ArrayList<StreetVO> getStreetSearch(@PathVariable("user_name") String user_name_obj, String searchWord) {
    	String user_name = new String (Decode.decode(user_name_obj));
    	log.info("/search/street/user/" + user_name + "-----" + searchWord);
    	
    	ArrayList<StreetVO> list = new ArrayList<StreetVO>();
		list = parkingService.streetSearch(searchWord);		
		return list;
    }
    
}
