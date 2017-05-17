package com.sinister.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinister.dao.UserMessageDao;
import com.sinister.entity.UserMessage;
import com.sinister.service.UserMessageService;

@Service
public class UserMessageServiceImpl implements UserMessageService {
	@Autowired
	private UserMessageDao userMessageDao;

	public void saveUserMessage(UserMessage userMessage) {
		userMessageDao.saveUserMessage(userMessage);
	}

	public void updateUserMessage(UserMessage userMessage) {
		userMessageDao.updateUserMessage(userMessage);
	}

	public List<UserMessage> findUserMessage(UserMessage userMessage) {
		return userMessageDao.findUserMessage(userMessage);
	}

	public List<UserMessage> findUserMessageTime() {
		return userMessageDao.findUserMessageTime();
	}

}
