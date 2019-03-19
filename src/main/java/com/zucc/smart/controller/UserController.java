package com.zucc.smart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
	 
    @RequestMapping(value = "/{user_id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable("user_id") String user_id, @RequestBody Map<String, Object> map) {
//    	JSONObject jsonObject = JSONObject.fromObject(user_id);
//    	Map jsonmap = (Map)jsonObject;
//    	System.out.println("user_id: " + user_id);

        log.info("/user/" + user_id);
        String user_name = (userService.getUserById(user_id)).getUser_name();
        map.put("user_id", user_id);
        map.put("user_name", user_name);
        map.put("time", new Date());
    	return "helloworld";
    }

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
    
    @RequestMapping(value = {"/", "/{user_name}/parking"})
    public String getParkingForm(@PathVariable("user_name") String user_name_obj, Map<String, Object> map) throws IOException {
    	String user_name = new String (Decode.decode(user_name_obj));
    	log.info("/user/"+ user_name + "/parking");
        map.put("user_name", user_name);
        return "parkingForm";
    }
    
    @RequestMapping(value = {"/", "/{user_name}/home"})
    public String enterHome(@PathVariable("user_name") String user_name_obj, Map<String, Object> map) {
        String user_name = new String (Decode.decode(user_name_obj));
    	log.info("/user/" + user_name + "/home");
    	map.put("user_name", user_name);
        return "index";
    }

}
