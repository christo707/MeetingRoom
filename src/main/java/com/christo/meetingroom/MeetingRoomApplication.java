package com.christo.meetingroom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.christo")
@EnableJpaRepositories("com.christo.repository")
@EntityScan("com.christo.entity")
public class MeetingRoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeetingRoomApplication.class, args);
	}
}
