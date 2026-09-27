package org.dewqryp.tacocloud.messaging;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;
import org.dewqryp.tacocloud.data.TacoOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class JmsOrderMessagingService implements OrderMessagingService{

    JmsTemplate jmsTemplate;
    @Autowired
    public JmsOrderMessagingService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }


    @Override
    public void sendOrder(TacoOrder order) {
       jmsTemplate.convertAndSend("tacocloud-order-queue", order, message -> {message.setStringProperty("X_ORDER_SOURCE", "WEB");
           return message;});
    }
}
