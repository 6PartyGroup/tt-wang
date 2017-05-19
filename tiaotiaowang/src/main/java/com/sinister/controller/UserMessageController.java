package com.sinister.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sinister.entity.ModelUserMessage;
import com.sinister.entity.Page;
import com.sinister.entity.User;
import com.sinister.entity.UserMessage;
import com.sinister.service.UserMessageService;

@Controller
public class UserMessageController {

	@Autowired
	private UserMessageService userMessageService;

	@RequestMapping("saveUserMessage.do")
	@ResponseBody
	public String saveUserMessage(@RequestBody UserMessage userMessage, HttpServletRequest request) {

		HttpSession session = request.getSession();
			
		//Ĭ��ͷ���ַ
		userMessage.setLogo("dddd/");
		
		// �����޸�ʱ��
		Date date = new Date(System.currentTimeMillis());
		userMessage.setTime(date);

		// ����״̬ 0Ϊ�ܱ��鵽 1Ϊ���ܱ��鵽
		userMessage.setStatus(0);

		// user���
		Integer uid = (Integer) session.getAttribute("uid");
		User user = new User();
		user.setUid(uid);
		userMessage.setUser(user);
		userMessageService.saveUserMessage(userMessage);

		return null;
	}

	@RequestMapping("updateUserMessageTopFile.do")
	public String updateUserMessageTopFile(@RequestParam("file") MultipartFile file, HttpServletRequest request)
			throws IOException {
		if (!file.isEmpty()) {
			FileUtils.copyInputStreamToFile(file.getInputStream(),
					new File("C:\\Users\\sunlei\\Desktop\\topfile\\", file.getOriginalFilename()));
		}
		String filename = file.getOriginalFilename();
		HttpSession session = request.getSession();
		Integer uid = (Integer) session.getAttribute("uid");
		UserMessage userMessage = userMessageService.findUserMessageById(uid);
		String fn = userMessage.getLogo();
		if (filename == "") {
			userMessage.setLogo(fn);
		} else {
			userMessage.setLogo("/dddd/" + filename);
		}
		userMessageService.updateUserMessage(userMessage);
		return "index";

	}

	@RequestMapping("updateUserMessage.do")
	public String updateUserMessage(@RequestBody UserMessage userMessage) {
		userMessageService.updateUserMessage(userMessage);
		return null;
	}

	@RequestMapping(value = "findUserMessage.do", method = RequestMethod.POST)
	@ResponseBody
	public ModelUserMessage findUserMessage(@RequestBody UserMessage usermessage) {

		Page page = new Page();
		page.setCurrentPage(usermessage.getMid());
		page.setTotalNumber(userMessageService.findUserMessageCount(usermessage));
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("page", page);
		m.put("userMessage", usermessage);
	
		List<UserMessage> list = userMessageService.findUserMessage(m);

	

		if (list.size() != 0) {
			ModelUserMessage model = new ModelUserMessage();
			model.setPage(page);
			model.setUserMessage(list);
			return model;
		}
		return null;

	}

	@RequestMapping(value = "findUserMessageTime.do", method = RequestMethod.POST)
	@ResponseBody
	public List<UserMessage> findUserMessageTime() {
		return userMessageService.findUserMessageTime();
	}
}
