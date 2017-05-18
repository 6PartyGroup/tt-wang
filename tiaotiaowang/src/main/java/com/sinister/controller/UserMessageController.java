package com.sinister.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinister.entity.ModelUserMessage;
import com.sinister.entity.Page;
import com.sinister.entity.UserMessage;
import com.sinister.service.UserMessageService;

@Controller
public class UserMessageController {

	@Autowired
	private UserMessageService userMessageService;

	@RequestMapping("saveUserMessage")
	@ResponseBody
	public String saveUserMessage(@RequestBody UserMessage userMessage) {

		userMessageService.saveUserMessage(userMessage);

		return null;
	}

	@RequestMapping("updateUserMessage")
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

		System.out.println(list.size() == 0);
		System.out.println(list);

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
