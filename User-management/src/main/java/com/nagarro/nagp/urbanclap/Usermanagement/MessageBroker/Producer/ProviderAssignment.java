package com.nagarro.nagp.urbanclap.Usermanagement.MessageBroker.Producer;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class ProviderAssignment {

    @Autowired
    JmsTemplate jmsTemplate;

    public static final org.slf4j.Logger logger = LoggerFactory.getLogger(ProviderAssignment.class);

    public void sendMessage(final String queueName, final String message) {
        try{
            logger.info("Attempting Send message to queue: "+ queueName);
            jmsTemplate.convertAndSend(queueName, message);
        } catch(Exception e){
            logger.error("Recieved Exception during send Message: ", e);
        }
    }
}
