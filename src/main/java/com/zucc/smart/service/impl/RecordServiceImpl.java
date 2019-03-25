package com.zucc.smart.service.impl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zucc.smart.domain.Parking;
import com.zucc.smart.domain.Record;
import com.zucc.smart.mapper.HelperMapper;
import com.zucc.smart.mapper.ParkingMapper;
import com.zucc.smart.mapper.RecordMapper;
import com.zucc.smart.service.RecordService;
import com.zucc.smart.valueObject.RecordVO;

@Service
public class RecordServiceImpl implements RecordService {

	private static final Logger log = LoggerFactory.getLogger(RecordServiceImpl.class);

	@Autowired
	RecordMapper recordMapper;
	
	@Autowired
	HelperMapper helperMapper;
	
	@Autowired
	ParkingMapper parkingMapper;
	
	@Override
	public ArrayList<RecordVO> getUserRecord() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RecordVO> getAdminRecord() {
		log.info("getAdminRecord: ");
		ArrayList<Record> list = recordMapper.getAllRecord();
		ArrayList<RecordVO> listVO = changeToVO(list);
		return listVO;
	}

	@Override
	public ArrayList<RecordVO> userRecordSearch(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RecordVO> adminRecordIDSearch(String searchWord) {
		log.info("adminRecordIDSearch: " + searchWord);
		ArrayList<Record> list = recordMapper.searchRecordByID("%"+searchWord+"%");
		ArrayList<RecordVO> listVO = changeToVO(list);
		return listVO;		
	}
	
	@Override
	public ArrayList<RecordVO> adminRecordCPHSearch(String searchWord) {
		log.info("adminRecordCPHSearch: " + searchWord);
		ArrayList<Record> list = recordMapper.searchRecordByCPH("%"+searchWord+"%");
		ArrayList<RecordVO> listVO = changeToVO(list);
		return listVO;		
	}


	@Override
	public ArrayList<RecordVO> adminRecordParkingSearch(String searchWord) {
		log.info("adminRecordParkingSearch: " + searchWord);
		ArrayList<Parking> listParking = parkingMapper.searchParkNameByParkCode("%"+searchWord+"%");
		ArrayList<RecordVO> listVO = new ArrayList<RecordVO>();
		for(int i=0; i<listParking.size(); i++) {
			ArrayList<Record> list = recordMapper.searchRecordByParking(listParking.get(i).getParkcode());
			ArrayList<RecordVO> listVOTemp = new ArrayList<RecordVO>();
			listVOTemp = changeToVO(list);
			listVO.addAll(listVOTemp);
		}		
		return listVO;
	}

	@Override
	public ArrayList<RecordVO> adminRecordStreetSearch(String searchWord) {
		log.info("adminRecordStreetSearch: " + searchWord);
		ArrayList<Parking> listParking = parkingMapper.searchStreetNameByStreetCode("%"+searchWord+"%");
		ArrayList<RecordVO> listVO = new ArrayList<RecordVO>();
		for(int i=0; i<listParking.size(); i++) {
			ArrayList<Record> list = recordMapper.searchRecordByStreet(listParking.get(i).getStreetcode());
			ArrayList<RecordVO> listVOTemp = new ArrayList<RecordVO>();
			listVOTemp = changeToVO(list);
			listVO.addAll(listVOTemp);
		}		
		return listVO;
	}

	@Override
	public ArrayList<RecordVO> adminRecordAreaSearch(String searchWord) {
		log.info("adminRecordAreaSearch: " + searchWord);
		ArrayList<Parking> listParking = parkingMapper.searchAreaNameByBusinesscode("%"+searchWord+"%");
		ArrayList<RecordVO> listVO = new ArrayList<RecordVO>();
		for(int i=0; i<listParking.size(); i++) {
			ArrayList<Record> list = recordMapper.searchRecordByArea(listParking.get(i).getBusinesscode());
			ArrayList<RecordVO> listVOTemp = new ArrayList<RecordVO>();
			listVOTemp = changeToVO(list);
			listVO.addAll(listVOTemp);
		}		
		return listVO;
	}
	
	@Override
	public ArrayList<RecordVO> changeToVO(ArrayList<Record> list) {
		ArrayList<RecordVO> listVO = new ArrayList<RecordVO>();
		for(int i=0; i<list.size(); i++) {
			RecordVO recordVO = new RecordVO();
			recordVO.setBerthcode(list.get(i).getBerthcode());
			recordVO.setCph(list.get(i).getCph());
			recordVO.setId(list.get(i).getId());
			recordVO.setInserttime(list.get(i).getInserttime());
			recordVO.setDealtime(list.get(i).getDealtime());
			String areaname = helperMapper.getAreaName(list.get(i).getBusinesscode());
			recordVO.setAreaname(areaname);
			String streetname = helperMapper.getStreetName(list.get(i).getStreetcode());
			recordVO.setStreetname(streetname);
			String parkname = helperMapper.getParkingName(list.get(i).getParkcode());
			recordVO.setParkname(parkname);
			listVO.add(recordVO);
		}
		
		return listVO;
	}

	@Override
	public ArrayList<RecordVO> adminRecordSearch(String searchWord) {	
		ArrayList<RecordVO> listVO = new ArrayList<RecordVO>();
		ArrayList<RecordVO> listID = adminRecordIDSearch(searchWord);	
		listVO.addAll(listID);
		ArrayList<RecordVO> listCPH = adminRecordCPHSearch(searchWord);
		listVO.addAll(listCPH);
		ArrayList<RecordVO> listParking = adminRecordParkingSearch(searchWord);
		listVO.addAll(listParking);
		ArrayList<RecordVO> listStreet = adminRecordStreetSearch(searchWord);
		listVO.addAll(listStreet);
		ArrayList<RecordVO> listArea = adminRecordAreaSearch(searchWord);
		listVO.addAll(listArea);
		
		return listVO;
	}

}
