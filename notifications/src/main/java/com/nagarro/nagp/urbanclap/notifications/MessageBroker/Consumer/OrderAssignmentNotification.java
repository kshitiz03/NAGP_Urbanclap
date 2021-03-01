package com.nagarro.nagp.urbanclap.notifications.MessageBroker.Consumer;

import com.nagarro.nagp.urbanclap.notifications.Domain.Request.OrderEmailRequest;
import com.nagarro.nagp.urbanclap.notifications.Service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.util.Arrays;
import java.util.List;

public class OrderAssignmentNotification implements MessageListener {
    public static final Logger logger = LoggerFactory.getLogger(OrderAssignmentNotification.class);

    @Autowired
    NotificationService notificationService;

    @JmsListener(destination = "order_place_queue")
    public void onMessage(Message emailIdList) {
        try{
            String message1 = "Hi \n We have a job service for you. Please go to the app to check order details and confirm about your service";
            String subject = "Accept/Deny order";
            OrderEmailRequest orderEmailRequest = new OrderEmailRequest();

            orderEmailRequest.setEmailIdList(Arrays.asList("kr@gmail.com"));
            notificationService.sendOrderDecisionEmail(orderEmailRequest,subject,message1);

        } catch(Exception e) {
            logger.error("Received Exception : "+ e);
        }

    }

}
