package com.sinister.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinister.dao.GZUserDao;
import com.sinister.entity.Cmessage;
import com.sinister.entity.Crecruit;
import com.sinister.entity.GZUserEntity;
import com.sinister.entity.GZmondel;
import com.sinister.entity.JlRecord;
import com.sinister.entity.User;
import com.sinister.service.GZUserService;

@Controller
public class GZUserController {
	
	@Autowired
	private GZUserService gzuserservice;
	
	
//	@RequestMapping("GZfind.do")
//	@ResponseBody
	public String findUser(@RequestBody GZUserEntity gz){
		//查找招聘信息表
		Crecruit crecruit =gzuserservice.findcrecruit(1);
		System.out.println(crecruit.getAddress());
//		
//		//根据公司信息表是次表  招聘信息是主表 查找招聘信息    两张表查询
		Crecruit crecruit1 = gzuserservice.findGZjob("载弛科技");
		System.out.println(crecruit1.getDuty());
		System.out.println(crecruit1.getCmessage().getName());

		//三表联查
//		Crecruit crecruit2 = gzuserservice.findjcr("java");
//		System.out.println(crecruit2.getDuty());
	
//		System.out.println(crecruit2.getCmessage().getName());
//      System.out.println(crecruit2.getAlljobs().getaName());
		
//		GZUserEntity entity = gzuserservice.findGZUser(gz.getMid());
//		System.out.println(entity.getAddress());
		return "success";
	}
   
	
//	@RequestMapping("GZfindcom.do")
//	@ResponseBody
//	public String findcom(@RequestBody Crecruit crecruit){
//		Crecruit crecruit1 = gzuserservice.findGZjob(crecruit.getCmessage().getName());
//		System.out.println("sssss");
//		return "";
//	}
	
	//根据公司查招聘信息
	@RequestMapping("GZfindcoms.do")
	@ResponseBody
	public Crecruit findUser(@RequestBody Cmessage cmessag){
		Crecruit crecruit1 = gzuserservice.findGZjob(cmessag.getName());
		System.out.println(crecruit1.getAddress());
		System.out.println(crecruit1.getCmessage().getName());
		return crecruit1;
	}
	//根据公司或者职位查招聘信息
	@RequestMapping(value="GZcomandjob.do", method=RequestMethod.POST)
	@ResponseBody
	public Crecruit findUser2(@RequestBody GZmondel gzmondel){
		Crecruit crecruit2 = gzuserservice.findjcr(gzmondel.getaName());
		System.out.println(crecruit2.getDuty());
		System.out.println(crecruit2.getCmessage().getName());
		System.out.println(crecruit2.getAlljobs().getaName());
		return crecruit2;
	}
	
	
	//根据公司名查找公司信息
	@RequestMapping(value="GZfinds.do",method=RequestMethod.POST)
	@ResponseBody
	public GZUserEntity findcomss(@RequestBody GZUserEntity ga,HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setAttribute("c_mid",ga.getName());
		System.out.println(ga.getName());
		GZUserEntity gas =gzuserservice.findcomss(ga.getName());
		System.out.println(gas.getName());
		return gas;
	}
	
	//保存投递信息
	@RequestMapping(value="gzsaveuser.do",method=RequestMethod.POST)
	@ResponseBody
	public String saveuser(HttpServletRequest request){
		HttpSession session1 = request.getSession();
		User user = (User) session1.getAttribute("uid");
		GZUserEntity com = (GZUserEntity) session1.getAttribute("c_mid");
		
		JlRecord jlrecord = new JlRecord();
		jlrecord.setU_mid(user.getUid());
		jlrecord.setC_mid(com.getMid());
//		jlrecord.setU_mid(2);
//		jlrecord.setC_mid(2);
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String hehe = dateFormat.format( now ); 
		jlrecord.setR_time(hehe);
		jlrecord.setR_status(0);
		gzuserservice.gasaveuser(jlrecord);
		return "success";
	}
	
	
	

}
