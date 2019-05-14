package com.zucc.smart.service;

import java.util.ArrayList;

import com.zucc.smart.domain.Record;
import com.zucc.smart.domain.User;
import com.zucc.smart.vObject.AreaVO;
import com.zucc.smart.vObject.ParkingTypeVO;
import com.zucc.smart.vObject.RecordVO;
import com.zucc.smart.vObject.StreetVO;
import com.zucc.smart.vObject.TimeVO;
import com.zucc.smart.vObject.UserVO;

public interface RecordService {

	ArrayList<RecordVO> getUserRecord(String user_id);

	ArrayList<RecordVO> getAdminRecord(int limit, int offset);
	
	ArrayList<RecordVO> userRecordSearch(String searchWord, String user_id, String source);

	ArrayList<RecordVO> adminRecordIDSearch(String searchWord);	

	ArrayList<RecordVO> adminRecordCPHSearch(String searchWord);

	ArrayList<RecordVO> adminRecordParkingSearch(String searchWord);

	ArrayList<RecordVO> adminRecordStreetSearch(String searchWord);

	ArrayList<RecordVO> adminRecordAreaSearch(String searchWord);
	
	ArrayList<RecordVO> adminRecordSearch(String searchWord, String source);

	ArrayList<Record> userRecordParkingSearch(String searchWord, String cph);

	ArrayList<Record> userRecordStreetSearch(String searchWord, String cph);

	ArrayList<Record> userRecordAreaSearch(String searchWord, String cph);

	ArrayList<UserVO> getAdminUserList();

	ArrayList<RecordVO> changeToRecordVO(ArrayList<Record> list);
	
	UserVO changeToUserVO(User user);

	ArrayList<UserVO> getUserInfoList(String user_id);

	ArrayList<ParkingTypeVO> getRecordType();

	ArrayList<AreaVO> getRecordArea();

	ArrayList<StreetVO> getRecordStreet();

	ArrayList<TimeVO> getRecordTime();

	ArrayList<TimeVO> getTimeSearch(String sWordParking, String sWordStreet, String sWordArea, String starttime, String endtime);

	ArrayList<ParkingTypeVO> getRecordChartTypeSearch(String searchWord, String source);

	ArrayList<StreetVO> getRecordChartStreetSearch(String searchWord);

	ArrayList<AreaVO> getRecordChartAreaSearch(String searchWord);

	int getAdminRecordCount();

}
