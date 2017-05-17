package com.sinister.dao;

import java.util.List;

import com.sinister.entity.UserMessage;

public interface UserMessageDao {

	void saveUserMessage(UserMessage userMessage);

	void updateUserMessage(UserMessage userMessage);

	public List<UserMessage> findUserMessage(UserMessage userMessage);
	public List<UserMessage> findUserMessageTime();
}
