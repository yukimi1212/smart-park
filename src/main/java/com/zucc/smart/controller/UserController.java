package com.zucc.smart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zucc.smart.domain.User;
import com.zucc.smart.service.UserService;
import com.zucc.smart.service.VehicleService;
import com.zucc.smart.service.impl.Decode;


@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	 @Autowired
	 UserService userService;
	 
	 @Autowired
	 VehicleService vehicleService;

    @RequestMapping(value = {"/", "/{user_id}/map"})
    public String getMap(@PathVariable("user_id") String user_id_obj, 
    		Map<String, Object> map) {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id +"/map");
    	String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_id", user_id);
    	map.put("user_name", user_name);
        return "map";
    } 
    
    @RequestMapping(value = {"/", "/{user_id}/chartArea"})
    public String getChartArea(@PathVariable("user_id") String user_id_obj, 
    		Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/chartArea");
        String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
        map.put("user_id", user_id);
        map.put("searchWord", "");
        map.put("source", "recordarea");
        return "parkingArea";
    }
    
    @RequestMapping(value = {"/", "/{user_id}/chartStreet"})
    public String getChartStreet(@PathVariable("user_id") String user_id_obj, 
    		Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/chartStreet");
        String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
        map.put("user_id", user_id);
        map.put("searchWord", "");
        map.put("source", "recordstreet");
        return "parkingStreet";
    }
    
    @RequestMapping(value = {"/", "/{user_id}/chartType"})
    public String getChartType(@PathVariable("user_id") String user_id_obj, 
    		Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/chartType");
        String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
        map.put("user_id", user_id);
        map.put("searchWord", "");
        map.put("source", "recordtype");
        return "parkingType";
    }
    
    @RequestMapping(value = {"/", "/{user_id}/viewStreet"})
    public String getViewStreet(@PathVariable("user_id") String user_id_obj, 
    		Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/viewStreet");
        String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
        map.put("user_id", user_id);
        map.put("searchWord", "");
        map.put("source", "recordstreet");
        return "chartStreet";
    }
    
    @RequestMapping(value = {"/", "/{user_id}/viewArea"})
    public String getViewArea(@PathVariable("user_id") String user_id_obj, 
    		Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/viewArea");
        String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
        map.put("user_id", user_id);
        map.put("searchWord", "");
        map.put("source", "recordarea");
        return "chartArea";
    }
    
    @RequestMapping(value = {"/", "/{user_id}/viewType"})
    public String getViewType(@PathVariable("user_id") String user_id_obj, 
    		Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/viewType");
        String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
        map.put("user_id", user_id);
        map.put("searchWord", "");
        map.put("source", "recordtype");
        return "chartType";
    }
   
    
    @RequestMapping(value = {"/", "/{user_id}/chartTime"})
    public String getChartTime(@PathVariable("user_id") String user_id_obj, 
    		Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/chartTime");
        String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
        map.put("user_id", user_id);
        return "chartTime";
    }
    
    @RequestMapping(value = {"/", "/{user_id}/home"})
    public String enterHome(@PathVariable("user_id") String user_id_obj, 
    		Map<String, Object> map) {
        String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/" + user_id + "/home");
    	String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
    	map.put("user_id", user_id);
        return "index";
    }
    
    
    @RequestMapping(value = {"/", "/{user_id}/form"})
    public String gotoParkingForm(@PathVariable("user_id") String user_id_obj, 
    		Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/form");
    	String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
    	map.put("user_id", user_id);
    	map.put("searchWord", "");
    	map.put("source", "form");
    	System.out.println("form");
        return "parkingForm";
    }
    
    @RequestMapping(value = {"/", "/{user_id}/formpark"})
    public String gotoParkingFormByParking(@PathVariable("user_id") String user_id_obj, 
    		Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/formpark");
    	String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
    	map.put("user_id", user_id);
    	map.put("searchWord", "");
    	map.put("source", "formpark");
        return "parkingForm";
    }
    
    @RequestMapping(value = {"/", "/{user_id}/formstreet"})
    public String gotoParkingFormByStreet(@PathVariable("user_id") String user_id_obj, 
    		Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/formstreet");
    	String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
    	map.put("user_id", user_id);
    	map.put("searchWord", "");
    	map.put("source", "formstreet");
        return "parkingForm";
    }
    
    @RequestMapping(value = {"/", "/{user_id}/formarea"})
    public String gotoParkingFormByArea(@PathVariable("user_id") String user_id_obj, 
    		Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/formarea");
    	String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
    	map.put("user_id", user_id);
    	map.put("searchWord", "");
    	map.put("source", "formarea");
        return "parkingForm";
    }

    
    @RequestMapping(value = {"/", "/{user_id}/type"})
    public String gotoParkingType(@PathVariable("user_id") String user_id_obj, 
    		Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/type");
    	String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
    	map.put("user_id", user_id);
    	map.put("searchWord", "");
    	map.put("source", "parkingtype");
        return "parkingType";
    }
    
    @RequestMapping(value = {"/", "/{user_id}/area"})
    public String gotoParkingArea(@PathVariable("user_id") String user_id_obj, 
    		Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/area");
    	String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
    	map.put("user_id", user_id);
    	map.put("searchWord", "");
    	map.put("source", "parkingarea");
        return "parkingArea";
    }
    
    @RequestMapping(value = {"/", "/{user_id}/street"})
    public String gotoParkingStreet(@PathVariable("user_id") String user_id_obj, 
    		Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/street");
    	String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
    	map.put("user_id", user_id);
    	map.put("searchWord", "");
    	map.put("source", "parkingstreet");
        return "parkingStreet";
    }
    
    @RequestMapping(value = {"/", "/{user_id}/record"})
    public String gotoParkingRecord(@PathVariable("user_id") String user_id_obj, 
    		Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/record");
    	String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("search_name", user_name);
    	map.put("search_id", user_id);
    	map.put("user_name", user_name);
    	map.put("user_id", user_id);
    	map.put("source", "record");
        return "showRecord";
    }
    
    @RequestMapping(value = {"/", "/{user_id}/recordcph"})
    public String gotoParkingRecordCPH(@PathVariable("user_id") String user_id_obj, 
    		Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/recordcph");
    	String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("search_name", user_name);
    	map.put("search_id", user_id);
    	map.put("user_name", user_name);
    	map.put("user_id", user_id);
    	map.put("source", "recordcph");
        return "showRecord";
    }
    
    @RequestMapping(value = {"/", "/{user_id}/recordpark"})
    public String gotoParkingRecordParking(@PathVariable("user_id") String user_id_obj, 
    		Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/recordpark");
    	String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("search_name", user_name);
    	map.put("search_id", user_id);
    	map.put("user_name", user_name);
    	map.put("user_id", user_id);
    	map.put("source", "recordpark");
        return "showRecord";
    }
    
    @RequestMapping(value = {"/", "/{user_id}/recordstreet"})
    public String gotoParkingRecordStreet(@PathVariable("user_id") String user_id_obj, 
    		Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/recordstreet");
    	String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("search_name", user_name);
    	map.put("search_id", user_id);
    	map.put("user_name", user_name);
    	map.put("user_id", user_id);
    	map.put("source", "recordstreet");
        return "showRecord";
    }
    
    @RequestMapping(value = {"/", "/{user_id}/recordarea"})
    public String gotoParkingRecordArea(@PathVariable("user_id") String user_id_obj, 
    		Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/recordarea");
    	String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("search_name", user_name);
    	map.put("search_id", user_id);
    	map.put("user_name", user_name);
    	map.put("user_id", user_id);
    	map.put("source", "recordarea");
        return "showRecord";
    }
    
    @RequestMapping(value = {"/", "/{search_id}/record&"})
    public String getUserParkingRecord(@PathVariable("search_id") String search_id_obj, 
    		Map<String, Object> map) throws IOException {
    	String search_id = new String (Decode.decode(search_id_obj));
    	log.info("/user/admin/record ----- " + search_id);
    	String search_name = (userService.getUserById(search_id)).getUser_name();
    	map.put("search_name", search_name);
    	map.put("search_id", search_id);
    	map.put("user_name", "管理");
    	map.put("user_id", "admin");
        return "showRecord";
    }
    
    @RequestMapping(value = {"/", "/{user_id}/user"})
    public String getUserList(@PathVariable("user_id") String user_id_obj, 
    		Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/user");
    	String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
    	map.put("user_id", user_id);
        return "showUser";
    }
    
    @RequestMapping(value = {"/", "/{user_id}/vehicle"})
    public String getUserVehicle(@PathVariable("user_id") String user_id_obj, 
    		Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/vehicle");
    	String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
    	map.put("user_id", user_id);
        return "showVehicle";
    }
    
	
	  @RequestMapping(value = {"/", "/{user_id}/add"}) 
	  public String addVehicle(@PathVariable("user_id") String user_id_obj, 
			  Map<String, Object>map) throws IOException { 
		  String user_id = new String(Decode.decode(user_id_obj)); 
		  log.info("/user/"+ user_id + "/add");
		  String user_name = (userService.getUserById(user_id)).getUser_name(); 
		  map.put("user_name",user_name); 
		  map.put("user_id", user_id); 
		  return "addVehicle"; 
	  }

	  
	  @RequestMapping(value = {"/", "/{user_id}/alter"}) 
	  public String alterUser(@PathVariable("user_id") String user_id_obj, 
			  Map<String, Object>map) throws IOException { 
		  String user_id = new String(Decode.decode(user_id_obj)); 
		  log.info("/user/"+ user_id + "/alter");
		  User user = userService.getUserById(user_id); 
		  map.put("user_name",user.getUser_name());
		  map.put("user_gender", user.getUser_gender());
		  map.put("user_phone", user.getUser_phone());
		  map.put("user_id", user_id); 
		  return "alterUser"; 
	  }
	  
	  @RequestMapping(value = {"/", "/{user_id}/alterU"}) 
	  public String alterUser(@PathVariable("user_id") String user_id_obj, String user_gender, 
			  String user_phone, Map<String, Object>map) throws IOException { 
		  String user_id = new String(Decode.decode(user_id_obj)); 
		  log.info("/user/"+ user_id + "/alterU ----- " + user_gender + "   " + user_phone);
		  userService.alterUser(user_id, user_gender, user_phone);
		  String user_name = (userService.getUserById(user_id)).getUser_name(); 
		  map.put("user_name",user_name); 
		  map.put("user_id", user_id); 
		  return "showUser";   
	  }
	 
    
    @RequestMapping(value = {"/", "/{user_id}/delete"})
    public String deleteVehicle(@PathVariable("user_id") String user_id_obj, 
    		Map<String, Object> map) throws IOException {
    	String[] n = user_id_obj.split("&car&");
    	String user_id = new String (Decode.decode(n[0]));
    	String cph = n[1];
    	log.info("/user/"+ user_id + "/vehicle ----- cph：" + cph);
    	vehicleService.deleteVehicle(cph);
    	String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
    	map.put("user_id", user_id);
        return "showVehicle";
    }
    
    @RequestMapping(value = {"/", "/{user_id}/{searchWord}"})
    public String doSearch(@PathVariable("user_id") String user_id_obj, 
    		@PathVariable("searchWord") String searchWord, Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	String[] word = searchWord.split("&");
    	searchWord = word[0];
    	String source = word[1];
    	log.info("/user/"+ user_id + "/" + searchWord + "/" + source);
    	String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
    	map.put("user_id", user_id);
    	map.put("searchWord", searchWord);
    	map.put("source", source);
    	    	
    	if(source.equals("form") || source.equals("formpark") || source.equals("formstreet") || source.equals("formarea"))
    		return "searchForm";
    	else if(source.equals("parkingtype") || source.equals("recordtypeStatic"))
    		return "searchType";
    	else if(source.equals("parkingstreet") || source.equals("recordstreetStatic"))
    		return "searchStreet";
    	else if(source.equals("parkingarea") || source.equals("recordareaStatic"))
    		return "searchArea";
    	else
    		return "searchRecord";
    }
    
    
}
