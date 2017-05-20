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
import com.sinister.entity.JlIntModel;
import com.sinister.entity.JlReciuit;
import com.sinister.entity.JlRecord;
import com.sinister.entity.TtCom;
import com.sinister.entity.UserMessage;
import com.sinister.service.JlReciuitService;

@Controller
public class JlReciuitController {

	@Autowired
	private JlReciuitService jlReciuitService;

	// 查找工作的大分类
	@RequestMapping("/JlfindJobs.do")
	@ResponseBody
	public List<AllJobs> JlfindJobs() {
		return jlReciuitService.JlFindJobs();
	}

	// 查找工作的大分类下的具体职位
	@RequestMapping("/JlfindSmallJobs.do")
	@ResponseBody
	public List<AllJobs> JlfindSmallJobs(int a_id) {
		return jlReciuitService.JlfindSmallJob(a_id);
	}

	// JL Controller层保存招聘信息
	@RequestMapping("JlSaveReciuit.do")
	@ResponseBody
	public String JlSaveReciuit(@RequestBody JlReciuit jlReciuit, HttpServletRequest req) {

		HttpSession session = req.getSession();
		TtCom ttCom = (TtCom) session.getAttribute("Com");
		// 使用公司登陆时的账号id查询公司的具体信息的id值，并将查询结果传入jlReciuit.setC_mid
		int i = jlReciuitService.jlFindComId(ttCom.getC_cid());
		// 书写发布简历公司的公司信息id值
		jlReciuit.setC_mid(i);
		jlReciuitService.JlSaveReciuit(jlReciuit);
		return "saveSuccess";
	}

	// 企业查询简历投递情况
	// 在简历投递记录中查找，并且输出当前公司的简历
	@RequestMapping("/jlfindRecord.do")
	@ResponseBody
	public List<JlRecord> findComRecord(HttpServletRequest rreq) {
		HttpSession session = rreq.getSession();
		TtCom ttCom = (TtCom) session.getAttribute("Com");
		List<JlRecord> list = jlReciuitService.findComRecord(94);
		return list;
	}

	// 企业查询简历投递情况
	// 在简历投递记录中查找，并且输出当前公司的简历
	@RequestMapping("/jlSeePeople.do")
	@ResponseBody
	public List<UserMessage> jlSeePeople(@RequestBody JlIntModel jlIntModel) {
		int u_mid = jlIntModel.getU_mid();
		List<UserMessage> list = jlReciuitService.jlSeePeople(u_mid);
		return list;
	}

	// 将简历状态改成1（已查看）
	@RequestMapping("jlupdateStatusTo1.do")
	@ResponseBody
	public String jlupdateStatusTo1(@RequestBody JlIntModel jlIntModel) {

		jlReciuitService.jlupdateStatusTo1((jlIntModel).getC_cid());
		return "okk";
	}

	// 将简历状态改成2（面试邀约）
	@RequestMapping("jlupdateStatusTo2.do")
	@ResponseBody
	public String jlupdateStatusTo2(@RequestBody JlIntModel jlIntModel) {

		jlReciuitService.jlupdateStatusTo2(jlIntModel.getC_cid());
		return "jlUpdateSuccess";
	}

}
