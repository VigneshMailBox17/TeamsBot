// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.poc.teams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@EnableScheduling
@SpringBootApplication
public class TeamsBotAppSpringBootWebappApplication {
	public static void main(String[] args) {
		SpringApplication.run(TeamsBotAppSpringBootWebappApplication.class, args);
	}

    @Bean
    RestTemplate restTemplate() {
		return new RestTemplate();
	}
}