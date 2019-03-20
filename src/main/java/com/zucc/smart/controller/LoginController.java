package com.zucc.smart.controller;


import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zucc.smart.domain.User;
import com.zucc.smart.service.UserService;


@RestController
@RequestMapping("/login")
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    
    @Autowired
    UserService userService;
   
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String loginUser(String user_id, String user_pwd) {
        log.info("/login/user/" + user_id);
    	String str = "";
        if(user_id == "")
        	str = "|用户名为空|";
        else if(user_pwd == "")
        	str = "|密码为空|";
        else {
        	User user = userService.checkUser(user_id, user_pwd);
        	if(user != null)
        		str = "|" + user.getUser_name() + "|";
        	else
        		str = "|不存在|";
        }
    	return str;
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(String user_id, String user_name, String user_pwd, String reuser_pwd, String user_gender, String user_age, String user_phone) {
        log.info("/**NEW**/login/register/" + user_id + "/gender：" + user_gender + "/age：" + user_age + "/phone：" + user_phone);
        String str = "";
        boolean ageFlag = true; 
        if(user_age != null || user_age != "" || !user_age.equals("null")) {
    		System.out.println("age 非空" + user_age);
    		if(Integer.parseInt(user_age) > 100 || Integer.parseInt(user_age) < 0) {
    			ageFlag = false;
    			System.out.println("age 错误" + user_age);
    		}			
    	}
        if(user_id == "")
        	str = "|id为空|";
        else if(user_pwd == "")
        	str = "|密码为空|";
        else if(user_name == "")
        	str = "|用户名为空|";
        else if(userService.getUserById(user_id) != null) 
        	str = "|id已存在|";
        else if(!user_pwd.equals(reuser_pwd))
        	str = "|密码不一致|";
        else if(!ageFlag) 
        	str = "|age输入错误|";     
        else if(!isInteger(user_phone)) 
        	str = "|phone输入错误|";
        
        else {
        	User adduser = new User();
            adduser.setUser_id(user_id);
            adduser.setUser_name(user_name);
            adduser.setUser_pwd(user_pwd);
            adduser.setUser_gender(user_gender);
            if(isInteger(user_age))
            	adduser.setUser_age(Integer.parseInt(user_age));
            adduser.setUser_phone(user_phone);
            adduser.setUser_identity("user");
        	boolean flag = userService.addUser(adduser);
        	if(flag) {
        		User user = userService.getUserById(user_id);
        		user = userService.getUserById(user_id);
        		str = "|" + user.getUser_name() + "|";
        	}
        }
        System.out.println("str: " + str);
    	return str;
    }
    
    public static boolean isInteger(String str) {      	
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
        return pattern.matcher(str).matches();  
    }
   
}