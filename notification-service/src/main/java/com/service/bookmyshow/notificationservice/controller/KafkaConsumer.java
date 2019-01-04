package com.service.bookmyshow.notificationservice.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

import com.micro.authconfigservice.model.Message;


@Controller
public class KafkaConsumer {
	
	@KafkaListener(topics="notification", groupId="group_test")
	public void consumeJson(Message message) { 
		System.out.println(message.getMessage().toUpperCase());
	}
}
