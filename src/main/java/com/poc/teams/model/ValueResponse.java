package com.poc.teams.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValueResponse {

	private String id;
	private String createdDateTime;
	private String lastUpdatedDateTime;
	private String chatType;
	@JsonProperty("mentions")
	private List<Mentions> mentions;
	private Body body;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(String createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public String getLastUpdatedDateTime() {
		return lastUpdatedDateTime;
	}

	public void setLastUpdatedDateTime(String lastUpdatedDateTime) {
		this.lastUpdatedDateTime = lastUpdatedDateTime;
	}

	public String getChatType() {
		return chatType;
	}

	public void setChatType(String chatType) {
		this.chatType = chatType;
	}

	public List<Mentions> getMentions() {
		return mentions;
	}

	public void setMentions(List<Mentions> mentions) {
		this.mentions = mentions;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

}
