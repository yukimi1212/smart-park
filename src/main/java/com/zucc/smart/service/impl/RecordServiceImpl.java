package com.zucc.smart.service.impl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zucc.smart.domain.Parking;
import com.zucc.smart.domain.Record;
import com.zucc.smart.domain.User;
import com.zucc.smart.domain.Vehicle;
import com.zucc.smart.mapper.HelperMapper;
import com.zucc.smart.mapper.ParkingMapper;
import com.zucc.smart.mapper.RecordMapper;
import com.zucc.smart.mapper.UserMapper;
import com.zucc.smart.mapper.VehicleMapper;
import com.zucc.smart.service.RecordService;
import com.zucc.smart.valueObject.RecordVO;
import com.zucc.smart.valueObject.UserVO;

@Service
public class RecordServiceImpl implements RecordService {

	private static final Logger log = LoggerFactory.getLogger(RecordServiceImpl.class);

	@Autowired
	RecordMapper recordMapper;
	
	@Autowired
	HelperMapper helperMapper;
	
	@Autowired
	ParkingMapper parkingMapper;
	
	@Autowired
	VehicleMapper vehicleMapper;
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public ArrayList<RecordVO> getUserRecord(String user_id) {
		log.info("getUserRecord: " + user_id);
		ArrayList<Vehicle> listAllCPH = vehicleMapper.getUserVehicle(user_id);
		ArrayList<Record> listAll = new ArrayList<Record>();
		for(int i=0; i<listAllCPH.size(); i++) {
			ArrayList<Record> list = new ArrayList<Record>();
			String cph = listAllCPH.get(i).getCph();
			list = recordMapper.getUserRecord(cph);
			listAll.addAll(list);
		}
		ArrayList<RecordVO> listVO = changeToRecordVO(listAll);
		return listVO;
	}

	@Override
	public ArrayList<RecordVO> getAdminRecord() {
		log.info("getAdminRecord: admin");
		ArrayList<Record> list = recordMapper.getAllRecord();
		ArrayList<RecordVO> listVO = changeToRecordVO(list);
		return listVO;
	}

	@Override
	public ArrayList<RecordVO> userRecordSearch(String searchWord, String user_id) {
		log.info("userRecordSearch: " + user_id + "  searchWord：" + searchWord);
		ArrayList<Vehicle> listAllCPH = vehicleMapper.getUserVehicle(user_id);
		ArrayList<RecordVO> listVO = new ArrayList<RecordVO>();
		ArrayList<Record> listAll = new ArrayList<Record>();
		for(int i=0; i<listAllCPH.size(); i++) {
			String cph = listAllCPH.get(i).getCph();			
			ArrayList<Record> listID = recordMapper.searchUserRecordByID("%"+searchWord+"%", cph);
			ArrayList<Record> listCPH = recordMapper.searchUserRecordByCPH("%"+searchWord+"%", cph);
			ArrayList<Record> listParking = userRecordParkingSearch(searchWord,cph);
			ArrayList<Record> listStreet = userRecordStreetSearch(searchWord,cph);
			ArrayList<Record> listArea = userRecordAreaSearch(searchWord,cph);
			listAll.addAll(listID);
			listAll.addAll(listCPH);
			listAll.addAll(listParking);
			listAll.addAll(listStreet);
			listAll.addAll(listArea);			
		}
		listVO = changeToRecordVO(listAll);
		return listVO;
	}

	@Override
	public ArrayList<RecordVO> adminRecordIDSearch(String searchWord) {
		log.info("adminRecordIDSearch: " + searchWord);
		ArrayList<Record> list = recordMapper.searchRecordByID("%"+searchWord+"%");
		ArrayList<RecordVO> listVO = changeToRecordVO(list);
		return listVO;		
	}
	
	@Override
	public ArrayList<RecordVO> adminRecordCPHSearch(String searchWord) {
		log.info("adminRecordCPHSearch: " + searchWord);
		ArrayList<Record> list = recordMapper.searchRecordByCPH("%"+searchWord+"%");
		ArrayList<RecordVO> listVO = changeToRecordVO(list);
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
			listVOTemp = changeToRecordVO(list);
			listVO.addAll(listVOTemp);
		}		
		return listVO;
	}
	
	@Override
	public ArrayList<Record> userRecordParkingSearch(String searchWord, String cph) {
		log.info("userRecordParkingSearch: " + searchWord + "  cph：" + cph);
		ArrayList<Parking> listParking = parkingMapper.searchParkNameByParkCode("%"+searchWord+"%");
		ArrayList<Record> listAll = new ArrayList<Record>();
		for(int i=0; i<listParking.size(); i++) {
			ArrayList<Record> list = recordMapper.searchUserRecordByParking(listParking.get(i).getParkcode(), cph);
			listAll.addAll(list);
		}		
		return listAll;
	}
	
	@Override
	public ArrayList<Record> userRecordStreetSearch(String searchWord, String cph) {
		log.info("userRecordStreetSearch: " + searchWord + "  cph：" + cph);
		ArrayList<Parking> listRecord = parkingMapper.searchStreetNameByStreetCode("%"+searchWord+"%");
		ArrayList<Record> listAll = new ArrayList<Record>();
		for(int i=0; i<listRecord.size(); i++) {
			ArrayList<Record> list = recordMapper.searchUserRecordByStreet(listRecord.get(i).getStreetcode(),cph);
			listAll.addAll(list);
		}		
		return listAll;
	}
	
	@Override
	public ArrayList<Record> userRecordAreaSearch(String searchWord, String cph) {
		log.info("userRecordAreaSearch: " + searchWord + "  cph：" + cph);
		ArrayList<Parking> listArea = parkingMapper.searchAreaNameByBusinesscode("%"+searchWord+"%");
		ArrayList<Record> listAll = new ArrayList<Record>();
		for(int i=0; i<listArea.size(); i++) {
			ArrayList<Record> list = recordMapper.searchUserRecordByArea(listArea.get(i).getBusinesscode(),cph);
			listAll.addAll(list);
		}		
		return listAll;
	}

	@Override
	public ArrayList<RecordVO> adminRecordStreetSearch(String searchWord) {
		log.info("adminRecordStreetSearch: " + searchWord);
		ArrayList<Parking> listStreet = parkingMapper.searchStreetNameByStreetCode("%"+searchWord+"%");
		ArrayList<RecordVO> listVO = new ArrayList<RecordVO>();
		for(int i=0; i<listStreet.size(); i++) {
			ArrayList<Record> list = recordMapper.searchRecordByStreet(listStreet.get(i).getStreetcode());
			ArrayList<RecordVO> listVOTemp = new ArrayList<RecordVO>();
			listVOTemp = changeToRecordVO(list);
			listVO.addAll(listVOTemp);
		}		
		return listVO;
	}

	@Override
	public ArrayList<RecordVO> adminRecordAreaSearch(String searchWord) {
		log.info("adminRecordAreaSearch: " + searchWord);
		ArrayList<Parking> listArea = parkingMapper.searchAreaNameByBusinesscode("%"+searchWord+"%");
		ArrayList<RecordVO> listVO = new ArrayList<RecordVO>();
		for(int i=0; i<listArea.size(); i++) {
			ArrayList<Record> list = recordMapper.searchRecordByArea(listArea.get(i).getBusinesscode());
			ArrayList<RecordVO> listVOTemp = new ArrayList<RecordVO>();
			listVOTemp = changeToRecordVO(list);
			listVO.addAll(listVOTemp);
		}		
		return listVO;
	}

	@Override
	public ArrayList<RecordVO> adminRecordSearch(String searchWord) {	
		log.info("adminRecordSearch: " + searchWord);
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

	
	@Override
	public ArrayList<UserVO> getAdminUserList() {
		log.info("getAdminUserList：");
		ArrayList<User> list = userMapper.getAllUser();
		ArrayList<UserVO> listVO = new ArrayList<UserVO>();
		for(int i=0; i<list.size(); i++) {
			UserVO userVO = new UserVO();
			userVO = changeToUserVO(list.get(i));
			listVO.add(userVO);
		}
		
		return listVO;
	}
	
	@Override
	public UserVO changeToUserVO(User user) {
		UserVO userVO = new UserVO();
		userVO.setUser_id(user.getUser_id());
		userVO.setUser_name(user.getUser_name());
		userVO.setUser_age(user.getUser_age());
		userVO.setUser_gender(user.getUser_gender());
		userVO.setUser_phone(user.getUser_phone());
		userVO.setRegistration_time(user.getRegistration_time());
		int num = vehicleMapper.getVehicleCount(user.getUser_id());
		userVO.setVehicle_num(num);
		return userVO;
	}
	
	@Override
	public ArrayList<RecordVO> changeToRecordVO(ArrayList<Record> list) {
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
	public ArrayList<UserVO> getUserInfoList(String user_id) {
		log.info("getUserInfoList: " + user_id);
		ArrayList<User> list = userMapper.getUserById(user_id);
		ArrayList<UserVO> listVO = new ArrayList<UserVO>();
		for(int i=0; i<list.size(); i++) {
			UserVO userVO = new UserVO();
			userVO = changeToUserVO(list.get(i));
			listVO.add(userVO);
		}
		return listVO;
	}

}
