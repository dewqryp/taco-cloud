package org.dewqryp.tacocloud.context;

import org.dewqryp.tacocloud.data.Ingredient;
import org.dewqryp.tacocloud.repositories.IngredientRepository;
import org.dewqryp.tacocloud.data.Ingredient.Type;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class TacoContext implements WebMvcConfigurer {

  @Override
    public void addViewControllers(ViewControllerRegistry  registry) {
      registry.addViewController("/").setViewName("home");
  }


}
