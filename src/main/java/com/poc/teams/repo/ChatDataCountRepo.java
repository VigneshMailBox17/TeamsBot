package com.poc.teams.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.teams.entity.ChatDataCountEntity;

@Repository
public interface ChatDataCountRepo extends JpaRepository<ChatDataCountEntity, Long> {

	ChatDataCountEntity findByChatId(String chatId);
}
