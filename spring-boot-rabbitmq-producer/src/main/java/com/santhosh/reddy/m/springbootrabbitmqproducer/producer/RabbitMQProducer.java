package com.santhosh.reddy.m.springbootrabbitmqproducer.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducer {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${santhosh.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${santhosh.rabbitmq.routingkey}")
	private String routingKey;
	
	private final Logger logger = LoggerFactory.getLogger(RabbitMQProducer.class);
	
	public void produceMessage(String message) {
		amqpTemplate.convertAndSend(exchange,routingKey,message);
		logger.info("Sent a message from Producer to RabbitMQ : "+message);
	}
	
}
