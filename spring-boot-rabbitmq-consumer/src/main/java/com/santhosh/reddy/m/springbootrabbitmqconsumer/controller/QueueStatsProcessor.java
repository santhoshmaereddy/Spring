package com.santhosh.reddy.m.springbootrabbitmqconsumer.controller;

import java.util.List;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueueStatsProcessor {

	/*@Autowired
    private RabbitAdmin admin;*/
    @Autowired
    private List<Queue> rabbitQueues;

    @RequestMapping(value="/getQueueStatsProcessor")
    public String getCounts(){
    	String queueStats = "";
        try {/*
			Properties props;
			Integer messageCount;
			for(Queue queue : rabbitQueues){
			    props = admin.getQueueProperties(queue.getName());
			    messageCount = Integer.parseInt(props.get("QUEUE_MESSAGE_COUNT").toString());
			    System.out.println(queue.getName() + " has " + messageCount + " messages");
			    queueStats += queue.getName() + " has " + messageCount + " messages";
			}
		*/} catch (NumberFormatException e) {
			e.printStackTrace();
		}
        return queueStats;
    }
    
}
