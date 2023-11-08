package com.poc.teams.scheduler;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.poc.teams.service.TeamsPOCService;

@Component
public class BotScheduler {

	@Autowired
	private TeamsPOCService pocService;
	
	//@Scheduled(cron= "0/5 * * ? * *")
	public void monitorAllChat() {
		pocService.monitorAllChat();
		System.out.println("Current time is :: " + LocalDate.now());
	}
	
	@Scheduled(fixedDelay=5000)
	public void monitorAllMessages() {
		pocService.monitorAllMessagesInChat();
		System.out.println("Current time is :: " + LocalDate.now());
	}
}
