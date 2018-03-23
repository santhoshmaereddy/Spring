package com.santhosh.reddy.m.springbootrabbitmqproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santhosh.reddy.m.springbootrabbitmqproducer.producer.RabbitMQProducer;

@RestController
public class Controller {

	@Autowired
	RabbitMQProducer producer;
	
	@RequestMapping(value="/send")
	public String sendMessageToRabbitMQ(@RequestParam("message") String message) {
		producer.produceMessage(message);
		return "Done";
	}
	
}
