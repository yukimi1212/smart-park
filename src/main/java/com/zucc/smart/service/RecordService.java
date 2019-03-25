package com.zucc.smart.service;

import java.util.ArrayList;

import com.zucc.smart.domain.Record;
import com.zucc.smart.valueObject.RecordVO;

public interface RecordService {

	ArrayList<RecordVO> getUserRecord(String user_id);

	ArrayList<RecordVO> getAdminRecord();

	ArrayList<RecordVO> userRecordSearch(String searchWord, String user_id);
	
	ArrayList<RecordVO> changeToVO(ArrayList<Record> list);

	ArrayList<RecordVO> adminRecordIDSearch(String searchWord);	

	ArrayList<RecordVO> adminRecordCPHSearch(String searchWord);

	ArrayList<RecordVO> adminRecordParkingSearch(String searchWord);

	ArrayList<RecordVO> adminRecordStreetSearch(String searchWord);

	ArrayList<RecordVO> adminRecordAreaSearch(String searchWord);
	
	ArrayList<RecordVO> adminRecordSearch(String searchWord);

	ArrayList<Record> userRecordParkingSearch(String searchWord, String cph);

	ArrayList<Record> userRecordStreetSearch(String searchWord, String cph);

	ArrayList<Record> userRecordAreaSearch(String searchWord, String cph);

}
