package com.sinister.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinister.entity.TtCom;
import com.sinister.service.TtComService;
import com.sinister.util.Check;

@Controller
public class TtComController {

	private TtComService TtComService;
	private Check check;
	
	@RequestMapping("findTtCom.do")
	@ResponseBody
	public String findTtCom(@RequestBody TtCom ttCom){
		List<TtCom> lt = TtComService.findTtCom();
		for (TtCom ttCom2 : lt) {
			if(ttCom.getC_comName().equals(ttCom2.getC_comName())){
				return "repeat";
			}else if(check.checkC_comName(ttCom.getC_comName())==false){
				return "format error";
			}
		}
		return "right";
		
	}
	
}
