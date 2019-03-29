package com.zucc.smart.service.impl;

import java.io.IOException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zucc.smart.domain.Record;
import com.zucc.smart.mapper.RecordMapper;
import com.zucc.smart.service.DataManageService;

@Service
public class DataManageImpl implements DataManageService{

	private static final Logger log = LoggerFactory.getLogger(DataManageImpl.class);

	@Autowired
	RecordMapper recordMapper;
	
	@Override
	public void updateRecord() throws IOException {
		log.info("updateRecord: ");
		ArrayList<String> listID = new ArrayList<String>();
		listID = TxtGetting.getID();
		for(int i=0; i<listID.size(); i++) {
			String oldDealtime = recordMapper.getDealtime(listID.get(i));
			String[] year = oldDealtime.split(" ");
			String[] time = year[1].split(":");
			int hour = Integer.parseInt(time[0]) + 1;
			String newDealtime = year[0] + " " + hour + ":" + time[1] + ":" + time[2];
			recordMapper.updateRecord(listID.get(i),newDealtime);
			System.out.println(i + "   id：" + listID.get(i) + "     oldDealtime：" + oldDealtime + "  newDealtime：" + newDealtime);
		}
		System.out.println("updateRecord完成");
	}
	
}
