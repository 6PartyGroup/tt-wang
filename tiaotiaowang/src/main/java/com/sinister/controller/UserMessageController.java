package com.sinister.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping(value="findUserMessage.do" ,method=RequestMethod.POST)
	@ResponseBody
	public List<UserMessage> findUserMessage(@RequestBody UserMessage usermessage){
	
		return userMessageService.findUserMessage(usermessage);
		
	}

}
