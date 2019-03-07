package com.zucc.smart.service;

import com.zucc.smart.domain.User;

public interface UserService {
	User checkUser(String user_name, String user_pwd);
	
	User getUserById(String user_id);
	
	boolean addUser(User user);
}
