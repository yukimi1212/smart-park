package com.zucc.smart.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
import com.zucc.smart.mapper.ParkingTypeMapper;
import com.zucc.smart.mapper.RecordMapper;
import com.zucc.smart.mapper.UserMapper;
import com.zucc.smart.mapper.VehicleMapper;
import com.zucc.smart.service.RecordService;
import com.zucc.smart.vObject.AreaVO;
import com.zucc.smart.vObject.ParkingTypeVO;
import com.zucc.smart.vObject.RecordVO;
import com.zucc.smart.vObject.StreetVO;
import com.zucc.smart.vObject.TimeVO;
import com.zucc.smart.vObject.UserVO;

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
	
	@Autowired
    ParkingTypeMapper parkingTypeMapper;
	
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
	public ArrayList<RecordVO> userRecordSearch(String searchWord, String user_id, String source) {
		log.info("userRecordSearch: " + user_id + "  searchWord：" + searchWord + " source：" + source);
		ArrayList<Vehicle> listAllCPH = vehicleMapper.getUserVehicle(user_id);
		ArrayList<RecordVO> listVO = new ArrayList<RecordVO>();
		ArrayList<Record> listAll = new ArrayList<Record>();
		String sWord = "%"+searchWord+"%";
		for(int i=0; i<listAllCPH.size(); i++) {
			String cph = listAllCPH.get(i).getCph();			
			if(source.equals("record")) {
				listAll.addAll(recordMapper.searchUserRecordByID(sWord, cph));
//				listAll.addAll(recordMapper.searchUserRecordByCPH(searchWord, cph));
				listAll.addAll(userRecordParkingSearch(sWord,cph));
				listAll.addAll(userRecordStreetSearch(sWord,cph));
				listAll.addAll(userRecordAreaSearch(sWord,cph));
				
				HashMap<String,Record> listmap = new HashMap<String,Record>();
				for (int n=0; n<listAll.size(); n++) {
					if (listmap.get(listAll.get(n).getId()) == null)
						listmap.put(listAll.get(n).getId(), listAll.get(n));
				}
				
				listAll = new ArrayList<Record>();
				for(Map.Entry<String, Record> entry : listmap.entrySet()){
		            listAll.add(entry.getValue());
		        }

			}
			else if(source.equals("recordcph")) {
				listAll.addAll(recordMapper.searchUserRecordByCPH(searchWord, cph));
			}
			else if(source.equals("recordpark")) {
				listAll.addAll(userRecordParkingSearch(sWord,cph));
			}
			else if(source.equals("recordstreet")) {
				listAll.addAll(userRecordStreetSearch(sWord,cph));
			}
			else 
				listAll.addAll(userRecordAreaSearch(sWord,cph));
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
		ArrayList<Parking> listParking = parkingMapper.searchParkcodeByParkname("%"+searchWord+"%");
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
		ArrayList<Parking> listParking = parkingMapper.searchParkcodeByParkname(searchWord);
		ArrayList<Record> listAll = new ArrayList<Record>();
		for(int i=0; i<listParking.size(); i++) {
			ArrayList<Record> list = recordMapper.searchUserRecordByParking(listParking.get(i).getParkcode(), cph);
			listAll.addAll(list);
		}		
		return listAll;
	}
	
	@Override
	public ArrayList<Record> userRecordStreetSearch(String searchWord, String cph) {
		ArrayList<Parking> listRecord = parkingMapper.searchStreetcodeByStreetname(searchWord);
		ArrayList<Record> listAll = new ArrayList<Record>();
		for(int i=0; i<listRecord.size(); i++) {
			ArrayList<Record> list = recordMapper.searchUserRecordByStreet(listRecord.get(i).getStreetcode(),cph);
			listAll.addAll(list);
		}		
		return listAll;
	}
	
	@Override
	public ArrayList<Record> userRecordAreaSearch(String searchWord, String cph) {
//		log.info("userRecordAreaSearch: " + searchWord + "  cph：" + cph);
		ArrayList<Parking> listArea = parkingMapper.searchBusinesscodeByAreaname(searchWord);
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
		ArrayList<Parking> listStreet = parkingMapper.searchStreetcodeByStreetname("%"+searchWord+"%");
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
		ArrayList<Parking> listArea = parkingMapper.searchBusinesscodeByAreaname("%"+searchWord+"%");
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
	public ArrayList<RecordVO> adminRecordSearch(String searchWord, String source) {	
		log.info("adminRecordSearch: " + searchWord);
		ArrayList<RecordVO> listVO = new ArrayList<RecordVO>();
		
		if(source.equals("record")) {
			listVO.addAll(adminRecordIDSearch(searchWord));
			listVO.addAll(adminRecordCPHSearch(searchWord));
			listVO.addAll(adminRecordParkingSearch(searchWord));
			listVO.addAll(adminRecordStreetSearch(searchWord));
			listVO.addAll(adminRecordAreaSearch(searchWord));
		}
		else if(source.equals("recordcph")) {
			listVO.addAll(adminRecordCPHSearch(searchWord));
		}
		else if(source.equals("recordpark")) {
			listVO.addAll(adminRecordParkingSearch(searchWord));
		}
		else if(source.equals("recordstreet")) {
			listVO.addAll(adminRecordStreetSearch(searchWord));
		}
		else if(source.equals("recordarea")) {
			listVO.addAll(adminRecordAreaSearch(searchWord));
		}
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

	@Override
	public ArrayList<ParkingTypeVO> getRecordType() {
		log.info("getRecordType: ");
		ArrayList<ParkingTypeVO> listVO = new ArrayList<ParkingTypeVO>();
		ArrayList<Record> listRecord = recordMapper.getAllRecord();
		int[] typeAmount = {0,0,0,0,0};
		int typecode = 0;
		for(int i=0; i<listRecord.size(); i++) {
			String parkcode = listRecord.get(i).getParkcode();
			ArrayList<Parking> parkingList = parkingMapper.getTypeCode(parkcode);
			if (parkingList.size() != 0)
				typecode = Integer.parseInt(parkingList.get(0).getTypecode());
			typeAmount[typecode]++;
		}
		
		for(int j=0; j<typeAmount.length; j++) {
			ParkingTypeVO typeVO = new ParkingTypeVO();
			typeVO.setTypecode(j+"");
			typeVO.setTypename(parkingTypeMapper.getTypeName(j+""));
			typeVO.setAmount(typeAmount[j]);
			listVO.add(typeVO);
		}
		
		listVO.get(0).setAmount(listRecord.size());
		return listVO;
	}
	
	@Override
	public ArrayList<AreaVO> getRecordArea() {
		log.info("getRecordArea: ");
		ArrayList<HashMap<String,Object>> listmap = recordMapper.getRecordAreaCount();
		ArrayList<AreaVO> listVO = new ArrayList<AreaVO>();
		
		AreaVO areaVO = new AreaVO();
		areaVO.setBusinesscode(0 + "");
		areaVO.setAreaname("");
		areaVO.setAmount(0);
        listVO.add(areaVO);
        
		for(int i=0; i<listmap.size(); i++) {
			HashMap<String, Object> map = listmap.get(i);
			
			String businesscode = map.get("businesscode").toString();
			String amount = map.get("count(businesscode)").toString();
			String areaname = helperMapper.getAreaName(businesscode);
			
			areaVO = new AreaVO();
			areaVO.setBusinesscode(businesscode);
			areaVO.setAreaname(areaname);
			areaVO.setAmount(Integer.parseInt(amount));
            listVO.add(areaVO);
            listVO.get(0).setAmount(listVO.get(0).getAmount() + Integer.parseInt(amount));
//            System.out.println(areaVO.getBusinesscode() + "   " + areaVO.getAreaname() + "   " + areaVO.getAmount());
		}
		return listVO;
	}

	@Override
	public ArrayList<StreetVO> getRecordStreet() {
		log.info("getRecordStreet: ");
		ArrayList<HashMap<String,Object>> listmap = recordMapper.getRecordStreetCount();
		ArrayList<StreetVO> listVO = new ArrayList<StreetVO>();
		
		StreetVO streetVO = new StreetVO();
		streetVO.setStreetcode(0 + "");
		streetVO.setStreetname("");
		streetVO.setAmount(0);
        listVO.add(streetVO);
        
		for(int i=0; i<listmap.size(); i++) {
			HashMap<String, Object> map = listmap.get(i);
			
			String streetcode = map.get("streetcode").toString();
			String amount = map.get("count(streetcode)").toString();
			String streetname = helperMapper.getStreetName(streetcode);
			
			streetVO = new StreetVO();
			streetVO.setStreetcode(streetcode);
			streetVO.setStreetname(streetname);
			streetVO.setAreaname(helperMapper.getAreaNameByStreetCode(streetcode));
			streetVO.setAmount(Integer.parseInt(amount));
            listVO.add(streetVO);
            listVO.get(0).setAmount(listVO.get(0).getAmount() + Integer.parseInt(amount));
		}
		return listVO;
	}

	@Override
	public ArrayList<TimeVO> getRecordTime() {
		log.info("getRecordTime: ");
		ArrayList<TimeVO> listVO = new ArrayList<TimeVO>();
		TimeVO timeIni = new TimeVO("sum",0);
		listVO.add(timeIni);
		
		ArrayList<HashMap<String,Object>> listmap = recordMapper.getRecordTimeRange("2019/02/15", "2019/05/17");
		for(int i=0; i<listmap.size(); i++) {
			String str = listmap.get(i).get("inserttime").toString();
			int amount = recordMapper.getRecordTimeCount(str);
			TimeVO timeVO = new TimeVO();
			timeVO.setAmount(amount);
			timeVO.setTime(str.substring(5));
			listVO.add(timeVO);
			listVO.get(0).setAmount(listVO.get(0).getAmount() + amount);
		}
		return listVO;
	}
	
	@Override
	public ArrayList<TimeVO> getTimeSearch(String sWordParking, String sWordStreet, String sWordArea, String starttime, String endtime) {
		log.info("getTimeSearch：" + starttime + " - " + endtime);
		ArrayList<TimeVO> listVO = new ArrayList<TimeVO>();
		
		if (starttime.compareTo("") == 0 && endtime.compareTo("") == 0 ) {
			starttime = "2019/02/15";
			endtime = "2019/05/17";
		}
		else {
			if (starttime.compareTo(endtime) > 0)
				return listVO;
		}
		
		TimeVO timeIni = new TimeVO("sum",0);
		listVO.add(timeIni);
		ArrayList<HashMap<String,Object>> listmap = recordMapper.getRecordTimeRange(starttime, endtime);
		
		if(sWordParking.compareTo("") != 0 ) {
			String parkcode = parkingMapper.getParkcode(sWordParking);
			for(int i=0; i<listmap.size(); i++) {
				String str = listmap.get(i).get("inserttime").toString();
				int amount = recordMapper.getRecordTimeCountForParking(str,parkcode);
				TimeVO timeVO = new TimeVO();
				timeVO.setAmount(amount);
				timeVO.setTime(str.substring(5));
				listVO.add(timeVO);
				listVO.get(0).setAmount(listVO.get(0).getAmount() + amount);
			}
		}
		else if(sWordStreet.compareTo("") != 0) {
			String streetcode = helperMapper.getStreetCode(sWordStreet);
			for(int i=0; i<listmap.size(); i++) {
				String str = listmap.get(i).get("inserttime").toString();
				int amount = recordMapper.getRecordTimeCountForStreet(str,streetcode);
				TimeVO timeVO = new TimeVO();
				timeVO.setAmount(amount);
				timeVO.setTime(str.substring(5));
				listVO.add(timeVO);
				listVO.get(0).setAmount(listVO.get(0).getAmount() + amount);
			}
		}
		
		else if(sWordArea.compareTo("") != 0) {
			String businesscode = helperMapper.getBusinessCode(sWordArea);
			for(int i=0; i<listmap.size(); i++) {
				String str = listmap.get(i).get("inserttime").toString();
				int amount = recordMapper.getRecordTimeCountForArea(str,businesscode);
				TimeVO timeVO = new TimeVO();
				timeVO.setAmount(amount);
				timeVO.setTime(str.substring(5));
				listVO.add(timeVO);
				listVO.get(0).setAmount(listVO.get(0).getAmount() + amount);
			}
		}
		else {
			for(int i=0; i<listmap.size(); i++) {
				String str = listmap.get(i).get("inserttime").toString();
				int amount = recordMapper.getRecordTimeCount(str);
				TimeVO timeVO = new TimeVO();
				timeVO.setAmount(amount);
				timeVO.setTime(str.substring(5));
				listVO.add(timeVO);
				listVO.get(0).setAmount(listVO.get(0).getAmount() + amount);
			}
		}
		
		return listVO;
	}

	@Override
	public ArrayList<ParkingTypeVO> getRecordChartTypeSearch(String searchWord, String source) {
		log.info("getRecordChartTypeSearch：" + searchWord + "  " + source);
		ArrayList<ParkingTypeVO> listVO = new ArrayList<ParkingTypeVO>();
		ArrayList<Record> listRecord = new ArrayList<Record>();
		if (source.equals("street")) {
			String streetcode = helperMapper.getStreetCode(searchWord);
			listRecord = recordMapper.getRecordWithStreet(streetcode);
		}
		else {
			String businesscode = helperMapper.getBusinessCode(searchWord);
			listRecord = recordMapper.getRecordWithArea(businesscode);
		}
		
		int[] typeAmount = {0,0,0,0,0};
		int typecode = 0;
		
		for(int i=0; i<listRecord.size(); i++) {
			String parkcode = listRecord.get(i).getParkcode();
			ArrayList<Parking> parkingList = parkingMapper.getTypeCode(parkcode);
			if (parkingList.size() != 0)
				typecode = Integer.parseInt(parkingList.get(0).getTypecode());
			if(typecode == 0)
				System.out.println(listRecord.get(i).getId());
			typeAmount[typecode]++;
		}
				
		for(int j=0; j<typeAmount.length; j++) {
			ParkingTypeVO typeVO = new ParkingTypeVO();
			typeVO.setTypecode(j+"");
			typeVO.setTypename(parkingTypeMapper.getTypeName(j+""));
			typeVO.setAmount(typeAmount[j]);
			listVO.add(typeVO);
		}
		listVO.get(0).setAmount(listRecord.size());
		return listVO;
	}

	@Override
	public ArrayList<StreetVO> getRecordChartStreetSearch(String searchWord) {
		log.info("getRecordChartStreetSearch：" + searchWord);
		String businesscode = helperMapper.getBusinessCode(searchWord);
		
		ArrayList<HashMap<String,Object>> listmap = recordMapper.getRecordStreetCountWithArea(businesscode);
		
		ArrayList<StreetVO> listVO = new ArrayList<StreetVO>();
		
		StreetVO streetVO = new StreetVO();
		streetVO.setStreetcode(0 + "");
		streetVO.setStreetname("");
		streetVO.setAreaname("");
		streetVO.setAmount(0);
        listVO.add(streetVO);
        
		for(int i=0; i<listmap.size(); i++) {
			HashMap<String, Object> map = listmap.get(i);
			
			String streetcode = map.get("streetcode").toString();
			String amount = map.get("count(streetcode)").toString();
			String streetname = helperMapper.getStreetName(streetcode);
//			System.out.println(streetcode + " " + amount + "  " + streetname);
			
			streetVO = new StreetVO();
			streetVO.setStreetcode(streetcode);
			streetVO.setStreetname(streetname);
			streetVO.setAreaname(helperMapper.getAreaNameByStreetCode(streetcode));
			streetVO.setAmount(Integer.parseInt(amount));
            listVO.add(streetVO);
            listVO.get(0).setAmount(listVO.get(0).getAmount() + Integer.parseInt(amount));
		}
//		System.out.println(listVO.size());
		return listVO;
	}

	@Override
	public ArrayList<AreaVO> getRecordChartAreaSearch(String searchWord) {
		log.info("getRecordChartAreaSearch: " + searchWord);
		String typecode = helperMapper.getTypeCode(searchWord);
		ArrayList<Parking> listparking = parkingMapper.getParkcodeByTypecode(typecode);
		int[] areaAmount = {0,0,0,0,0,0,0};
		
		for(int n=0; n<listparking.size(); n++) {
			ArrayList<HashMap<String,Object>> listmap = recordMapper.getRecordAreaCountWithType(listparking.get(n).getParkcode());
		
			for(int i=0; i<listmap.size(); i++) {
				HashMap<String, Object> map = listmap.get(i);
				
				String businesscode = map.get("businesscode").toString();
				int index = Integer.parseInt(businesscode.substring(14));
			
				int amount = Integer.parseInt(map.get("count(businesscode)").toString());
				areaAmount[index] += amount;
//				System.out.println("index: " + index + "   " + "amount: " + amount + "   " + "areaAmount[index]: " + areaAmount[index]);
			}
		}
		
		for (int n=1; n<areaAmount.length; n++) {
			areaAmount[0] += areaAmount[n];
		}
		
		ArrayList<AreaVO> listVO = new ArrayList<AreaVO>();
		for (int n=0; n<areaAmount.length; n++) {
			AreaVO areaVO = new AreaVO();
			String businesscode = "00000000000000" + n;
			areaVO.setBusinesscode(businesscode);
			areaVO.setAmount(areaAmount[n]);
			String areaname = helperMapper.getAreaName(businesscode);
			areaVO.setAreaname(areaname);
			listVO.add(areaVO);
		}
		return listVO;
	}

}
