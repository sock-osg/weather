package com.oz.weather.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.text.SimpleDateFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplateConfig.
 * @author sock.sqt@gmail.com
 * @since 1.0.0
 */
@Configuration
public class RestTemplateConfig {

  /**
   * Initialize Jackson2ObjectMapperBuilder.
   * @return Jackson2ObjectMapperBuilder instance.
   */
  @Bean
  public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
    builder.serializationInclusion(JsonInclude.Include.NON_NULL);
    builder.indentOutput(true).dateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm"));
    return builder;
  }

  /**
   * Initialize RestTemplate.
   * @return RestTemplate instance.
   */
  @Bean
  @Profile({ "default", "prod" })
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
