package com.sinister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinister.dao.GZUserDao;
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
		
		//查找招聘信息表
		Crecruit crecruit =gzuserservice.findcrecruit(1);
		System.out.println(crecruit.getAddress());
		
		//根据公司信息表是次表  招聘信息是主表 查找招聘信息    两张表查询
		Crecruit crecruit1 = gzuserservice.findGZjob("载弛科技");
		System.out.println(crecruit1.getDuty());
		System.out.println(crecruit1.getCmessage().getName());
		
		//三表联查
		Crecruit crecruit2 = gzuserservice.findjcr("移动端");
		System.out.println(crecruit2.getDuty());
		System.out.println(crecruit2.getCmessage().getName());
        System.out.println(crecruit2.getAlljobs().getaName());
		
		GZUserEntity entity = gzuserservice.findGZUser(gz.getMid());
		System.out.println(entity.getAddress());
		return "success";
	}
	

}
