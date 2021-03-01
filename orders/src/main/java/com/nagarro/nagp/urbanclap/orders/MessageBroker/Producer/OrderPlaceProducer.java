package com.nagarro.nagp.urbanclap.orders.MessageBroker.Producer;

import com.google.gson.Gson;
import com.nagarro.nagp.urbanclap.orders.Controller.OrderController;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.Map;
import java.util.logging.Logger;

@Component
public class OrderPlaceProducer {

    @Autowired
    JmsTemplate jmsTemplate;

    public static final org.slf4j.Logger logger = LoggerFactory.getLogger(OrderController.class);

    public void sendMessage(final String queueName, final String message) {
        try{
            logger.info("Attempting Send message to queue: "+ queueName);
            jmsTemplate.convertAndSend(queueName, message);
        } catch(Exception e){
            logger.error("Recieved Exception during send Message: ", e);
        }
    }
}
