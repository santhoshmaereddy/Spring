package com.santhosh.reddy.m.springbootrabbitmqconsumer.config;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.santhosh.reddy.m.springbootrabbitmqconsumer.consumer.RabbitMQConsumer;

@Configuration
public class RabbitMQConsumerConfig {
	
	@Value("${santhosh.rabbitmq.queue}")
	String queueName;
	
	@Value("${santhosh.rabbitmq.exchange}")
	String exchange;
	
	@Value("${santhosh.rabbitmq.routingkey}")
	String routingKey;
	
	
	@Bean
	@Autowired
	public SimpleMessageListenerContainer masterQueueListenerContainer(ConnectionFactory connection, RabbitMQConsumer listenerMaster) {
		SimpleMessageListenerContainer factory = new SimpleMessageListenerContainer();
//		factory.setConcurrentConsumers(10);
		factory.setConnectionFactory(connection);
		factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
		factory.setMessageListener(listenerMaster);
		factory.setQueueNames(queueName);
		return factory;
	} 
	
	/*@Bean
	Queue queue() {
		return new Queue(queueName,true);
	}
	
	@Bean
	DirectExchange exchange() {
		return new DirectExchange(exchange);
	}
	
	
	@Bean
	Binding binding(Queue queue, DirectExchange directExchange) {
		return BindingBuilder.bind(queue).to(directExchange).with(routingKey);
	}
	
	
	@Bean
	public MessageConverter jsonMessageConvertor() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public RabbitMQConsumer eventConsumer() {
		return new RabbitMQConsumer();
	}
	
	public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jsonMessageConvertor());
		return rabbitTemplate;		
	}*/
}
