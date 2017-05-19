package com.sinister.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sinister.entity.TtCom;
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
	public TtComMessageEntity showComMessage(@RequestBody TtComMessageEntity comMessageEntity) {
		return ttComService.findcomMessage(comMessageEntity);
	}

	@RequestMapping("checkc_name.do")
	@ResponseBody
	public String checkc_name(@RequestBody TtComMessageEntity comMessageEntity) {
		if (check.checkc_name(comMessageEntity.getC_name()) == false || comMessageEntity.getC_name() == "") {
			return "c_nameWorng";
		}

		return "ok";

	}

	@RequestMapping("checkc_telon.do")
	@ResponseBody
	public String checkc_telon(@RequestBody TtComMessageEntity comMessageEntity) {
		if (check.checkc_telon(comMessageEntity.getC_telon()) == false || comMessageEntity.getC_telon() == "") {
			return "c_telonWorng";
		}

		return "ok";

	}

	@RequestMapping("checkc_nature.do")
	@ResponseBody
	public String checkc_nature(@RequestBody TtComMessageEntity comMessageEntity) {
		if (check.checkc_nature(comMessageEntity.getC_nature()) == false || comMessageEntity.getC_nature() == "") {
			return "c_natureWorng";
		}

		return "ok";

	}

	@RequestMapping("comMessage.do")
	@ResponseBody
	public String savecomMessage(@RequestBody TtComMessageEntity comMessageEntity, HttpSession session) {
		if (check.checkc_name(comMessageEntity.getC_name()) == false || comMessageEntity.getC_name() == "") {
			return "c_nameWorng";
		} else if (check.checkc_telon(comMessageEntity.getC_telon()) == false || comMessageEntity.getC_telon() == "") {
			return "c_telonWorng";
		} else if (check.checkc_nature(comMessageEntity.getC_nature()) == false
				|| comMessageEntity.getC_nature() == "") {
			return "c_natureWorng";
		} else if (comMessageEntity.getC_address() == "") {
			return "c_addressWorng";
		} else if (comMessageEntity.getC_scale() == 0) {
			return "c_scaleWorng";
		} else if (comMessageEntity.getC_show() == "") {
			return "c_showWorng";
		} else if (comMessageEntity.getC_email() == "") {
			return "c_emailWorng";
		}
		//查询一下登录session 的id给到公司信息实体类
		comMessageEntity.setC_cid((Integer) session.getAttribute("RId"));
		//查询一下上传头像的session的mid传给公司信息的实体类
		comMessageEntity.setC_mid((Integer) session.getAttribute("c_mid"));
		//把公司信息传到数据库里面
		ttComService.saveComMessage(comMessageEntity);
		//根据公司实体类里的mid(主键id)查询单个公司信息
		TtComMessageEntity te = ttComService.findcomMessage_name(comMessageEntity);
		//然后把单个公司信息里的主键id放入到session里
		session.setAttribute("ComMessageId", te.getC_cid());
		return "ok";

	}

	// 上传头像
	@RequestMapping("fileupdata.do")
	public String fileupdata(@RequestParam("file") MultipartFile file,HttpSession session) throws IOException {
		List<TtComMessageEntity> lt = ttComService.findcomImg();
		for (TtComMessageEntity ttComMessageEntity : lt) {
			//判断重名
			if (!file.isEmpty() && 
					file.getOriginalFilename()!=ttComMessageEntity.getC_logo()) {// 文件不能为空
				FileUtils.copyInputStreamToFile(file.getInputStream(),
						new File("/users/zhaoce/Desktop", file.getOriginalFilename()));
				String path = file.getOriginalFilename();
				TtComMessageEntity CME = new TtComMessageEntity();
				CME.setC_logo(path);
				//若果注册过来的就给注册的session
				if(session.getAttribute("RId")!=null){
					CME.setC_cid((Integer) session.getAttribute("RId"));
				//如果登陆过来的就给登陆的session
				}else if(session.getAttribute("Com")!=null){
					TtCom com = (TtCom) session.getAttribute("Com");
					CME.setC_cid(com.getC_cid());
				}
//				CME.setC_cid((Integer) session.getAttribute("ComMessageId"));
				ttComService.saveComMessagefile(CME);
				TtComMessageEntity tcm= ttComService.findcomMessage_logo(CME);
				session.setAttribute("c_mid", tcm.getC_mid());
				return "redirect:http://localhost:8080/comMessage.html";
			}
		}
		return "chongfu";
		
	}
	//显示公司信息
	@RequestMapping("showcm.do")
	@ResponseBody
	public TtComMessageEntity showcm(HttpSession session) {
		TtComMessageEntity ttCom = new TtComMessageEntity();
		if(session.getAttribute("RId")!=null){
		ttCom.setC_cid( (Integer) session.getAttribute("RId"));
		}else if(session.getAttribute("Com")!=null){
		TtCom com =(TtCom) session.getAttribute("Com");
		ttCom.setC_cid(com.getC_cid());	
		}
		TtComMessageEntity tce = ttComService.showComMessage(ttCom);
		return tce;
	}
	
	
	//显示公司头像
		@RequestMapping("showComTou.do")
		@ResponseBody
		public TtComMessageEntity shoComTou(HttpSession session) {
			TtCom ttCom =(TtCom) session.getAttribute("Com");
			
			TtComMessageEntity tce = ttComService.shoComTou(ttCom);
			return tce;
		}
	//修改公司信息
	@RequestMapping("updatecomMessage.do")
	@ResponseBody
	public String updatecomMessage(@RequestBody TtComMessageEntity comMessageEntity, HttpSession session) {
		if (check.checkc_name(comMessageEntity.getC_name()) == false || comMessageEntity.getC_name() == "") {
			return "c_nameWorng";
		} else if (check.checkc_telon(comMessageEntity.getC_telon()) == false || comMessageEntity.getC_telon() == "") {
			return "c_telonWorng";
		} else if (check.checkc_nature(comMessageEntity.getC_nature()) == false
				|| comMessageEntity.getC_nature() == "") {
			return "c_natureWorng";
		} else if (comMessageEntity.getC_address() == "") {
			return "c_addressWorng";
		} else if (comMessageEntity.getC_scale() == 0) {
			return "c_scaleWorng";
		} else if (comMessageEntity.getC_show() == "") {
			return "c_showWorng";
		} else if (comMessageEntity.getC_email() == "") {
			return "c_emailWorng";
		}
		if(session.getAttribute("RId")!=null){
		//查询一下登录session 的id给到公司信息实体类
		comMessageEntity.setC_cid((Integer) session.getAttribute("RId"));
		}else if(session.getAttribute("Com")!=null){
			TtCom tt =(TtCom) session.getAttribute("Com");
			comMessageEntity.setC_cid(tt.getC_cid());
		}
//		//查询一下上传头像的session的mid传给公司信息的实体类
//		comMessageEntity.setC_mid((Integer) session.getAttribute("c_mid"));
		//把公司信息传到数据库里面
		ttComService.updateNewMessage(comMessageEntity);
//		//根据公司实体类里的mid(主键id)查询单个公司信息
//		TtComMessageEntity te = ttComService.findcomMessage_name(comMessageEntity);
//		//然后把单个公司信息里的主键id放入到session里
//		session.setAttribute("ComMessageId", te.getC_cid());
		return "ok";
	}
}
