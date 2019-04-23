package com.zucc.smart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zucc.smart.domain.Map;
import com.zucc.smart.domain.Parking;
import com.zucc.smart.service.ParkingService;
import com.zucc.smart.service.UserService;
import com.zucc.smart.service.VehicleService;
import com.zucc.smart.service.impl.Decode;
import com.zucc.smart.vObject.AreaVO;
import com.zucc.smart.vObject.ParkingTypeVO;
import com.zucc.smart.vObject.ParkingVO;
import com.zucc.smart.vObject.StreetVO;


@RestController
@RequestMapping("/park")
public class ParkingController {
	private static final Logger log = LoggerFactory.getLogger(ParkingController.class);

	@Autowired
	ParkingService parkingService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	VehicleService vehicleService;
    
    @RequestMapping(value = "/{user_id}/form", method = RequestMethod.GET)
    public ArrayList<ParkingVO> getParkingForm(@PathVariable("user_id") String user_id_obj) {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/park/"+ user_id + "/form");
        ArrayList<ParkingVO> listVO = new ArrayList<ParkingVO>();
        listVO = parkingService.getAllParking();
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
    
    @RequestMapping(value = {"/", "/{user_id}/add"}) 
	  public String addVehicle(@PathVariable("user_id") String user_id_obj, 
			  String cph, String cartype) throws IOException { 
		  String user_id = new String(Decode.decode(user_id_obj)); 
		  log.info("/park/"+ user_id + "/add ----- " + cph + "   " + cartype);
		  String flag = "true";
		  if(cph == "")
			  flag = "请输入车牌号";
		  else if(cartype == "")
			  flag = "请输入车辆类型";
		  else
			  vehicleService.addVehicle(cph, cartype, user_id);
		  
		  String str = "{\"flag\":\"" + flag + "\"}";
		  return str;
	  }
    
    @RequestMapping(value = {"/", "/admin/add"}) 
	  public String addParking(String parkcode, String parkname, String streetname,
			   String typename, String parking_amount, String lng, String lat) throws IOException { 
		  log.info("/park/admin/add ----- " + parkcode + "   " + parkname);
		  String flag = "true";
		  double lng_obj;
		  double lat_obj;
		  if(parkcode == "" || !isInteger(parkcode))
			  flag = "停车场编号输入错误";
		  else if(!parkingService.checkParkCode(parkcode))
			  flag = "该停车场编号已存在";
		  else if(parkname == "")
			  flag = "请输入停车场名";
		  else if(streetname == "")
			  flag = "请输入街道名";
		  else if(typename == "")
			  flag = "请输入停车场类型";
		  else if(parking_amount == "" || !isInteger(parking_amount))
			  flag = "停车位总数输入错误";
		  else if(lng == "")
			  flag = "请输入经度";
		  else if(lat == "")
			  flag = "请输入纬度";
		  //119.35,120.5
		  //29.883,30.55
		  else if(!isDouble(lng))
			  flag = "经度输入错误";
		  else if(!isDouble(lat))
			  flag = "纬度输入错误";
		  if(flag.equals("true")) {
			  lng_obj = Double.parseDouble(lng);
			  lat_obj = Double.parseDouble(lat);
			  if(lng_obj > 120.5 || lng_obj < 119.35)
				  flag = "经度范围错误";
			  else if(lat_obj > 30.55 || lat_obj < 29.883)
				  flag = "纬度范围错误";
		  }
		  
		  if(flag == "true")
			  parkingService.addParking(parkcode, parkname, streetname, typename, parking_amount, lng, lat);
		  
		  String str = "{\"flag\":\"" + flag + "\"}";
		  return str;
	  }
    
    public static boolean isInteger(String str) {      	
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
        return pattern.matcher(str).matches();  
    }
    
    public static boolean isDouble(String str) {
    	Pattern pattern = Pattern.compile("[0-9]+[.]{0,1}[0-9]*[dD]{0,1}"); 
    	return pattern.matcher(str).matches();
    }
}
