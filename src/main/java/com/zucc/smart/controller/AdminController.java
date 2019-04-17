package com.zucc.smart.controller;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zucc.smart.service.DataManageService;
import com.zucc.smart.service.ParkingService;
import com.zucc.smart.service.VehicleService;
import com.zucc.smart.service.impl.Decode;


@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger log = LoggerFactory.getLogger(AdminController.class);
	 
	@Autowired
	ParkingService parkingService;
	
    @RequestMapping(value = {"/", "/{searchWord}/{source}"})
    public String searchRecord(@PathVariable("searchWord") String searchWord, @PathVariable("source") String source, Map<String, Object> map) throws IOException {
    	log.info("/admin/" + searchWord + "/" + source);
    	
    	map.put("user_id", "admin");
    	map.put("user_name", "管理");
    	map.put("searchWord", searchWord);
    	map.put("source", source);
    	return "searchRecord";
    }
    
    @RequestMapping(value = {"/", "/{searchWord}/user"})
    public String searchUser(@PathVariable("searchWord") String searchWord, Map<String, Object> map) throws IOException {
    	log.info("/admin/" + searchWord + "/user");
    	map.put("user_id", "admin");
    	map.put("user_name", "管理");
    	map.put("searchWord", searchWord);
    	return "searchUser";
    }
    
    @RequestMapping(value = {"/", "/{check_id}/vehicle"})
    public String getUserVehicle(@PathVariable("check_id") String check_id, Map<String, Object> map) throws IOException {
    	log.info("/admin/" + check_id + "/vehicle");
    	map.put("user_id", "admin");
    	map.put("user_name", "管理");
    	map.put("check_id", check_id);
    	return "showVehicle";
    }
    
    @RequestMapping(value = {"/", "/add"}) 
	public String addParking(Map<String, Object>map) throws IOException { 
		log.info("/admin/add");
		map.put("user_id", "admin");
		map.put("user_name", "管理");
		return "addParking"; 
	}
    
    @RequestMapping(value = {"/", "/{parkcode}/delete"}) 
   	public String deleteParking(@PathVariable("parkcode") String parkcode, Map<String, Object>map) throws IOException { 
    	log.info("/park/" + parkcode + "/delete");   
    	map.put("user_id", "admin");
		map.put("user_name", "管理");
    	map.put("searchWord", "");
    	map.put("source", "form");
    	
    	parkingService.deleteParking(parkcode);
   		return "parkingForm"; 
   	}

}
