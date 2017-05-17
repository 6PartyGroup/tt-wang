package com.sinister.service;

import java.util.List;

import com.sinister.entity.UserMessage;

public interface UserMessageService {

	void saveUserMessage(UserMessage userMessage);

	void updateUserMessage(UserMessage userMessage);

	public List<UserMessage> findUserMessage(UserMessage userMessage);

	public List<UserMessage> findUserMessageTime();

}
