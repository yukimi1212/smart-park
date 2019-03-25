package com.zucc.smart.service;

import java.util.ArrayList;

import com.zucc.smart.domain.Record;
import com.zucc.smart.valueObject.RecordVO;

public interface RecordService {

	ArrayList<RecordVO> getUserRecord();

	ArrayList<RecordVO> getAdminRecord();

	ArrayList<RecordVO> userRecordSearch(String searchWord);
	
	ArrayList<RecordVO> changeToVO(ArrayList<Record> list);

	ArrayList<RecordVO> adminRecordIDSearch(String searchWord);	

	ArrayList<RecordVO> adminRecordCPHSearch(String searchWord);

	ArrayList<RecordVO> adminRecordParkingSearch(String searchWord);

	ArrayList<RecordVO> adminRecordStreetSearch(String searchWord);

	ArrayList<RecordVO> adminRecordAreaSearch(String searchWord);
	
	ArrayList<RecordVO> adminRecordSearch(String searchWord);

}
