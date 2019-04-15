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

	void alterUser(String user_id, String user_gender, String user_phone);

	ArrayList<WordsVO> getAvaliableParkingNameTags();
	
	ArrayList<WordsVO> getAvaliableTypeNameTags();
	
	ArrayList<WordsVO> getAvaliableStreetNameTags();
	
	ArrayList<WordsVO> getAvaliableAreaNameTags();

	ArrayList<WordsVO> getAvaliableCarTypeTags();

	ArrayList<WordsVO> getAvailableTimeTags();

	ArrayList<WordsVO> getAvaliableParkingCodeTags();

	ArrayList<WordsVO> getAvaliableStreetCodeTags();

	ArrayList<WordsVO> getAvaliableAreaCodeTags();

	ArrayList<WordsVO> getAvailableParkingSearchTags(String source);

	ArrayList<WordsVO> getAvailableUserRecordSearchTags(String user_id, String source);

	ArrayList<WordsVO> getAvaliableUserRecordIDTags(String user_id);

	ArrayList<WordsVO> getAvaliableUserCphTags(String user_id);

	ArrayList<WordsVO> getAvailableChartTypeSearchTags();

	ArrayList<WordsVO> getAvailableChartStreetSearchTags();

	ArrayList<WordsVO> getAvailableChartAreaSearchTags();
	
}
