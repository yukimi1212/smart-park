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
	public ArrayList<WordsVO> getAvaliableParkingNameTags() {
//		log.info("getAvaliableParkingNameTags：");
		ArrayList<WordsVO> listVO = new ArrayList<WordsVO>();
		
		ArrayList<String> list = new ArrayList<String>();
		list = helperMapper.getParkingNameTags();
		for(int i=0; i<list.size(); i++) {
			WordsVO wordsVO = new WordsVO();
			wordsVO.setSource("park");
			wordsVO.setValue(list.get(i));
			listVO.add(wordsVO);
		}
		
		return listVO;
	}
	
	@Override
	public ArrayList<WordsVO> getAvaliableParkingCodeTags() {
//		log.info("getAvaliableParkingCodeTags：");
		ArrayList<WordsVO> listVO = new ArrayList<WordsVO>();
		
		ArrayList<String> list = new ArrayList<String>();
		list = helperMapper.getParkingCodeTags();
		for(int i=0; i<list.size(); i++) {
			WordsVO wordsVO = new WordsVO();
			wordsVO.setSource("park");
			wordsVO.setValue(list.get(i));
			listVO.add(wordsVO);
		}
		
		return listVO;
	}
	
	@Override
	public ArrayList<WordsVO> getAvaliableTypeNameTags() {
		log.info("getAvaliableTypeNameTags：");
		ArrayList<WordsVO> listVO = new ArrayList<WordsVO>();
		
		ArrayList<String> list = new ArrayList<String>();
		list = helperMapper.getTypeNameTags();
		for(int i=0; i<list.size(); i++) {
			WordsVO wordsVO = new WordsVO();
			wordsVO.setSource("type");
			wordsVO.setValue(list.get(i));
			listVO.add(wordsVO);
		}
		
		return listVO;
	}
	
	@Override
	public ArrayList<WordsVO> getAvaliableStreetNameTags() {
//		log.info("getAvaliableStreetNameTags：");
		ArrayList<WordsVO> listVO = new ArrayList<WordsVO>();
		
		ArrayList<String> list = new ArrayList<String>();
		list = helperMapper.getStreetNameTags();
		for(int i=0; i<list.size(); i++) {
			WordsVO wordsVO = new WordsVO();
			wordsVO.setSource("street");
			wordsVO.setValue(list.get(i));
			listVO.add(wordsVO);
		}
		
		return listVO;
	}
	
	@Override
	public ArrayList<WordsVO> getAvaliableStreetCodeTags() {
//		log.info("getAvaliableStreetCodeTags：");
		ArrayList<WordsVO> listVO = new ArrayList<WordsVO>();
		
		ArrayList<String> list = new ArrayList<String>();
		list = helperMapper.getStreetCodeTags();
		for(int i=0; i<list.size(); i++) {
			WordsVO wordsVO = new WordsVO();
			wordsVO.setSource("streetcode");
			wordsVO.setValue(list.get(i));
			listVO.add(wordsVO);
		}
		
		return listVO;
	}
	
	@Override
	public ArrayList<WordsVO> getAvaliableAreaNameTags() {
//		log.info("getAvaliableAreaNameTags：");
		ArrayList<WordsVO> listVO = new ArrayList<WordsVO>();
		
		ArrayList<String> list = new ArrayList<String>();
		list = helperMapper.getAreaNameTags();
		for(int i=0; i<list.size(); i++) {
			WordsVO wordsVO = new WordsVO();
			wordsVO.setSource("area");
			wordsVO.setValue(list.get(i));
			listVO.add(wordsVO);
		}
		
		return listVO;
	}
	
	@Override
	public ArrayList<WordsVO> getAvaliableAreaCodeTags() {
//		log.info("getAvaliableAreaCodeTags：");
		ArrayList<WordsVO> listVO = new ArrayList<WordsVO>();
		
		ArrayList<String> list = new ArrayList<String>();
		list = helperMapper.getAreaCodeTags();
		for(int i=0; i<list.size(); i++) {
			WordsVO wordsVO = new WordsVO();
			wordsVO.setSource("areacode");
			wordsVO.setValue(list.get(i));
			listVO.add(wordsVO);
		}
		
		return listVO;
	}
	
	@Override
	public ArrayList<WordsVO> getAvaliableCarTypeTags() {
		log.info("getAvaliableCarTypeTags：");
		ArrayList<WordsVO> listVO = new ArrayList<WordsVO>();
		
		ArrayList<String> list = new ArrayList<String>();
		list = helperMapper.getCarTypeTags();
		for(int i=0; i<list.size(); i++) {
			WordsVO wordsVO = new WordsVO();
			wordsVO.setSource("cartype");
			wordsVO.setValue(list.get(i));
			listVO.add(wordsVO);
		}
		return listVO;
	}
	
	@Override
	public ArrayList<WordsVO> getAvaliableUserCphTags(String user_id) {
//		log.info("getAvaliableCphTags：");
		ArrayList<WordsVO> listVO = new ArrayList<WordsVO>();
		
		ArrayList<String> list = new ArrayList<String>();
		list = helperMapper.getUserCphTags(user_id);
		for(int i=0; i<list.size(); i++) {
			WordsVO wordsVO = new WordsVO();
			wordsVO.setSource("cartype");
			wordsVO.setValue(list.get(i));
			listVO.add(wordsVO);
		}
		return listVO;
	}
	
	@Override
	public ArrayList<WordsVO> getAvaliableUserRecordIDTags(String user_id) {
//		log.info("getAvaliableRecordIDTags：");
		ArrayList<WordsVO> listVO = new ArrayList<WordsVO>();
		
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Vehicle> listVehicle = vehicleMapper.getUserVehicle(user_id);
		for(int c=0; c<listVehicle.size(); c++) {
			list = helperMapper.getUserRecordIDTags(listVehicle.get(c).getCph());
			for(int i=0; i<list.size(); i++) {
				WordsVO wordsVO = new WordsVO();
				wordsVO.setSource("cartype");
				wordsVO.setValue(list.get(i));
				listVO.add(wordsVO);
			}
		}
		return listVO;
	}

	
	@Override
	public ArrayList<WordsVO> getAvailableTimeTags() {
		log.info("getAvailableTags：");
		
		ArrayList<WordsVO> listVO = new ArrayList<WordsVO>();
				
		listVO.addAll(getAvaliableParkingNameTags());
		listVO.addAll(getAvaliableTypeNameTags());
		listVO.addAll(getAvaliableStreetNameTags());
		listVO.addAll(getAvaliableAreaNameTags());	
	
		return listVO;
	}
	
	@Override
	public ArrayList<WordsVO> getAvailableParkingSearchTags(String source) {
		log.info("getAvailableParkingSearchTags：" + source);
		
		ArrayList<WordsVO> listVO = new ArrayList<WordsVO>();
		if(source.equals("form")) {
			listVO.addAll(getAvaliableParkingNameTags());
			listVO.addAll(getAvaliableParkingCodeTags());
			listVO.addAll(getAvaliableStreetNameTags());
			listVO.addAll(getAvaliableStreetCodeTags());
			listVO.addAll(getAvaliableAreaNameTags());
			listVO.addAll(getAvaliableAreaCodeTags());
		}
		else if(source.equals("formpark")) {
			listVO.addAll(getAvaliableParkingNameTags());
			listVO.addAll(getAvaliableParkingCodeTags());
		}
		else if(source.equals("formstreet")) {
			listVO.addAll(getAvaliableStreetNameTags());
			listVO.addAll(getAvaliableStreetCodeTags());
		}
		else {
			listVO.addAll(getAvaliableAreaNameTags());
			listVO.addAll(getAvaliableAreaCodeTags());
		}
		return listVO;
	}
	
	@Override
	public ArrayList<WordsVO> getAvailableUserRecordSearchTags(String user_id, String source) {
		log.info("getAvailableUserRecordSearchTags：" + user_id + "   " + source);
		
		ArrayList<WordsVO> listVO = new ArrayList<WordsVO>();
		if(source.equals("record")) {	
			listVO.addAll(getAvaliableUserRecordIDTags(user_id));
//			listVO.addAll(getAvaliableUserCphTags(user_id));
			listVO.addAll(getAvaliableParkingNameTags());
			listVO.addAll(getAvaliableStreetNameTags());
			listVO.addAll(getAvaliableAreaNameTags());
		}
		else if(source.equals("recordcph")) {	
//			listVO.addAll(getAvaliableUserCphTags(user_id));
		}
		else if(source.equals("recordpark")) {	
			listVO.addAll(getAvaliableParkingNameTags());
		}
		else if(source.equals("recordstreet")){	
			listVO.addAll(getAvaliableStreetNameTags());
		}
		else
			listVO.addAll(getAvaliableAreaNameTags());
		
//		System.out.println(listVO.size());
		return listVO;
	}

	@Override
	public void alterUser(String user_id, String user_gender, String user_phone) {
		log.info("alterUser：");
		userMapper.alterUser(user_id, user_gender, user_phone);
	}

	@Override
	public ArrayList<WordsVO> getAvailableChartTypeSearchTags() {
		log.info("getAvailableChartTypeSearchTags：");
		
		ArrayList<WordsVO> listVO = new ArrayList<WordsVO>();
		
		listVO.addAll(getAvaliableStreetNameTags());
		listVO.addAll(getAvaliableAreaNameTags());
		return listVO;
	}

	@Override
	public ArrayList<WordsVO> getAvailableChartStreetSearchTags() {
		log.info("getAvailableChartStreetSearchTags：");
		
		ArrayList<WordsVO> listVO = new ArrayList<WordsVO>();
		listVO.addAll(getAvaliableAreaNameTags());
		return listVO;
	}

	@Override
	public ArrayList<WordsVO> getAvailableChartAreaSearchTags() {
		log.info("getAvailableChartAreaSearchTags：");
		
		ArrayList<WordsVO> listVO = new ArrayList<WordsVO>();
		listVO.addAll(getAvaliableTypeNameTags());
		return listVO;
	}

}
