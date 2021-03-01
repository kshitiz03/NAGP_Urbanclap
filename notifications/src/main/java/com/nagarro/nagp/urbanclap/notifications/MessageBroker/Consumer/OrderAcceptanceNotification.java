package com.nagarro.nagp.urbanclap.notifications.MessageBroker.Consumer;

import com.nagarro.nagp.urbanclap.notifications.Domain.Request.OrderEmailRequest;
import com.nagarro.nagp.urbanclap.notifications.Service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;

import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.Arrays;

public class OrderAcceptanceNotification implements MessageListener {
    public static final Logger logger = LoggerFactory.getLogger(OrderAssignmentNotification.class);

    @Autowired
    NotificationService notificationService;

    @JmsListener(destination = "order_accept_notification_queue")
    public void onMessage(Message emailIdList) {
        try{
            OrderEmailRequest orderEmailRequest = new OrderEmailRequest();

            orderEmailRequest.setEmailIdList(Arrays.asList("kr@gmail.com"));
            String message1 = "Hi \n Your order has been accepted by "+ orderEmailRequest.getEmailIdList().get(0);
            String subject = "Order Accepted urbanclap";
            notificationService.sendOrderDecisionEmail(orderEmailRequest,subject,message1);

        } catch(Exception e) {
            logger.error("Received Exception : "+ e);
        }

    }
}
