package com.zucc.smart.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import com.zucc.smart.domain.Map;
import java.util.Set;

import com.zucc.smart.domain.Parking;
import com.zucc.smart.domain.ParkingType;
import com.zucc.smart.mapper.HelperMapper;
import com.zucc.smart.mapper.ParkingMapper;
import com.zucc.smart.mapper.ParkingTypeMapper;
import com.zucc.smart.service.ParkingService;
import com.zucc.smart.vObject.AreaVO;
import com.zucc.smart.vObject.ParkingTypeVO;
import com.zucc.smart.vObject.ParkingVO;
import com.zucc.smart.vObject.StreetVO;

@Service
public class ParkingServiceImpl implements ParkingService {

	private static final Logger log = LoggerFactory.getLogger(ParkingServiceImpl.class);

    @Autowired
    ParkingMapper parkingMapper;    
    
    @Autowired
    ParkingTypeMapper parkingTypeMapper;
    
    @Autowired
    HelperMapper helperMapper;
	
	@Override
	public ArrayList<ParkingVO> getAllParking() {
		log.info("getAllParking: ");
        ArrayList<Parking> list = parkingMapper.getAllParking();
        ArrayList<ParkingVO> listVO = changeToParkingVO(list);
        return listVO;
	}
	
	@Override
	public boolean checkParkCode(String parkcode) {
		log.info("checkParkCode: " + parkcode);
		int n = parkingMapper.checkParkCode(parkcode);
		if(n == 0)
			return true;
		else
			return false;
	}

	@Override
	public ArrayList<String> getBusinesscode() {
		log.info("getBusinesscode: ");
		ArrayList<String> list = parkingMapper.getBusinesscode();
		return list;
	}

	@Override
	public ArrayList<ParkingTypeVO> getParkingType() {
		log.info("getParkingType：");
		ArrayList<ParkingTypeVO> list = new ArrayList<ParkingTypeVO>();
		
		ArrayList<HashMap<String,Object>> listmap = parkingMapper.getTypeCount();
		
		for(int i=0; i<listmap.size(); i++) {
			HashMap<String,Object> map = listmap.get(i);
			String typecode = map.get("typecode").toString();
			String typename = parkingTypeMapper.getTypeName(typecode);	
			int amount = Integer.parseInt(map.get("count(typecode)").toString());
			ParkingTypeVO typeVO = new ParkingTypeVO();
            typeVO.setTypecode(typecode);
            typeVO.setTypename(typename);
            typeVO.setAmount(amount);
            list.add(typeVO);
		}
		
		return list;
	}

	@Override
	public ArrayList<AreaVO> getArea() {
		log.info("getArea：");
		ArrayList<AreaVO> list = new ArrayList<AreaVO>();
		
		ArrayList<HashMap<String,Object>> listmap = parkingMapper.getAreaCount();
				
		for(int i=0; i<listmap.size(); i++) {
			HashMap<String,Object> map = listmap.get(i);
	
			String businesscode = map.get("BUSINESSCODE").toString();
			String areaname = helperMapper.getAreaName(businesscode);	
			int amount = Integer.parseInt(map.get("count(BUSINESSCODE)").toString());
			AreaVO areaVO = new AreaVO();
            areaVO.setBusinesscode(businesscode);
            areaVO.setAreaname(areaname);
            areaVO.setAmount(amount);
            list.add(areaVO);
		}
		
		return list;
	}
	
	@Override
	public ArrayList<StreetVO> getStreet() {
		log.info("getStreet：");
		ArrayList<StreetVO> list = new ArrayList<StreetVO>();
		
		ArrayList<HashMap<String,Object>> listmap = parkingMapper.getStreetCount();
		
		for(int i=0; i<listmap.size(); i++) {
			HashMap<String,Object> map = listmap.get(i);
			
			String streetcode = map.get("streetcode").toString();
			String streetname = helperMapper.getStreetName(streetcode);
			String areaname = helperMapper.getAreaNameByStreetCode(streetcode);
			int amount = Integer.parseInt(map.get("count(streetcode)").toString());
			StreetVO streetVO = new StreetVO();
			streetVO.setStreetcode(streetcode);
			streetVO.setStreetname(streetname);
			streetVO.setAreaname(areaname);
			streetVO.setAmount(amount);
            list.add(streetVO);
		}
		
		return list;
	}

	@Override
	public ArrayList<ParkingVO> parkingSearch(String searchWord) {
		log.info("parkingSearch：" + searchWord);
		searchWord = "%"+searchWord+"%";
		ArrayList<Parking> list = parkingMapper.parkingSearch(searchWord);
		ArrayList<ParkingVO> listVO = changeToParkingVO(list);
		return listVO;
	}

	@Override
	public ArrayList<ParkingTypeVO> typeSearch(String searchWord) {
		log.info("typeSearch：" + searchWord);
		searchWord = "%"+searchWord+"%";
		
		ArrayList<ParkingType> list = parkingTypeMapper.searchType(searchWord);
		ArrayList<ParkingTypeVO> listVO = new ArrayList<ParkingTypeVO>();
		
		for(int i=0; i<list.size(); i++) {
			String a = parkingMapper.getOneTypeCount(list.get(i).getTypecode());
			int amount = Integer.parseInt(a);
			
			ParkingTypeVO typeVO = new ParkingTypeVO();
			typeVO.setTypecode(list.get(i).getTypecode());
			typeVO.setTypename(list.get(i).getTypename());
			typeVO.setAmount(amount);
			listVO.add(typeVO);
		}
		
		return listVO;
	}

	@Override
	public ArrayList<StreetVO> streetSearch(String searchWord) {
		log.info("streetSearch：" + searchWord);
		searchWord = "%"+searchWord+"%";
		
		ArrayList<HashMap<String,String>> listmap = parkingMapper.searchStreet(searchWord);
		ArrayList<StreetVO> listVO = new ArrayList<StreetVO>();
		
		for(int i=0; i<listmap.size(); i++) {
			HashMap<String, String> map = listmap.get(i);
			
			String streetcode = map.get("streetcode").toString();
			String streetname = map.get("streetname").toString();
			String areaname = helperMapper.getAreaNameByStreetCode(streetcode);
			int amount = Integer.parseInt(parkingMapper.getOneStreetCount(streetcode));
			StreetVO streetVO = new StreetVO();
			streetVO.setStreetcode(streetcode);
			streetVO.setStreetname(streetname);
			streetVO.setAreaname(areaname);
			streetVO.setAmount(amount);
            listVO.add(streetVO);
		}
		
		return listVO;
	}
	
	@Override
	public ArrayList<AreaVO> AreaSearch(String searchWord) {
		log.info("AreaSearch：" + searchWord);
		searchWord = "%"+searchWord+"%";
		
		ArrayList<HashMap<String,String>> listmap = parkingMapper.searchArea(searchWord);
		ArrayList<AreaVO> listVO = new ArrayList<AreaVO>();
        
		for(int i=0; i<listmap.size(); i++) {
			HashMap<String, String> map = listmap.get(i);
			
			String businesscode = map.get("BUSINESSCODE").toString();
			String areaname = map.get("areaname").toString();
			int amount = Integer.parseInt(parkingMapper.getOneAreaCount(businesscode));
			AreaVO areaVO = new AreaVO();
			areaVO.setBusinesscode(businesscode);
			areaVO.setAreaname(areaname);
			areaVO.setAmount(amount);
            listVO.add(areaVO);
		}
		
		return listVO;
	}
	
	public ArrayList<ParkingVO> changeToParkingVO(ArrayList<Parking> list){
		ArrayList<ParkingVO> listVO = new ArrayList<ParkingVO>();
		for(int i=0; i<list.size(); i++) {
			ParkingVO parkingVO = new ParkingVO();
			parkingVO.setParkcode(list.get(i).getParkcode());
			parkingVO.setParkname(list.get(i).getParkname());
			parkingVO.setStreetcode(list.get(i).getStreetcode());
			parkingVO.setStreetname(list.get(i).getStreetname());
			parkingVO.setBusinesscode(list.get(i).getBusinesscode());
			parkingVO.setAreaname(list.get(i).getAreaname());
			parkingVO.setParking_amount(list.get(i).getParking_amount());
			String typename = parkingTypeMapper.getTypeName(list.get(i).getTypecode());
			parkingVO.setTypename(typename);
			listVO.add(parkingVO);
		}
		return listVO;
	}

	@Override
	public ArrayList<Map> getParkingMap(String lng, String lat) {
		log.info("getParkingMap：" + lng + "," + lat);
		ArrayList<Map> maplist = new ArrayList<Map>();
        double search_lng = Double.parseDouble(lng);
        double up_lng = search_lng + 0.2;
        double down_lng = search_lng - 0.2;
        
        double search_lat = Double.parseDouble(lat);
        double up_lat = search_lat + 0.05;
        double down_lat = search_lat - 0.05;
        ArrayList<Parking> parkinglist = parkingMapper.getParkingSearch(up_lng + "", down_lng + "", up_lat + "", down_lat + "");
        
        for(int i=0; i<parkinglist.size(); i++) {
			Map map = new Map();
			map.setLng(parkinglist.get(i).getLng());
			map.setLat(parkinglist.get(i).getLat());
			map.setTitle(parkinglist.get(i).getParkname());
			map.setCon(parkinglist.get(i).getStreetname() + "," + parkinglist.get(i).getAreaname());
			map.setBranch(parkinglist.get(i).getParkname());
			maplist.add(map);
		}
		return maplist;
	}

	@Override
	public void addParking(String parkcode, String parkname, String streetname,
			String areaname, String typename, String parking_amount, String lng, String lat) {
		log.info("addParking：" + parkcode + "," + parkname);

		String typecode = parkingTypeMapper.getTypeCode(typename);
		String streetcode = helperMapper.getStreetCode(streetname);
		String businesscode = helperMapper.getBusinessCode(areaname);
		parkingMapper.addParking(parkcode, streetcode, businesscode, parkname, streetname, areaname, typecode, parking_amount,lng, lat);
	}
}
