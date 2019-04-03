package com.zucc.smart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zucc.smart.domain.Map;
import com.zucc.smart.domain.Parking;
import com.zucc.smart.service.ParkingService;
import com.zucc.smart.service.impl.Decode;
import com.zucc.smart.valueObject.AreaVO;
import com.zucc.smart.valueObject.ParkingTypeVO;
import com.zucc.smart.valueObject.ParkingVO;
import com.zucc.smart.valueObject.StreetVO;


@RestController
@RequestMapping("/park")
public class ParkingController {
	private static final Logger log = LoggerFactory.getLogger(ParkingController.class);

	@Autowired
	ParkingService parkingService;
    
    @RequestMapping(value = "/{user_id}/form", method = RequestMethod.GET)
    public ArrayList<ParkingVO> getParkingForm(@PathVariable("user_id") String user_id_obj) {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/park/"+ user_id + "/form");
        ArrayList<ParkingVO> listVO = new ArrayList<ParkingVO>();
        listVO = parkingService.getAllParking();
//        System.out.println("list.size()：" +  list.size());
    	return listVO;
    }
    
    @RequestMapping(value = "/{user_id}/type", method = RequestMethod.GET)
    public ArrayList<ParkingTypeVO> getParkingType(@PathVariable("user_id") String user_id_obj) {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/park/"+ user_id + "/type");
        ArrayList<ParkingTypeVO> list = new ArrayList<ParkingTypeVO>();
        
        list = parkingService.getParkingType();
    	return list;
    }
    
    @RequestMapping(value = "/{user_id}/area", method = RequestMethod.GET)
    public ArrayList<AreaVO> getArea(@PathVariable("user_id") String user_id_obj) {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/park/"+ user_id + "/area");
        ArrayList<AreaVO> list = new ArrayList<AreaVO>();
        
        list = parkingService.getArea();
    	return list;
    }
    
    @RequestMapping(value = "/{user_id}/street", method = RequestMethod.GET)
    public ArrayList<StreetVO> getStreet(@PathVariable("user_id") String user_id_obj) {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/park/"+ user_id + "/street");
    	ArrayList<StreetVO> list = new ArrayList<StreetVO>();
        
        list = parkingService.getStreet();
    	return list;
    }
    
    @RequestMapping(value = "/{user_id}/map", method = RequestMethod.GET)
    public ArrayList<Map> getParkingMap(@PathVariable("user_id") String user_id_obj) {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/park/"+ user_id + "/map");
    	ArrayList<Map> list = new ArrayList<Map>();
        
        list = parkingService.getParkingMap();
    	return list;
    }

}
