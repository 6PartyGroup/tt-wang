package com.sinister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinister.entity.JlReciuit;
import com.sinister.service.JlReciuitService;

@Controller
public class JlReciuitController {

	@Autowired
	private JlReciuitService jlReciuitService ;
	
	@RequestMapping("jltest")
	@ResponseBody
	public String test(){
		return "OK";
	}
	

	/**
	 * JL Controller�㱣����Ƹ��Ϣ
	 * @param jlReciuit
	 * @return
	 */
	@RequestMapping("JlSaveReciuit.do")
	@ResponseBody
	public String JlSaveReciuit(JlReciuit jlReciuit){
		jlReciuitService.JlSaveReciuit(jlReciuit);
		return "saveSuccess" ;
	}
	
}
