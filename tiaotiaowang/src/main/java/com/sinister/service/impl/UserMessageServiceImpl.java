package com.sinister.service.impl;

import java.util.List;
import java.util.Map;

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

	// public List<UserMessage> findUserMessage(UserMessage userMessage) {
	// return userMessageDao.findUserMessage(userMessage);
	// }

	public List<UserMessage> findUserMessageTime() {
		return userMessageDao.findUserMessageTime();
	}

	public List<UserMessage> findUserMessage(Map<String, Object> map) {

		return userMessageDao.findUserMessage(map);
	}

	public int findUserMessageCount(UserMessage userMessage) {
		
		return userMessageDao.findUserMessageCount(userMessage);
	}

	public UserMessage findUserMessageById(Integer uid) {
		return userMessageDao.findUserMessageById(uid);
	}

	public UserMessage findMessageByUid(Integer uid) {
		return userMessageDao.findUserMessageByUid(uid);
	}

	public List<UserMessage> findAllUserMessage() {
		return userMessageDao.findAllUserMessage();
	}

}
