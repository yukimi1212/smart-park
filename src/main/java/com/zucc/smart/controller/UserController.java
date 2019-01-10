package com.zucc.smart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    
    @RequestMapping(value = {"/", "/{user_id}/map"})
    public String getMap(@PathVariable("user_id") String user_id) {
        log.info("/user"+ user_id +"/map");
        return "map";
    }
    
    @RequestMapping(value = {"/", "/{user_id}/open"})
    public String getOpenFlashChart(@PathVariable("user_id") String user_id) {
        log.info("/user"+ user_id +"/open");
        return "open";
    }
    
    @RequestMapping(value = {"/", "/{user_name}/home"})
    public String enterHome(@PathVariable("user_name") String user_name, Map<String, Object> map) {
        log.info("/user/{}/home");
//        JSONObject jsonObject = JSONObject.fromObject(objmap);
//    	Map jsonmap = (Map)jsonObject;
//    	String user_name = (String) jsonmap.get("user");
//    	Map usermap = (Map) jsonmap.get("user");
//    	String user_name = (String) usermap.get("user_name");
    	map.put("user_name", user_name);
        return "index";
    }

}
