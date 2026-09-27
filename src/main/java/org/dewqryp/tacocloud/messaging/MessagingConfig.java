package org.dewqryp.tacocloud.messaging;

import jakarta.jms.Destination;
import jakarta.jms.Queue;
import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.dewqryp.tacocloud.data.TacoOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.JacksonJsonMessageConverter;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MessagingConfig {

    @Bean
    public Destination orderQueue() {
        return new ActiveMQQueue("tacocloud-order-queue");
    }

    @Bean
    public JacksonJsonMessageConverter jacksonJsonMessageConverter() {
        JacksonJsonMessageConverter converter = new JacksonJsonMessageConverter();
        converter.setTypeIdPropertyName("_typeId");
        Map<String, Class<?>> map = new HashMap();
        map.put("order", TacoOrder.class);
        converter.setTypeIdMappings(map);
        return converter;

    }
}
