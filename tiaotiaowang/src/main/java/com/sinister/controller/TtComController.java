package com.sinister.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinister.entity.TtCom;
import com.sinister.service.TtComService;
import com.sinister.util.Check;


@Controller
public class TtComController {

	@Resource
	private TtComService TtComService;
	@Resource
	private Check check;
	
	@RequestMapping("findTtCom.do")
	@ResponseBody
	public String findTtCom(@RequestBody TtCom ttCom){
		List<TtCom> lt = TtComService.findTtCom();
		for (TtCom ttCom2 : lt) {
			if(ttCom.getC_comName().equals(ttCom2.getC_comName())){
				return "repeat";
			}
		}
		if(check.checkC_comName(ttCom.getC_comName())==false){
				return "format error";
			}
		
		return "right";
	}
	@RequestMapping("registerTtCom.do")
	@ResponseBody
	public String registerTtCom(@RequestBody TtCom ttCom){
		List<TtCom> lt = TtComService.findTtCom();
		for (TtCom ttCom2 : lt) {
			if(ttCom.getC_comName().equals(ttCom2.getC_comName())){
				return "repeat";
			}
		}
			if(check.checkC_comName(ttCom.getC_comName())==false){
				return "format error";
			}else if(ttCom.getC_comName().equals("")||ttCom.getC_password().equals("")){
				return "null";
			}else if(!ttCom.getC_comName().equals("")&&!ttCom.getC_password().equals("")){
				TtComService.insertTtCom(ttCom);
			}		
		return "success";
	}
	
	@RequestMapping("loginTtCom.do")
	public String loginTtCom(){
		return "redirect:http://localhost:8080/comMessage.html";
	}

	
}
