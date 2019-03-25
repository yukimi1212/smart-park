package com.zucc.smart.controller;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger log = LoggerFactory.getLogger(AdminController.class);

	
    @RequestMapping(value = {"/", "/{searchWord}/record"})
    public String gotoParkingRecord(@PathVariable("searchWord") String searchWord, Map<String, Object> map) throws IOException {
//    	String[] s = searchWord.split("&");
//    	log.info("/admin/" + s[1] + "/record ----- property：" + s[0]);
    	log.info("/admin/" + searchWord + "/record");
    	map.put("user_id", "admin");
    	map.put("user_name", "管理员");
    	map.put("property", "property");
    	map.put("searchWord", searchWord);
    	return "searchRecord";
    }
}
