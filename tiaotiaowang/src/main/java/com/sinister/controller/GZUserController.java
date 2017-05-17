package com.sinister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinister.entity.Crecruit;
import com.sinister.entity.GZUserEntity;
import com.sinister.service.GZUserService;

@Controller
public class GZUserController {
	
	@Autowired
	private GZUserService gzuserservice;
	
	@RequestMapping("find.do")
	@ResponseBody
	public String findUser(@RequestBody GZUserEntity gz){
		
		
		Crecruit crecruit =gzuserservice.findGZjob("载驰科技");
		System.out.println(crecruit.getAddress());
		System.out.println(crecruit.getCmessage().getName());
		
		GZUserEntity entity = gzuserservice.findGZUser(gz.getMid());
		System.out.println(entity.getAddress());
		return "success";
	}
	
   

}
