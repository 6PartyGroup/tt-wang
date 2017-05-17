package com.sinister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sinister.service.AllJobsService;

@Controller
public class AllJobsController {
	
	//ankun 
	@Autowired
	private AllJobsService allJobsService;
	@RequestMapping("lo.do")
	public String find(){
		System.out.println("12");
		allJobsService.get();
		return "a";
	}
	@RequestMapping("a.do")
	public String a(){
		System.out.println("821");
		return "aa";
	}
}
