package com.poc.teams.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.poc.teams.model.ChatMessagesResponse;
import com.poc.teams.model.ChatResponse;
import com.poc.teams.model.MessageRequest;
import com.poc.teams.model.SendMessageResponse;

@Component
public class ExternalAPICallUtil {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UrlUtils urlUtils;
	
	public ChatResponse fetchChatResponse(String accessToken) 
	{
		ChatResponse chatResponse = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("Authorization", "Bearer "+ accessToken);
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			ResponseEntity<ChatResponse> responseEntity = restTemplate.exchange(urlUtils.getChaturl(), HttpMethod.GET, entity, ChatResponse.class);
			chatResponse = responseEntity.getBody();
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		return chatResponse;
	}
	
	public ChatMessagesResponse fetchChatMessagesResponse(String accessToken, String chatId) 
	{
		ChatMessagesResponse chatMessagesResponse = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("Authorization", "Bearer "+ accessToken);
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			ResponseEntity<ChatMessagesResponse> responseEntity = restTemplate.exchange(urlUtils.getAllChatMessagesUrl().replace("{chatId}", chatId), 
					HttpMethod.GET, entity, ChatMessagesResponse.class);
			chatMessagesResponse = responseEntity.getBody();
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		return chatMessagesResponse;
	}
	
	public SendMessageResponse sendMessage(MessageRequest messageRequest, String accessToken, String chatId) 
	{
		SendMessageResponse sendMessageResponse = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("Authorization", "Bearer "+ accessToken);
			HttpEntity<MessageRequest> entity = new HttpEntity<MessageRequest>(messageRequest, headers);
			ResponseEntity<SendMessageResponse> responseEntity = restTemplate.exchange(urlUtils.getAllChatMessagesUrl().replace("{chatId}", chatId), 
					HttpMethod.POST, entity, SendMessageResponse.class);
			sendMessageResponse = responseEntity.getBody();
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		return sendMessageResponse;
	}
	
}
