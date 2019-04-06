package com.zucc.smart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zucc.smart.domain.Map;
import com.zucc.smart.domain.Parking;
import com.zucc.smart.domain.Vehicle;
import com.zucc.smart.service.ParkingService;
import com.zucc.smart.service.RecordService;
import com.zucc.smart.service.UserService;
import com.zucc.smart.service.VehicleService;
import com.zucc.smart.service.impl.Decode;
import com.zucc.smart.vObject.AreaVO;
import com.zucc.smart.vObject.ParkingTypeVO;
import com.zucc.smart.vObject.ParkingVO;
import com.zucc.smart.vObject.RecordVO;
import com.zucc.smart.vObject.StreetVO;
import com.zucc.smart.vObject.TimeVO;
import com.zucc.smart.vObject.UserVO;
import com.zucc.smart.vObject.WordsVO;


@RestController
@RequestMapping("/search")
public class SearchController {
	private static final Logger log = LoggerFactory.getLogger(SearchController.class);

	@Autowired
	ParkingService parkingService;
	
	@Autowired
	RecordService recordService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	VehicleService vehicleService;
    
    @RequestMapping(value = "/form/user/{user_id}", method = RequestMethod.GET)
    public ArrayList<ParkingVO> getFormSearch(@PathVariable("user_id") String user_id_obj, String searchWord) {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/search/form/user/" + user_id + "-----" + searchWord);
    	
    	ArrayList<ParkingVO> listVO = new ArrayList<ParkingVO>();
		listVO = parkingService.parkingSearch(searchWord);		
		return listVO;
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
    
    @RequestMapping(value = "/vehicle/user/{user_id}", method = RequestMethod.GET)
    public ArrayList<Vehicle> getUserVehicle(@PathVariable("user_id") String user_id_obj, String searchWord) {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/search/vehicle/user/" + user_id);
    	
    	ArrayList<Vehicle> list = new ArrayList<Vehicle>();
		list = vehicleService.getUserVehicle(user_id);		
		return list;
    }
    
    @RequestMapping(value = "/vehicle/admin", method = RequestMethod.GET)
    public ArrayList<Vehicle> getUserVehicleAdmin(String searchWord, String check_id) {
    	check_id = new String (Decode.decode(check_id));
    	log.info("/search/vehicle/admin ----- " + check_id);
    	
    	ArrayList<Vehicle> list = new ArrayList<Vehicle>();
		list = vehicleService.getUserVehicle(check_id);		
		return list;
    }
    
    @RequestMapping(value = "/user/admin", method = RequestMethod.GET)
    public ArrayList<UserVO> getUserSearch(String searchWord) {
    	log.info("/search/user/admin" + "-----" + searchWord);
    	
    	ArrayList<UserVO> list = new ArrayList<UserVO>();
		list = userService.userSearch(searchWord);		
		return list;
    }
    
    @RequestMapping(value = "/{user_id}/tags", method = RequestMethod.GET)
    public ArrayList<WordsVO> getAvailableTags(@PathVariable("user_id") String user_id_obj) {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/search/" + user_id + "/tags");   	
    	ArrayList<WordsVO> list = new ArrayList<WordsVO>();
		list = userService.getAvailableTags();		
		return list;
    }
    
    
    @RequestMapping(value = "/{searchWord}/time", method = RequestMethod.GET)
    public ArrayList<TimeVO> getRecordTimeSearch(@PathVariable("searchWord") String searchWord, String source) {
    	log.info("/search/" + searchWord + "/time ----- " + source);   	
    	ArrayList<TimeVO> listVO = new ArrayList<TimeVO>();
		listVO = recordService.getTimeSearch(searchWord, source);

		return listVO;
    }
    
    @RequestMapping(value = "/{searchWord}/check", method = RequestMethod.GET)
    public String checkTags(@PathVariable("searchWord") String searchWord) {
    	log.info("/search/" + searchWord + "/check");   	
    	ArrayList<WordsVO> list = new ArrayList<WordsVO>();
		list = userService.getAvailableTags();
		String result = "null";
		for(int i=0; i<list.size(); i++) {
			if(searchWord.equals(list.get(i).getValue())) {
				result = list.get(i).getSource();
				break;
			}
		}
		return result;
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
    
    @RequestMapping(value = "/{user_id}/map", method = RequestMethod.GET)
    public ArrayList<Map> getMapSearch(@PathVariable("user_id") String user_id_obj, String lng, String lat) {
    	String user_id = new String (Decode.decode(user_id_obj));
    	log.info("/search/" + user_id + "/map ----- " + lng + "," + lat);   	
    	ArrayList<Map> list = new ArrayList<Map>();
        
        list = parkingService.getParkingMap(lng, lat);

		return list;
    }
}
