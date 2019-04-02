package com.zucc.smart.service.impl;

import java.util.ArrayList;
import java.util.HashMap;

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
import com.zucc.smart.valueObject.AreaVO;
import com.zucc.smart.valueObject.ParkingTypeVO;
import com.zucc.smart.valueObject.RecordVO;
import com.zucc.smart.valueObject.StreetVO;
import com.zucc.smart.valueObject.TimeVO;
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
//		log.info("userRecordParkingSearch: " + searchWord + "  cph：" + cph);
		ArrayList<Parking> listParking = parkingMapper.searchParkcodeByParkname("%"+searchWord+"%");
		ArrayList<Record> listAll = new ArrayList<Record>();
		for(int i=0; i<listParking.size(); i++) {
			ArrayList<Record> list = recordMapper.searchUserRecordByParking(listParking.get(i).getParkcode(), cph);
			listAll.addAll(list);
		}		
		return listAll;
	}
	
	@Override
	public ArrayList<Record> userRecordStreetSearch(String searchWord, String cph) {
//		log.info("userRecordStreetSearch: " + searchWord + "  cph：" + cph);
		ArrayList<Parking> listRecord = parkingMapper.searchStreetcodeByStreetname("%"+searchWord+"%");
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
		ArrayList<Parking> listArea = parkingMapper.searchBusinesscodeByAreaname("%"+searchWord+"%");
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

	@Override
	public ArrayList<ParkingTypeVO> getRecordType() {
		log.info("getRecordType: ");
		long start,end;
		start = System.currentTimeMillis();
		
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
		
		end = System.currentTimeMillis();  
		System.out.println("start time:" + start+ "; end time:" + end+ "; Run Time:" + (end - start) + "(ms)");
		
		for(int j=0; j<typeAmount.length; j++) {
			ParkingTypeVO typeVO = new ParkingTypeVO();
			typeVO.setTypecode(j+"");
			typeVO.setTypename(parkingTypeMapper.getTypeName(j+""));
			typeVO.setAmount(typeAmount[j]);
			listVO.add(typeVO);
		}
		
		end = System.currentTimeMillis();  
		System.out.println("start time:" + start+ "; end time:" + end+ "; Run Time:" + (end - start) + "(ms)");
		return listVO;
	}
	
	@Override
	public ArrayList<AreaVO> getRecordArea() {
		log.info("getRecordArea: ");
		ArrayList<HashMap<String,Object>> listmap = recordMapper.getRecordAreaCount();
		ArrayList<AreaVO> listVO = new ArrayList<AreaVO>();
		for(int i=0; i<listmap.size(); i++) {
			HashMap<String, Object> map = listmap.get(i);
			
			String businesscode = map.get("businesscode").toString();
			String amount = map.get("count(businesscode)").toString();
			String areaname = helperMapper.getAreaName(businesscode);
			
			AreaVO areaVO = new AreaVO();
			areaVO.setBusinesscode(businesscode);
			areaVO.setAreaname(areaname);
			areaVO.setAmount(Integer.parseInt(amount));
            listVO.add(areaVO);
//            System.out.println(areaVO.getBusinesscode() + "   " + areaVO.getAreaname() + "   " + areaVO.getAmount());
		}
		return listVO;
	}

	@Override
	public ArrayList<StreetVO> getRecordStreet() {
		log.info("getRecordStreet: ");
		ArrayList<HashMap<String,Object>> listmap = recordMapper.getRecordStreetCount();
		ArrayList<StreetVO> listVO = new ArrayList<StreetVO>();
		for(int i=0; i<listmap.size(); i++) {
			HashMap<String, Object> map = listmap.get(i);
			
			String streetcode = map.get("streetcode").toString();
			String amount = map.get("count(streetcode)").toString();
			String streetname = helperMapper.getStreetName(streetcode);
			
			StreetVO streetVO = new StreetVO();
			streetVO.setStreetcode(streetcode);
			streetVO.setStreetname(streetname);
			streetVO.setAmount(Integer.parseInt(amount));
            listVO.add(streetVO);
		}
		return listVO;
	}

	@Override
	public ArrayList<TimeVO> getRecordTime() {
		log.info("getRecordTime: ");
		ArrayList<TimeVO> listVO = new ArrayList<TimeVO>();
		TimeVO timeIni = new TimeVO("sum",0);
		listVO.add(timeIni);
		String first;
		for(int i=7; i<20; i++) {
			if(i<10)
				first = "0" + i + "";
			else
				first = i + "";
			String str = "%12/12/2011 " + first + "%";
			int amount = recordMapper.getRecordTimeCount(str);
			TimeVO timeVO = new TimeVO();
			timeVO.setAmount(amount);
			timeVO.setTime(i + ":00 - " + (i+1) + ":00");
			listVO.add(timeVO);
			listVO.get(0).setAmount(listVO.get(0).getAmount() + amount);
		}
		
		return listVO;
	}
	
	@Override
	public ArrayList<TimeVO> getTimeSearch(String searchWord, String source) {
		log.info("getTimeSearch：" + searchWord + "   " + source);
		ArrayList<TimeVO> listVO = new ArrayList<TimeVO>();
		TimeVO timeIni = new TimeVO("sum",0);
		listVO.add(timeIni);
		if(source.equals("park")) {
			String parkcode = parkingMapper.getParkcode(searchWord);
			String first;
			for(int i=7; i<20; i++) {
				if(i<10)
					first = "0" + i + "";
				else
					first = i + "";
				String str = "%12/12/2011 " + first + "%";
				int amount = recordMapper.getRecordTimeCountForParking(str,parkcode);
				TimeVO timeVO = new TimeVO();
				timeVO.setAmount(amount);
				timeVO.setTime(i + ":00 - " + (i+1) + ":00");
				listVO.add(timeVO);
				listVO.get(0).setAmount(listVO.get(0).getAmount() + amount);
			}
		}
		else if(source.equals("street")) {
			String streetcode = helperMapper.getStreetCode(searchWord);
			String first;
			for(int i=7; i<20; i++) {
				if(i<10)
					first = "0" + i + "";
				else
					first = i + "";
				String str = "%12/12/2011 " + first + "%";
				int amount = recordMapper.getRecordTimeCountForStreet(str,streetcode);
				TimeVO timeVO = new TimeVO();
				timeVO.setAmount(amount);
				timeVO.setTime(i + ":00 - " + (i+1) + ":00");
				listVO.add(timeVO);
				listVO.get(0).setAmount(listVO.get(0).getAmount() + amount);
			}
		}
		
		else if(source.equals("area")) {
			String businesscode = helperMapper.getBusinesscode(searchWord);
			String first;
			for(int i=7; i<20; i++) {
				if(i<10)
					first = "0" + i + "";
				else
					first = i + "";
				String str = "%12/12/2011 " + first + "%";
				int amount = recordMapper.getRecordTimeCountForArea(str,businesscode);
				TimeVO timeVO = new TimeVO();
				timeVO.setAmount(amount);
				timeVO.setTime(i + ":00 - " + (i+1) + ":00");
				listVO.add(timeVO);
				listVO.get(0).setAmount(listVO.get(0).getAmount() + amount);
			}
		}
		else {
			
			long start,end;
			start = System.currentTimeMillis();
			
			String typecode = helperMapper.getTypecode(searchWord);
			ArrayList<Parking> parkingList = parkingMapper.getParkcodeByTypecode(typecode);
			
			String parkcode, first;
			for(int i=7; i<20; i++) {
				if(i<10)
					first = "0" + i + "";
				else
					first = i + "";
				String str = "%12/12/2011 " + first + "%";
				TimeVO timeVO = new TimeVO();
				timeVO.setTime(i + ":00 - " + (i+1) + ":00");
				timeVO.setAmount(0);
				for(int p=0; p<parkingList.size(); p++) {
					parkcode = parkingList.get(p).getParkcode();
					int amount = recordMapper.getRecordTimeCountForParking(str,parkcode);
					timeVO.setAmount(timeVO.getAmount() + amount);
//					System.out.println("str：" + str + "  parkcode：" + parkcode);
				}
				
				listVO.add(timeVO);
				listVO.get(0).setAmount(listVO.get(0).getAmount() + timeVO.getAmount());
			}
			
			end = System.currentTimeMillis();  
			System.out.println("start time:" + start+ "; end time:" + end+ "; Run Time:" + (end - start) + "(ms)");
		}
		
		return listVO;
	}

}
