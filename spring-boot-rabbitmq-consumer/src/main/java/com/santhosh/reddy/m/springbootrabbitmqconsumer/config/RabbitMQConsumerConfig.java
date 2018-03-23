package com.santhosh.reddy.m.springbootrabbitmqconsumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
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
	
	/*public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jsonMessageConvertor());
		return rabbitTemplate;		
	}*/
}
