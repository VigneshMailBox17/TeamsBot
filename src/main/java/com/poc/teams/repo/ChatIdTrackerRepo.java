package com.poc.teams.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.teams.entity.ChatIdTrackerEntity;

@Repository
public interface ChatIdTrackerRepo extends JpaRepository<ChatIdTrackerEntity, Long> {

	ChatIdTrackerEntity findByMessageId(String messageId);
}
