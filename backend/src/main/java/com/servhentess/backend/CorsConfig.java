package com.servhentess.backend;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.*;

@org.springframework.context.annotation.Configuration
public class CorsConfig {
  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @SuppressWarnings("null")
    @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:5173", "http://localhost:8081")
                .allowedMethods("*");
      }
    };
  }
}
