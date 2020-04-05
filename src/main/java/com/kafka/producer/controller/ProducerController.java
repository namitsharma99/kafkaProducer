package com.kafka.producer.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.producer.service.ProducerService;

@RestController
public class ProducerController {

	@Autowired
	ProducerService producerService;

	@GetMapping("/kafkaProducerStatus")
	public String status() {
		return "kafkaProducerStatus Up and Running on :: " + new Date();
	}

	@GetMapping("/sendMessage")
	public String trigger(@RequestParam("message") String message) {
		producerService.sendMessage(message);
		return "Message sent to topic - KAFKA_TEST";
	}

}
