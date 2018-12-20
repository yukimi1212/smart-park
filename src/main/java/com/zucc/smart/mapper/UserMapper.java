package com.zucc.smart.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.zucc.smart.domain.User;

@Mapper
public interface UserMapper {
	
	User checkUser(String user_id, String user_pwd);

	User getUserById(String user_id);
	
	void saveUser(User user);
	
	void deleteUser(String user_id);

}