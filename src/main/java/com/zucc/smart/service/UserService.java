package com.zucc.smart.service;

import java.util.ArrayList;

import com.zucc.smart.domain.User;
import com.zucc.smart.valueObject.UserVO;

public interface UserService {
	User checkUser(String user_id, String user_pwd);
	
	User getUserById(String user_id);
	
	boolean addUser(User user);

	ArrayList<UserVO> userSearch(String searchWord);
}
