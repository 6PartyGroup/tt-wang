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

	// ���ð���������ѯ����ְλ��Ϣ
	@RequestMapping("jlFindAllJobs.do")
	@ResponseBody
	public List<AllJobs> findAllJobs() {
		return allJobsService.get();
	}


	//JL Controller�㱣����Ƹ��Ϣ
	@RequestMapping("JlSaveReciuit.do")
	@ResponseBody
	public String JlSaveReciuit(@RequestBody JlReciuit jlReciuit,HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		TtCom ttCom = (TtCom) session.getAttribute("Com");
		//ʹ�ù�˾��½ʱ���˺�id��ѯ��˾�ľ�����Ϣ��idֵ��������ѯ�������jlReciuit.setC_mid
		int i = jlReciuitService.jlFindComId(ttCom.getC_id());
		//��д����������˾�Ĺ�˾��Ϣidֵ
		jlReciuit.setC_mid(i);
		jlReciuitService.JlSaveReciuit(jlReciuit);
		return "saveSuccess";
	}

	//��ҵ��ѯ����Ͷ�����
	//�ڼ���Ͷ�ݼ�¼�в��ң����������ǰ��˾�ļ���
	
	
	
	
	
	
	
	
}
