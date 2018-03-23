package com.santhosh.reddy.m.springbootrabbitmqconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

	final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);
	
	@RabbitListener(queues="${santhosh.rabbitmq.queue}")
	public void receiveMessage(String message) {
		
		try {
			logger.info("======>>>>>>>> Received Message in Consumer {} ",message);
			Thread.sleep(10000);
		} catch (Exception e) {
		}
		
	}
	
}
