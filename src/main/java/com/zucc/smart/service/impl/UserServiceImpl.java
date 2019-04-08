package com.zucc.smart.service.impl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zucc.smart.domain.User;
import com.zucc.smart.domain.Vehicle;
import com.zucc.smart.mapper.HelperMapper;
import com.zucc.smart.mapper.ParkingMapper;
import com.zucc.smart.mapper.RecordMapper;
import com.zucc.smart.mapper.UserMapper;
import com.zucc.smart.mapper.VehicleMapper;
import com.zucc.smart.service.UserService;
import com.zucc.smart.vObject.TimeVO;
import com.zucc.smart.vObject.UserVO;
import com.zucc.smart.vObject.WordsVO;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;    
   
    @Autowired
    VehicleMapper vehicleMapper;
    
    @Autowired
    HelperMapper helperMapper;
    
    @Autowired
    ParkingMapper parkingMapper;
    
    @Autowired
    RecordMapper recordMapper;
    
    @Transactional
	@Override
	public User checkUser(String user_id, String user_pwd) {
        log.info("checkUser: " + user_id + " " + user_pwd);
        User user = userMapper.checkUser(user_id, user_pwd);
        return user;
	}

	@Override
	public boolean addUser(User user) {
        log.info("addUser: " + user.getUser_id());
        userMapper.addUser(user);
        return true;
	}

	@Override
	public User getUserById(String user_id) {
		log.info("getUserById: " + user_id);
		User user = (userMapper.getUserById(user_id)).get(0);
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

	@Override
	public ArrayList<WordsVO> getAvailableTags() {
		log.info("getAvailableTags：");
		ArrayList<WordsVO> listVO = new ArrayList<WordsVO>();
		
		ArrayList<String> list = new ArrayList<String>();
		list = helperMapper.getParkingnameTags();
		for(int i=0; i<list.size(); i++) {
			WordsVO wordsVO = new WordsVO();
			wordsVO.setSource("park");
			wordsVO.setValue(list.get(i));
			listVO.add(wordsVO);
		}
		
		list = helperMapper.getTypenameTags();
		for(int i=0; i<list.size(); i++) {
			WordsVO wordsVO = new WordsVO();
			wordsVO.setSource("type");
			wordsVO.setValue(list.get(i));
			listVO.add(wordsVO);
		}
		
		list = helperMapper.getStreetnameTags();
		for(int i=0; i<list.size(); i++) {
			WordsVO wordsVO = new WordsVO();
			wordsVO.setSource("street");
			wordsVO.setValue(list.get(i));
			listVO.add(wordsVO);
		}
		
		list = helperMapper.getAreanameTags();
		for(int i=0; i<list.size(); i++) {
			WordsVO wordsVO = new WordsVO();
			wordsVO.setSource("area");
			wordsVO.setValue(list.get(i));
			listVO.add(wordsVO);
		}
	
		return listVO;
	}

	@Override
	public void alterUser(String user_id, String user_gender, String user_age, String user_phone) {
		log.info("alterUser：");
		userMapper.alterUser(user_id, user_gender, user_age, user_phone);
	}

}
