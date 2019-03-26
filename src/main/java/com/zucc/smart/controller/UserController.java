package com.zucc.smart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zucc.smart.domain.Parking;
import com.zucc.smart.domain.User;
import com.zucc.smart.service.UserService;
import com.zucc.smart.service.impl.Decode;
import com.zucc.smart.service.impl.build7daysTxt;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	 @Autowired
	 UserService userService;

    @RequestMapping(value = {"/", "/{user_id}/map"})
    public String getMap(@PathVariable("user_id") String user_id_obj, Map<String, Object> map) {
    	String user_id = new String (Decode.decode(user_id_obj));
    	String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
    	log.info("/user/"+ user_id +"/map");
        return "map";
    }
    
    @RequestMapping(value = {"/", "/{user_id}/analysis"})
    public String getOpenFlashChart(@PathVariable("user_id") String user_id_obj, Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/analysis");
        double[] data1 = new double[]{4,8,9,3,2,6,8,6,3,7,3,5};
        build7daysTxt.alertBar1(data1);
        String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
        map.put("user_id", user_id);
        return "analysisTest";
    }
    
    @RequestMapping(value = {"/", "/{user_id}/home"})
    public String enterHome(@PathVariable("user_id") String user_id_obj, Map<String, Object> map) {
        String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/" + user_id + "/home");
    	String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
    	map.put("user_id", user_id);
        return "index";
    }
    
    
    @RequestMapping(value = {"/", "/{user_id}/form"})
    public String gotoParkingForm(@PathVariable("user_id") String user_id_obj, Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/form");
    	String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
    	map.put("user_id", user_id);
    	map.put("searchWord", "");
        return "parkingForm";
    }

    
    @RequestMapping(value = {"/", "/{user_id}/type"})
    public String gotoParkingType(@PathVariable("user_id") String user_id_obj, Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/type");
    	String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
    	map.put("user_id", user_id);
    	map.put("searchWord", "");
        return "parkingType";
    }
    
    @RequestMapping(value = {"/", "/{user_id}/area"})
    public String gotoParkingArea(@PathVariable("user_id") String user_id_obj, Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/area");
    	String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
    	map.put("user_id", user_id);
    	map.put("searchWord", "");
        return "parkingArea";
    }
    
    @RequestMapping(value = {"/", "/{user_id}/street"})
    public String gotoParkingStreet(@PathVariable("user_id") String user_id_obj, Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/street");
    	String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
    	map.put("user_id", user_id);
    	map.put("searchWord", "");
        return "parkingStreet";
    }
    
    @RequestMapping(value = {"/", "/{user_id}/record"})
    public String gotoParkingRecord(@PathVariable("user_id") String user_id_obj, Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/record");
    	String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
    	map.put("user_id", user_id);
        return "record";
    }
    
    @RequestMapping(value = {"/", "/{user_id}/user"})
    public String getUserList(@PathVariable("user_id") String user_id_obj, Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/user/"+ user_id + "/user");
    	String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
    	map.put("user_id", user_id);
        return "user";
    }
    
    @RequestMapping(value = {"/", "/{user_id}/{searchWord}"})
    public String doSearch(@PathVariable("user_id") String user_id_obj, @PathVariable("searchWord") String searchWord, Map<String, Object> map) throws IOException {
    	String user_id = new String (Decode.decode(user_id_obj));
    	String[] word = searchWord.split("&");
    	searchWord = word[0];
    	String source = word[1];
    	log.info("/user/"+ user_id + "/" + searchWord + "/" + source);
    	String user_name = (userService.getUserById(user_id)).getUser_name();
    	map.put("user_name", user_name);
    	map.put("user_id", user_id);
    	map.put("searchWord", searchWord);
    	
    	if(source.equals("form"))
    		return "searchForm";
    	else if(source.equals("type"))
    		return "searchType";
    	else if(source.equals("street"))
    		return "searchStreet";
    	else if(source.equals("area"))
    		return "searchArea";
    	else
    		return "searchRecord";
    }
}
