package com.zucc.smart.mapper;

import java.util.ArrayList;

import com.zucc.smart.domain.Record;

public interface RecordMapper {

	/* 管理员 */
	ArrayList<Record> getAllRecord();

	ArrayList<Record> searchRecordByID(String searchWord);

	ArrayList<Record> searchRecordByCPH(String searchWord);

	ArrayList<Record> searchRecordByParking(String searchWord);
	
	ArrayList<Record> searchRecordByStreet(String searchWord);

	ArrayList<Record> searchRecordByArea(String searchWord);

	
	/* 用户 */
	ArrayList<Record> getUserRecord(String cph);
	
	ArrayList<Record> searchUserRecordByID(String searchWord, String cph);

	ArrayList<Record> searchUserRecordByCPH(String searchWord, String cph);

	ArrayList<Record> searchUserRecordByParking(String searchWord, String cph);
	
	ArrayList<Record> searchUserRecordByStreet(String searchWord, String cph);

	ArrayList<Record> searchUserRecordByArea(String searchWord, String cph);

	
}
