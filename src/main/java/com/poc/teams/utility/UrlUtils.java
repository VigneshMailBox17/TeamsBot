package com.poc.teams.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UrlUtils {

	@Value("${url.chat}")
	private String chaturl;
	
	@Value("${url.chatMessage}")
	private String allChatMessagesUrl;

	public String getChaturl() {
		return chaturl;
	}

	public void setChaturl(String chaturl) {
		this.chaturl = chaturl;
	}

	public String getAllChatMessagesUrl() {
		return allChatMessagesUrl;
	}

	public void setAllChatMessagesUrl(String allChatMessagesUrl) {
		this.allChatMessagesUrl = allChatMessagesUrl;
	}
}
