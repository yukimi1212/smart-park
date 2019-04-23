package com.zucc.smart.mapper;


import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.zucc.smart.domain.User;

@Mapper
public interface UserMapper {
	
	User checkUser(String user_id, String user_pwd);

	ArrayList<User> getUserById(String user_id);
	
	void addUser(User user);
	
	void deleteUser(String user_id);
	
	ArrayList<User> getAllUser();

	ArrayList<User> searchUser(String searchWord);

	void alterUser(String user_id, String user_gender, String user_phone);

	void alterPwd(String user_id);
}
