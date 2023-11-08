package com.poc.teams.service;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;

public interface TeamsPOCService {

	void createOAuthToken(OAuth2AuthorizedClient authorizedClient);
	
	void monitorAllChat();

	void monitorAllMessagesInChat();
}
