package com.sinister.dao;

import java.util.List;
import java.util.Map;

import com.sinister.entity.UserMessage;

public interface UserMessageDao {

	void saveUserMessage(UserMessage userMessage);

	void updateUserMessage(UserMessage userMessage);

	// 分页查询
	public List<UserMessage> findUserMessage(Map<String, Object> map);

	public int findUserMessageCount(UserMessage userMessage);

	// public List<UserMessage> findUserMessage(UserMessage userMessage);
	public List<UserMessage> findUserMessageTime();

	UserMessage findUserMessageById(Integer uid);

	UserMessage findUserMessageByUid(Integer uid);
	//90 add mthod to find people message
	public List<UserMessage> jlSeePeople(int u_mid);//UserMessageDao
	
	
	
	
	
	
}
