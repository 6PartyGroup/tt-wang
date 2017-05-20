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

	// ���ҹ����Ĵ����
	@RequestMapping("/JlfindJobs.do")
	@ResponseBody
	public List<AllJobs> JlfindJobs() {
		return jlReciuitService.JlFindJobs();
	}

	// ���ҹ����Ĵ�����µľ���ְλ
	@RequestMapping("/JlfindSmallJobs.do")
	@ResponseBody
	public List<AllJobs> JlfindSmallJobs(int a_id) {
		return jlReciuitService.JlfindSmallJob(a_id);
	}

	// JL Controller�㱣����Ƹ��Ϣ
	@RequestMapping("JlSaveReciuit.do")
	@ResponseBody
	public String JlSaveReciuit(@RequestBody JlReciuit jlReciuit, HttpServletRequest req) {

		HttpSession session = req.getSession();
		TtCom ttCom = (TtCom) session.getAttribute("Com");
		// ʹ�ù�˾��½ʱ���˺�id��ѯ��˾�ľ�����Ϣ��idֵ��������ѯ�������jlReciuit.setC_mid
		int i = jlReciuitService.jlFindComId(ttCom.getC_cid());
		// ��д����������˾�Ĺ�˾��Ϣidֵ
		jlReciuit.setC_mid(i);
		jlReciuitService.JlSaveReciuit(jlReciuit);
		return "saveSuccess";
	}

	// ��ҵ��ѯ����Ͷ�����
	// �ڼ���Ͷ�ݼ�¼�в��ң����������ǰ��˾�ļ���
	@RequestMapping("/jlfindRecord.do")
	@ResponseBody
	public List<JlRecord> findComRecord(HttpServletRequest rreq) {
		HttpSession session = rreq.getSession();
		TtCom ttCom = (TtCom) session.getAttribute("Com");
		List<JlRecord> list = jlReciuitService.findComRecord(94);
		return list;
	}

	// ��ҵ��ѯ����Ͷ�����
	// �ڼ���Ͷ�ݼ�¼�в��ң����������ǰ��˾�ļ���
	@RequestMapping("/jlSeePeople.do")
	@ResponseBody
	public List<UserMessage> jlSeePeople(@RequestBody JlIntModel jlIntModel) {
		int u_mid = jlIntModel.getU_mid();
		List<UserMessage> list = jlReciuitService.jlSeePeople(u_mid);
		return list;
	}

	// ������״̬�ĳ�1���Ѳ鿴��
	@RequestMapping("jlupdateStatusTo1.do")
	@ResponseBody
	public String jlupdateStatusTo1(@RequestBody JlIntModel jlIntModel) {

		jlReciuitService.jlupdateStatusTo1((jlIntModel).getC_cid());
		return "okk";
	}

	// ������״̬�ĳ�2��������Լ��
	@RequestMapping("jlupdateStatusTo2.do")
	@ResponseBody
	public String jlupdateStatusTo2(@RequestBody JlIntModel jlIntModel) {

		jlReciuitService.jlupdateStatusTo2(jlIntModel.getC_cid());
		return "jlUpdateSuccess";
	}

}
