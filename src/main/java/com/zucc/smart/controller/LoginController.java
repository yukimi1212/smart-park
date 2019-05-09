package com.zucc.smart.controller;


import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zucc.smart.domain.User;
import com.zucc.smart.service.BuildLngAndLat;
import com.zucc.smart.service.DataManageService;
import com.zucc.smart.service.UserService;
import com.zucc.smart.service.impl.Decode;


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
        
    	String flag = "";

        if(user_id == "") 
        	flag = "id为空";       
        else if(user_pwd == "")
        	flag = "密码为空";
        else {
        	User user = userService.checkUser(user_id, user_pwd);
        	if(user != null)
        		flag = user.getUser_id();
        	else
        		flag = "不存在";
        }
        
        String str = "{\"flag\":\"" + flag + "\"}";
    	return str;
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register (@RequestParam(value="user_id") String user_id, @RequestParam("user_name") String user_name,
    		@RequestParam("user_pwd") String user_pwd, @RequestParam("reuser_pwd") String reuser_pwd, @RequestParam("user_gender") String user_gender,
    		@RequestParam("user_phone") String user_phone) {
        log.info("/login/register/" + user_id + "---user_name：" + user_name);
        String flag = "";
        if(user_id == "") 
        	flag = "id为空";        
        else if(user_name == "") 
        	flag = "name为空";        
        else if(user_pwd == "") 
        	flag = "pwd为空";        
        else if(userService.getUserById(user_id) != null) 
        	flag = "id已存在";        
        else if(user_pwd.compareTo(reuser_pwd) != 0) 
        	flag = "pwd不一致";        
        else if(user_phone != "" && !isInteger(user_phone)) 
        	flag = "phone输入错误";        
        else {
        	User adduser = new User();
            adduser.setUser_id(user_id);
            adduser.setUser_name(user_name);
            adduser.setUser_pwd(user_pwd);
            adduser.setUser_gender(user_gender);
            adduser.setUser_phone(user_phone);
            adduser.setUser_identity("user");
        	boolean addflag = userService.addUser(adduser);
        	if(addflag) {
        		User user = userService.getUserById(user_id);
        		flag = user.getUser_id();
        	}
        }
        
        String str = "{\"flag\":\"" + flag + "\"}";
        return str;
    }

    
    @RequestMapping(value = {"/", "/{user_id}/alter"}, method = RequestMethod.POST) 
   	public String alterPassword(@PathVariable("user_id") String user_id_obj, String old_pwd, String new_pwd) throws IOException { 
       	String user_id = new String(Decode.decode(user_id_obj)); 
       	log.info("/login/"+ user_id + "/alter  -- " + old_pwd + " -- " + new_pwd);
       	String flag = "";
       	flag = userService.alterPwd(user_id, old_pwd, new_pwd);
       	String str = "{\"flag\":\"" + flag + "\"}";
       	return str; 
    }
    
    public static boolean isInteger(String str) {      	
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
        return pattern.matcher(str).matches();  
    }
   
}