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
		comMessageEntity.setC_cid((Integer) session.getAttribute("RId"));
		comMessageEntity.setC_mid((Integer) session.getAttribute("c_mid"));
		ttComService.saveComMessage(comMessageEntity);
		TtComMessageEntity te = ttComService.findcomMessage_name(comMessageEntity);
		session.setAttribute("ComMessageId", te.getC_cid());
		return "ok";

	}

	// 上传头像
	@RequestMapping("fileupdata.do")
	@ResponseBody
	public String fileupdata(@RequestParam("file") MultipartFile file,HttpSession session) throws IOException {
		if (!file.isEmpty()) {// 文件不能为空
			FileUtils.copyInputStreamToFile(file.getInputStream(),
					new File("/users/zhaoce/Desktop", file.getOriginalFilename()));
		}
		String path = "/users/zhaoce/Desktop/"+file.getOriginalFilename();
		TtComMessageEntity CME = new TtComMessageEntity();
		CME.setC_logo(path);
//		CME.setC_cid((Integer) session.getAttribute("ComMessageId"));
		ttComService.saveComMessagefile(CME);
		TtComMessageEntity tcm= ttComService.findcomMessage_logo(CME);
		session.setAttribute("c_mid", tcm.getC_mid());
		return "ok";

	}
}
