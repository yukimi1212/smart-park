package com.zucc.smart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zucc.smart.domain.Parking;
import com.zucc.smart.domain.Record;
import com.zucc.smart.service.ParkingService;
import com.zucc.smart.service.RecordService;
import com.zucc.smart.service.impl.Decode;
import com.zucc.smart.valueObject.AreaVO;
import com.zucc.smart.valueObject.ParkingTypeVO;
import com.zucc.smart.valueObject.RecordVO;
import com.zucc.smart.valueObject.StreetVO;


@RestController
@RequestMapping("/record")
public class RecordController {
	private static final Logger log = LoggerFactory.getLogger(RecordController.class);

	@Autowired
	RecordService recordService;
    
	/**
	 * 普通用户个人纪录
	 */
    @RequestMapping(value = "/{user_id}/form", method = RequestMethod.GET)
    public ArrayList<RecordVO> getUserParkingForm(@PathVariable("user_id") String user_id_obj) {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/record/"+ user_id + "/form");
        ArrayList<RecordVO> list = new ArrayList<RecordVO>();
        list = recordService.getUserRecord();
    	return list;
    }
    
    /**
	 * 管理员访问纪录
	 */
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public ArrayList<RecordVO> getAdminParkingForm() {
    	log.info("/record/admin/form");
        ArrayList<RecordVO> list = new ArrayList<RecordVO>();
        list = recordService.getAdminRecord();
    	return list;
    }

}
