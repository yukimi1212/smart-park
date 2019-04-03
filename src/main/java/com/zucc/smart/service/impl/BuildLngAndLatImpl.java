package com.zucc.smart.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zucc.smart.domain.Parking;
import com.zucc.smart.mapper.ParkingMapper;
import com.zucc.smart.service.BuildLngAndLat;

@Service
public class BuildLngAndLatImpl implements BuildLngAndLat{

	private static final Logger log = LoggerFactory.getLogger(DataManageImpl.class);

	@Autowired
	ParkingMapper parkingMapper;
	
	//东经118.35°-120.5°，北纬29.183°-30.55°
	//120.052782,30.375016
	//120.294247,30.179401
	@Override
	public void bulidLngAndLat() {
		HashSet<String> lngset = new HashSet<String>();
		HashSet<String> latset = new HashSet<String>();

		randomSet(118.35,120.5,825,lngset);
		randomSet(29.183,30.55,825,latset);
		System.out.println(lngset.size());
		System.out.println(latset.size());
		int i = 0;
		Parking parking = new Parking();
		for(String s: lngset) {
			i++;
			ArrayList<Parking> parkinglist = parkingMapper.getParkcodeForLng("0");
			System.out.println(parkinglist.size());
			parking = parkinglist.get(0);
			System.out.println(i + "  " + s + "  " + parking.getParkcode());
			parkingMapper.updateLng(s,parking.getParkcode());
		}
		
		i = 0;
		for(String s: latset) {
			i++;
			parking = (parkingMapper.getParkcodeForLat("0")).get(0);
			System.out.println(i + "  " + s);
			parkingMapper.updateLat(s, parking.getParkcode());
		}
		
	}
	
	public static void randomSet(double min, double max, int n, HashSet<String> set) {  
		/*
		 * if (n > (max - min + 1) || max < min) { return; }
		 */ 
		
		java.text.DecimalFormat df = new java.text.DecimalFormat("#.######");   
		
	    for (int i = 0; i < n; i++) {  
	    	// 调用Math.random()方法  
	        double num = (double) (Math.random() * (max - min)) + min;  
	        String number = df.format(num);
	        set.add(number);// 将不同的数存入HashSet中  
	    }  
	    
	    int setSize = set.size();  
	    
	    // 如果存入的数小于指定生成的个数，则调用递归再生成剩余个数的随机数，如此循环，直到达到指定大小  
	    if (setSize < n) {  
	        randomSet(min, max, n - setSize, set);// 递归  
	    }  
	}  

}
