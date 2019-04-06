package com.zucc.smart.service;

import java.util.ArrayList;

import com.zucc.smart.domain.User;
import com.zucc.smart.domain.Vehicle;
import com.zucc.smart.vObject.TimeVO;
import com.zucc.smart.vObject.UserVO;
import com.zucc.smart.vObject.WordsVO;

public interface UserService {
	User checkUser(String user_id, String user_pwd);
	
	User getUserById(String user_id);
	
	boolean addUser(User user);

	ArrayList<UserVO> userSearch(String searchWord);

	ArrayList<WordsVO> getAvailableTags();

	void alterUser(String user_id, String user_gender, String user_age, String user_phone);

}
