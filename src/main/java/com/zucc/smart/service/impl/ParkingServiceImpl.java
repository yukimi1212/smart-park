package com.zucc.smart.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.zucc.smart.domain.Parking;
import com.zucc.smart.mapper.ParkingMapper;
import com.zucc.smart.mapper.ParkingTypeMapper;
import com.zucc.smart.service.ParkingService;
import com.zucc.smart.valueObject.AreaVO;
import com.zucc.smart.valueObject.ParkingTypeVO;
import com.zucc.smart.valueObject.StreetVO;

@Service
public class ParkingServiceImpl implements ParkingService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    ParkingMapper parkingMapper;    
    
    @Autowired
    ParkingTypeMapper parkingTypeMapper;
	
	@Override
	public ArrayList<Parking> getAllParking() {
		log.info("getAllParking: ");
        ArrayList<Parking> list = parkingMapper.getAllParking();
        return list;
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
		
		System.out.println(listmap.size());
		
		for(int i=0; i<listmap.size(); i++) {
			HashMap<String,Object> map = listmap.get(i);
	
			String businesscode = map.get("BUSINESSCODE").toString();
			String areaname = parkingMapper.getAreaName(businesscode);	
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
			String streetname = parkingMapper.getStreetName(streetcode);
			String areaname = parkingMapper.getAreaNameByStreetcode(streetcode);
			int amount = Integer.parseInt(map.get("count(streetcode)").toString());
			StreetVO streetVO = new StreetVO();
			streetVO.setStreetcode(streetcode);
			streetVO.setStreetname(streetname);;
			streetVO.setAreaname(areaname);
			streetVO.setAmount(amount);
            list.add(streetVO);
		}
		
		return list;
	}

}
