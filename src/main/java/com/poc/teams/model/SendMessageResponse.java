package com.poc.teams.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SendMessageResponse {

	@JsonProperty("id")
	private String messageId;
	private String chatId;
	public String getChatId() {
		return chatId;
	}
	public void setChatId(String chatId) {
		this.chatId = chatId;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
}
