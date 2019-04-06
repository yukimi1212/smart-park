package com.zucc.smart.controller;


import java.io.IOException;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zucc.smart.domain.User;
import com.zucc.smart.service.BuildLngAndLat;
import com.zucc.smart.service.DataManageService;
import com.zucc.smart.service.UserService;


@RestController
@RequestMapping("/login")
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    
    @Autowired
    UserService userService;
   
    @Autowired
    DataManageService dataManageService;
    
    @Autowired
    BuildLngAndLat bulidLngAndLat;
    
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String loginUser(String user_id, String user_pwd) throws IOException {
        log.info("/login/user/" + user_id);
        
//        dataManageService.updateRecord();
//        bulidLngAndLat.bulidLngAndLat();
        
    	String str = "";
        if(user_id == "")
        	str = "|用户名为空|";
        else if(user_pwd == "")
        	str = "|密码为空|";
        else {
        	User user = userService.checkUser(user_id, user_pwd);
        	if(user != null)
        		str = "|" + user.getUser_id() + "|";
        	else
        		str = "|不存在|";
        }
    	return str;
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register (@RequestParam(value="user_id") String user_id, @RequestParam("user_name") String user_name,
    		@RequestParam("user_pwd") String user_pwd, @RequestParam("reuser_pwd") String reuser_pwd, @RequestParam("user_gender") String user_gender,
    		@RequestParam("user_age") String user_age, @RequestParam("user_phone") String user_phone) {
        log.info("/login/register/" + user_id + "---user_name：" + user_name);
        String str = "";
        if(user_id == "") {
        	str = "|id为空|";
        }
        else if(user_name == "") {
        	str = "|name为空|";
        }
        else if(user_pwd == "") {
        	str = "|pwd为空|";
        }
        else if(userService.getUserById(user_id) != null) {
        	str = "|id已存在|";
        }
        else if(user_pwd.compareTo(reuser_pwd) != 0) {
        	str = "|pwd不一致|";
        }
        else if(user_age != "" && (!isInteger(user_age) || Integer.parseInt(user_age) > 100 || Integer.parseInt(user_age) < 0)) {
        	str = "|age输入错误|";
        }
        else if(user_phone != "" && !isInteger(user_phone)) {
        	str = "|phone输入错误|";
        }
        else {
        	User adduser = new User();
            adduser.setUser_id(user_id);
            adduser.setUser_name(user_name);
            adduser.setUser_pwd(user_pwd);
            adduser.setUser_gender(user_gender);
            if(user_age != "")
            	adduser.setUser_age(Integer.parseInt(user_age));
//            if(user_age != null)
//            	adduser.setUser_age(Integer.parseInt(user_age));
            adduser.setUser_phone(user_phone);
            adduser.setUser_identity("user");
        	boolean flag = userService.addUser(adduser);
        	if(flag) {
        		User user = userService.getUserById(user_id);
        		str = "|" + user.getUser_id() + "|";
        	}
        }
        return str;
    }
    
    public static boolean isInteger(String str) {      	
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
        return pattern.matcher(str).matches();  
    }
   
}