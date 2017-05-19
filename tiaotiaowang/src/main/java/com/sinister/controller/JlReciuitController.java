package com.sinister.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinister.entity.AllJobs;
import com.sinister.entity.JlReciuit;
import com.sinister.entity.TtCom;
import com.sinister.service.AllJobsService;
import com.sinister.service.JlReciuitService;

@Controller
public class JlReciuitController {

	@Autowired
	private JlReciuitService jlReciuitService;

	@Autowired
	private AllJobsService allJobsService;

	// 调用安坤方法查询所有职位信息
	@RequestMapping("jlFindAllJobs.do")
	@ResponseBody
	public List<AllJobs> findAllJobs() {
		return allJobsService.get();
	}


	//JL Controller层保存招聘信息
	@RequestMapping("JlSaveReciuit.do")
	@ResponseBody
	public String JlSaveReciuit(@RequestBody JlReciuit jlReciuit,HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		TtCom ttCom = (TtCom) session.getAttribute("Com");
		//使用公司登陆时的账号id查询公司的具体信息的id值，并将查询结果传入jlReciuit.setC_mid
		int i = jlReciuitService.jlFindComId(ttCom.getC_id());
		//书写发布简历公司的公司信息id值
		jlReciuit.setC_mid(i);
		jlReciuitService.JlSaveReciuit(jlReciuit);
		return "saveSuccess";
	}

	//企业查询简历投递情况
	//在简历投递记录中查找，并且输出当前公司的简历
	
	
	
	
	
	
	
	
}
