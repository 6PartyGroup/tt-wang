package com.sinister.entity;

import java.util.List;

public class ModelUserMessage {

	private Page page;
	private List<UserMessage> userMessage;
	
	
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<UserMessage> getUserMessage() {
		return userMessage;
	}
	public void setUserMessage(List<UserMessage> userMessage) {
		this.userMessage = userMessage;
	}

	
}
