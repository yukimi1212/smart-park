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
import com.zucc.smart.service.ParkingService;
import com.zucc.smart.service.RecordService;
import com.zucc.smart.service.impl.Decode;
import com.zucc.smart.valueObject.AreaVO;
import com.zucc.smart.valueObject.ParkingTypeVO;
import com.zucc.smart.valueObject.RecordVO;
import com.zucc.smart.valueObject.StreetVO;


@RestController
@RequestMapping("/search")
public class SearchController {
	private static final Logger log = LoggerFactory.getLogger(SearchController.class);

	@Autowired
	ParkingService parkingService;
	
	@Autowired
	RecordService recordService;
    
    @RequestMapping(value = "/form/user/{user_id}", method = RequestMethod.GET)
    public ArrayList<Parking> getFormSearch(@PathVariable("user_id") String user_id_obj, String searchWord) {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/search/form/user/" + user_id + "-----" + searchWord);
    	
    	ArrayList<Parking> list = new ArrayList<Parking>();
		list = parkingService.parkingSearch(searchWord);		
		return list;
    }

    @RequestMapping(value = "/type/user/{user_id}", method = RequestMethod.GET)
    public ArrayList<ParkingTypeVO> getTypeSearch(@PathVariable("user_id") String user_id_obj, String searchWord) {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/search/type/user/" + user_id + "-----" + searchWord);
    	
    	ArrayList<ParkingTypeVO> list = new ArrayList<ParkingTypeVO>();
		list = parkingService.typeSearch(searchWord);		
		return list;
    }
    
    @RequestMapping(value = "/area/user/{user_id}", method = RequestMethod.GET)
    public ArrayList<AreaVO> getAreaSearch(@PathVariable("user_id") String user_id_obj, String searchWord) {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/search/area/user/" + user_id + "-----" + searchWord);
    	
    	ArrayList<AreaVO> list = new ArrayList<AreaVO>();
		list = parkingService.AreaSearch(searchWord);		
		return list;
    }
    
    @RequestMapping(value = "/street/user/{user_id}", method = RequestMethod.GET)
    public ArrayList<StreetVO> getStreetSearch(@PathVariable("user_id") String user_id_obj, String searchWord) {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/search/street/user/" + user_id + "-----" + searchWord);
    	
    	ArrayList<StreetVO> list = new ArrayList<StreetVO>();
		list = parkingService.streetSearch(searchWord);		
		return list;
    }
    
    @RequestMapping(value = "/record/user/{user_id}", method = RequestMethod.GET)
    public ArrayList<RecordVO> getUserRecordSearch(@PathVariable("user_id") String user_id_obj, String searchWord) {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/search/record/user/" + user_id + "-----" + searchWord);
    	
    	ArrayList<RecordVO> list = new ArrayList<RecordVO>();
		list = recordService.userRecordSearch(searchWord, user_id);		
		return list;
    }
    
    @RequestMapping(value = "/record/admin", method = RequestMethod.GET)
    public ArrayList<RecordVO> getAdminRecordSearch(String searchWord,String property) {
    	log.info("/search/record/admin" + "----- searchWord：" + searchWord);
    	ArrayList<RecordVO> list = new ArrayList<RecordVO>();
    	list = recordService.adminRecordSearch(searchWord);
/*    	if(property.equals("ID")) 
    		list = recordService.adminRecordIDSearch(searchWord);	
    	else if(property.equals("CPH")) 
    		list = recordService.adminRecordCPHSearch(searchWord);
    	else if(property.equals("parking"))
    		list = recordService.adminRecordParkingSearch(searchWord);
    	else if(property.equals("street"))
    		list = recordService.adminRecordStreetSearch(searchWord);
    	else
    		list = recordService.adminRecordAreaSearch(searchWord);
*/    		
		return list;
    }
    
}
