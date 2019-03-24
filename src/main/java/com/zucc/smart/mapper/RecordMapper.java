package com.zucc.smart.mapper;

import java.util.ArrayList;

import com.zucc.smart.domain.Record;

public interface RecordMapper {

	ArrayList<Record> getAllRecord();

	ArrayList<Record> searchRecordByID(String searchWord);

	ArrayList<Record> searchRecordByCPH(String string);

	ArrayList<Record> searchRecordByParking(String parkcode);
	
	ArrayList<Record> searchRecordByStreet(String parkcode);

	ArrayList<Record> searchRecordByArea(String parkcode);

	
}
