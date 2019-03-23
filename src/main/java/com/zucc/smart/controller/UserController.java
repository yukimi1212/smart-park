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

    @RequestMapping(value = {"/", "/{user_name}/map"})
    public String getMap(@PathVariable("user_name") String user_name_obj) {
    	String user_name = new String (Decode.decode(user_name_obj));
    	log.info("/user/"+ user_name +"/map");
        return "map";
    }
    
    @RequestMapping(value = {"/", "/{user_name}/analysis"})
    public String getOpenFlashChart(@PathVariable("user_name") String user_name_obj, Map<String, Object> map) throws IOException {
    	String user_name = new String (Decode.decode(user_name_obj));
    	log.info("/user/"+ user_name + "/analysis");
        double[] data1 = new double[]{4,8,9,3,2,6,8,6,3,7,3,5};
        
        build7daysTxt.alertBar1(data1);
        map.put("user_name", user_name);
        return "analysisTest";
    }
    
    @RequestMapping(value = {"/", "/{user_name}/home"})
    public String enterHome(@PathVariable("user_name") String user_name_obj, Map<String, Object> map) {
        String user_name = new String (Decode.decode(user_name_obj));
    	log.info("/user/" + user_name + "/home");
    	map.put("user_name", user_name);
        return "index";
    }
    
    
    @RequestMapping(value = {"/", "/{user_name}/form"})
    public String gotoParkingForm(@PathVariable("user_name") String user_name_obj, Map<String, Object> map) throws IOException {
    	String user_name = new String (Decode.decode(user_name_obj));
    	log.info("/user/"+ user_name + "/form");
    	map.put("user_name", user_name);
    	map.put("searchWord", "");
        return "parkingForm";
    }

    
    @RequestMapping(value = {"/", "/{user_name}/type"})
    public String gotoParkingType(@PathVariable("user_name") String user_name_obj, Map<String, Object> map) throws IOException {
    	String user_name = new String (Decode.decode(user_name_obj));
    	log.info("/user/"+ user_name + "/type");
    	map.put("user_name", user_name);
    	map.put("searchWord", "");
        return "parkingType";
    }
    
    @RequestMapping(value = {"/", "/{user_name}/area"})
    public String gotoParkingArea(@PathVariable("user_name") String user_name_obj, Map<String, Object> map) throws IOException {
    	String user_name = new String (Decode.decode(user_name_obj));
    	log.info("/user/"+ user_name + "/area");
    	map.put("user_name", user_name);
    	map.put("searchWord", "");
        return "parkingArea";
    }
    
    @RequestMapping(value = {"/", "/{user_name}/street"})
    public String gotoParkingStreet(@PathVariable("user_name") String user_name_obj, Map<String, Object> map) throws IOException {
    	String user_name = new String (Decode.decode(user_name_obj));
    	log.info("/user/"+ user_name + "/street");
    	map.put("user_name", user_name);
    	map.put("searchWord", "");
        return "parkingStreet";
    }
    
    @RequestMapping(value = {"/", "/{user_name}/{searchWord}"})
    public String doSearch(@PathVariable("user_name") String user_name_obj, @PathVariable("searchWord") String searchWord,Map<String, Object> map) throws IOException {
    	String user_name = new String (Decode.decode(user_name_obj));
    	String[] word = searchWord.split("&");
    	searchWord = word[0];
    	String source = word[1];
    	log.info("/user/"+ user_name + "/" + searchWord + "/" + source);
    	System.out.println(user_name_obj + "***" + searchWord);
    	map.put("user_name", user_name);
    	map.put("searchWord", searchWord);
    	
    	if(source.equals("form"))
    		return "searchForm";
    	else if(source.equals("type"))
    		return "searchType";
    	else if(source.equals("street"))
    		return "searchStreet";
    	else
    		return "searchArea";
    }
}
