package com.poc.teams.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChatResponse {

	@JsonProperty("@odata.count")
	private Long messageCount;
	
	@JsonProperty("value")
	private List<ValueResponse> value;

	public Long getMessageCount() {
		return messageCount;
	}

	public void setMessageCount(Long messageCount) {
		this.messageCount = messageCount;
	}

	public List<ValueResponse> getValue() {
		return value;
	}

	public void setValue(List<ValueResponse> value) {
		this.value = value;
	}
	
	
}
