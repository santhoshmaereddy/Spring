package com.santhosh.reddy.m.springbootrabbitmqconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;

@Component
public class RabbitMQConsumer implements ChannelAwareMessageListener{

	final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);

	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		long deliveryTag = message.getMessageProperties().getDeliveryTag();
		try {
			
			String data = new String(message.getBody(),"UTF-8");
			logger.info("Data {} ",data);
			// Processed successfully
			channel.basicAck(deliveryTag, false);
		} catch (Exception e) {
			// Reject is to Queue it back
			// true -> keep the entry at same location 
			// false -> push this entry to end of queue
			channel.basicReject(deliveryTag, true);
		}
	}
	
	/*@RabbitListener(queues="${santhosh.rabbitmq.queue}")
	public void receiveMessage(String message) {
		
		try {
			logger.info("======>>>>>>>> Received Message in Consumer {} ",message);
			Thread.sleep(10000);
		} catch (Exception e) {
		}
		
	}*/
	
}
