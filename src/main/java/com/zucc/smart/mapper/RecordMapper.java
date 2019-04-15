package com.zucc.smart.mapper;

import java.util.ArrayList;
import java.util.HashMap;

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
	
	
	/* 统计分析 */
	ArrayList<HashMap<String, Object>> getRecordTypeCount();

	ArrayList<HashMap<String, Object>> getRecordStreetCount();

	ArrayList<HashMap<String, Object>> getRecordAreaCount();

	String getDealtime(String id);

	void updateRecord(String id, String newDealtime);

	int getRecordTimeCount(String str);

	ArrayList<HashMap<String, Object>> getRecordAreaTimeCount(String str);

	int getRecordTimeCountForParking(String str, String parkcode);
	
	int getRecordTimeCountForStreet(String str, String streetcode);
	
	int getRecordTimeCountForArea(String str, String businesscode);

	ArrayList<Record> getRecordWithStreet(String streetcode);

	ArrayList<Record> getRecordWithArea(String businesscode);
	
}
