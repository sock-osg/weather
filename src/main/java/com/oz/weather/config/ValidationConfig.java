package com.oz.weather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.SmartValidator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * ValidationConfig.
 * @author sock.sqt@gmail.com
 * @since 1.0.0
 */
@Configuration
public class ValidationConfig {

  /**
   * Smart validator instance.
   * @return SmartValidator.
   */
  @Bean
  public SmartValidator validator() {
    return new LocalValidatorFactoryBean();
  }
}
