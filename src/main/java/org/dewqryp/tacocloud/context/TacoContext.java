package org.dewqryp.tacocloud.context;

import jakarta.jms.Destination;
import org.apache.activemq.artemis.jms.client.ActiveMQQueue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class TacoContext implements WebMvcConfigurer {

  @Override
    public void addViewControllers(ViewControllerRegistry  registry) {
      registry.addViewController("/").setViewName("home");
      registry.addViewController("/login");
  }



}
