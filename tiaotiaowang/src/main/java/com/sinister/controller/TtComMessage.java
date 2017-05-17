package com.sinister.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinister.entity.TtComMessageEntity;
import com.sinister.service.TtComService;
import com.sinister.util.Check;

@Controller
public class TtComMessage {

	@Autowired
	private TtComService ttComService;
	@Resource
	private Check check;
	
	@RequestMapping("showComMessage.do")
	@ResponseBody
	public TtComMessageEntity showComMessage(@RequestBody TtComMessageEntity comMessageEntity){
		
		return ttComService.findcomMessage(comMessageEntity);
		
	}
	
	@RequestMapping("comMessage.do")
	@ResponseBody
	public String comMessage(@RequestBody TtComMessageEntity comMessageEntity) {
		if(check.checkc_name(comMessageEntity.getC_name())==false &&
				comMessageEntity.getC_name()!=""){
			return "c_nameWorng";
		}else if(check.checkc_telon(comMessageEntity.getC_telon())==false&&
				comMessageEntity.getC_telon()!=""){
			return "c_telonWorng";
		}else if(check.checkc_nature(comMessageEntity.getC_nature())==false&&
				comMessageEntity.getC_nature()!=""){
			return "c_natureWorng";
		}
		ttComService.saveComMessage(comMessageEntity);
		return "ok";

	}
	
}
