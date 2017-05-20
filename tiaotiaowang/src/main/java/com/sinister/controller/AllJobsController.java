package com.sinister.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinister.entity.AkModel;
import com.sinister.entity.AllJobs;
import com.sinister.service.AkJobsService;
/**
 * 主页的controller层
 * 
 * @author ankun
 *
 */
@Controller
public class AllJobsController {
	
	//封装的service类
	@Autowired
	private AkJobsService akJobsService;
	/**
	 * 按时间查询最新的三条简历
	 * 
	 * @return List<AkModel> 包括公司信息、招聘职位和对应工作种类的模型
	 */
	@RequestMapping("akfind.do")
	@ResponseBody
	public List<AkModel> find(){
		List<AkModel> akModels = akJobsService.selectAkJobs();
		return akModels;
	}
	/**
	 * 根据职位查招聘信息
	 * 
	 * @param allJobs 要查询的职位
	 * @return List<AkModel> 包括公司信息、招聘职位和对应工作种类的模型
	 */
	@RequestMapping("akfindc.do")
	@ResponseBody
	public List<AkModel> findc(@RequestBody AllJobs allJobs){
		List<AkModel> akModels = akJobsService.selectAkJobsFromName(allJobs.getaName());
		return akModels;
	}
}
