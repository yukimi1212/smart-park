package com.zucc.smart.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zucc.smart.domain.User;
import com.zucc.smart.mapper.UserMapper;
import com.zucc.smart.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;    
   
    @Transactional
	@Override
	public User checkUser(String user_id, String user_pwd) {
        log.info("checkUser: " + user_id + " " + user_pwd);
//        User user = userMapper.getUserById(user_id);
        User user = userMapper.checkUser(user_id, user_pwd);
        return user;
	}

	@Override
	public boolean addUser(User user) {
        log.info("addUser: " + user.getUser_id());
        userMapper.saveUser(user);
        return true;
	}

	@Override
	public User getUserById(String user_id) {
		log.info("getUserById: " + user_id);
		User user = userMapper.getUserById(user_id);
		return user;
	}

}
