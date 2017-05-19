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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
<<<<<<< HEAD
			
		//Ĭ��ͷ���ַ
=======

		// morentouxiang
>>>>>>> branch 'dev' of git@github.com:6PartyGroup/tt-wang.git
		userMessage.setLogo("dddd/");
<<<<<<< HEAD
		
		// �����޸�ʱ��
=======

		// shijian
>>>>>>> branch 'dev' of git@github.com:6PartyGroup/tt-wang.git
		Date date = new Date(System.currentTimeMillis());
		userMessage.setTime(date);

<<<<<<< HEAD
		// ����״̬ 0Ϊ�ܱ��鵽 1Ϊ���ܱ��鵽
=======
		// zhuangtai
>>>>>>> branch 'dev' of git@github.com:6PartyGroup/tt-wang.git
		userMessage.setStatus(0);

<<<<<<< HEAD
		// user���
=======
		// user waijian
>>>>>>> branch 'dev' of git@github.com:6PartyGroup/tt-wang.git
		Integer uid = (Integer) session.getAttribute("uid");
		User user = new User();
		user.setUid(uid);
		userMessage.setUser(user);
		userMessageService.saveUserMessage(userMessage);

		return "success";
	}

	@RequestMapping(value = "updatetopfile.do", method = RequestMethod.POST)
	public String updateUserMessageTopFile(@RequestParam("file") MultipartFile file, HttpServletRequest request)
			throws IOException {
		if (!file.isEmpty()) {
			FileUtils.copyInputStreamToFile(file.getInputStream(),
					new File("C:\\Users\\Shinelon\\Desktop\\topfile", file.getOriginalFilename()));
		}
		String filename = file.getOriginalFilename();
		HttpSession session = request.getSession();
		Integer uid = (Integer) session.getAttribute("uid");
		UserMessage userMessage = userMessageService.findMessageByUid(uid);
		String fn = userMessage.getLogo();
		if (filename == "") {
			userMessage.setLogo(fn);
		} else {
			userMessage.setLogo("/dddd/" + filename);
		}
		Integer mid = (Integer) session.getAttribute("mid");
		userMessage.setMid(mid);
		userMessageService.updateUserMessage(userMessage);
		return "login";

	}

	@RequestMapping("findMessageByUid.do")
	@ResponseBody
	public UserMessage findMessageByUid(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Integer uid = (Integer) session.getAttribute("uid");
		UserMessage userMessage = userMessageService.findMessageByUid(uid);
		session.setAttribute("mid", userMessage.getMid());
		return userMessage;
	}

	@RequestMapping("updateUserMessage.do")
	@ResponseBody
	public String updateUserMessage(@RequestBody UserMessage userMessage, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Integer mid = (Integer) session.getAttribute("mid");
		userMessage.setMid(mid);
		userMessageService.updateUserMessage(userMessage);
		return "success";
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
		System.out.println(usermessage.getWorkyear());
		System.out.println(usermessage.getMoney());
		System.out.println(usermessage.getAge());
		System.out.println(usermessage.getStatus());
		System.out.println(usermessage.getSex());
		System.out.println(usermessage.getEdu());
		List<UserMessage> list = userMessageService.findUserMessage(m);

		System.out.println(list.size() == 0);

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
