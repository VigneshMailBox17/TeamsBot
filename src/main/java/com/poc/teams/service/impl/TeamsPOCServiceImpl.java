package com.poc.teams.service.impl;

import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2RefreshToken;
import org.springframework.stereotype.Service;

import com.poc.teams.entity.ChatIdTrackerEntity;
import com.poc.teams.model.Body;
import com.poc.teams.model.ChatMessagesResponse;
import com.poc.teams.model.ChatResponse;
import com.poc.teams.model.Mentions;
import com.poc.teams.model.MessageRequest;
import com.poc.teams.model.ValueResponse;
import com.poc.teams.repo.ChatIdTrackerRepo;
import com.poc.teams.service.TeamsPOCService;
import com.poc.teams.utility.ExternalAPICallUtil;

@Service
public class TeamsPOCServiceImpl implements TeamsPOCService {

	@Autowired
	private ChatIdTrackerRepo chatIdTrackerRepo;
	@Autowired
	private ExternalAPICallUtil externalAPICallUtil;
	private String jwtToken;
	boolean isFirstTimeExecution = true;

	@Override
	public void createOAuthToken(OAuth2AuthorizedClient authorizedClient) {
		OAuth2RefreshToken oAuth2RefreshToken = authorizedClient.getRefreshToken();
		OAuth2AccessToken accessToken = authorizedClient.getAccessToken();
		jwtToken = accessToken.getTokenValue();
		System.out.println("Access :" + accessToken.getTokenValue() + " : " + accessToken.getExpiresAt());
		System.out
				.println("Refresh :" + oAuth2RefreshToken.getTokenValue() + " : " + oAuth2RefreshToken.getExpiresAt());
	}

	@Override
	public void monitorAllChat() {
		if (null != jwtToken) {
			ChatResponse chatResponse = externalAPICallUtil.fetchChatResponse(jwtToken);
			chatResponse.getMessageCount();
		}
	}

	private void sendMessages(String chatId, String message) {
		MessageRequest request = new MessageRequest();
		Body body = new Body();
		body.setContent("Please find the logs for the message : " + message + " Logs: Failed due to DB connectivity");
		request.setBody(body);
		externalAPICallUtil.sendMessage(request, jwtToken, chatId);
	}

	@Override
	public void monitorAllMessagesInChat() {
		if (null != jwtToken) {
			String chatId = "19:8489886eb6a24d0b83a99dfc431a1071@thread.v2";
			ChatMessagesResponse response = externalAPICallUtil.fetchChatMessagesResponse(jwtToken, chatId);
				for (ValueResponse valueResponse : response.getValue()) {
					if (null != valueResponse.getMentions()) {
						for (Mentions mentions : valueResponse.getMentions()) {
							if ("Vignesh".equalsIgnoreCase(mentions.getMentionText())) {
								if (null == chatIdTrackerRepo.findByMessageId(valueResponse.getId())) {
									System.out.println(valueResponse.getId());
									System.out.println(valueResponse.getBody());
									sendMessages(chatId, html2text(valueResponse.getBody().getContent()));
									ChatIdTrackerEntity entity = new ChatIdTrackerEntity();
									entity.setMessageId(valueResponse.getId());
									chatIdTrackerRepo.save(entity);
								}
							}
						}
					}
				}
			}
		}
	public String html2text(String html) {
	    return Jsoup.parse(html).text();
	}
}
