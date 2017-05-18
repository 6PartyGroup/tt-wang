package com.sinister.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinister.dao.AkJobsDao;
import com.sinister.entity.AkModel;
import com.sinister.entity.Crecruit;
import com.sinister.service.AkJobsService;
import com.sinister.service.AllJobsService;
import com.sinister.service.GZUserService;

@Controller
public class AllJobsController {
	
	//ankun 
	@Autowired
	private AkJobsService akJobsService;
	@RequestMapping("akfind.do")
	@ResponseBody
	public List<AkModel> find(){
		List<AkModel> akModels = akJobsService.selectAkJobs();
		System.out.println("51131365");
		return akModels;
	}
	@RequestMapping("akfindc.do")
	@ResponseBody
	public List<AkModel> findc(@RequestBody String name){
		List<AkModel> akModels = akJobsService.selectAkJobsFromName(name);
		System.out.println("1234");
		return akModels;
	}
	@RequestMapping("a.do")
	public String a(){
		System.out.println("821");
		return "aa";
	}
}
