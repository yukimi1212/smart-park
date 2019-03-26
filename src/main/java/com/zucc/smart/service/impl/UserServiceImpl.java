package com.zucc.smart.service.impl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zucc.smart.domain.User;
import com.zucc.smart.mapper.UserMapper;
import com.zucc.smart.mapper.VehicleMapper;
import com.zucc.smart.service.UserService;
import com.zucc.smart.valueObject.UserVO;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;    
   
    @Autowired
    VehicleMapper vehicleMapper;
    
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

	@Override
	public ArrayList<UserVO> userSearch(String searchWord) {
		log.info("userSearch：By admin");
		ArrayList<UserVO> listVO = new ArrayList<UserVO>();
		ArrayList<User> list = userMapper.searchUser("%" + searchWord + "%");
		for(int i=0; i<list.size(); i++) {
			UserVO userVO = new UserVO();
			userVO.setUser_id(list.get(i).getUser_id());
			userVO.setUser_name(list.get(i).getUser_name());
			userVO.setUser_age(list.get(i).getUser_age());
			userVO.setUser_gender(list.get(i).getUser_gender());
			userVO.setUser_phone(list.get(i).getUser_phone());
			userVO.setRegistration_time(list.get(i).getRegistration_time());
			int num = vehicleMapper.getVehicleCount(list.get(i).getUser_id());
			userVO.setVehicle_num(num);
			listVO.add(userVO);
		}
		return listVO;
	}

}
