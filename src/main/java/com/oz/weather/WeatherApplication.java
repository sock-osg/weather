package com.oz.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableCircuitBreaker
@EnableHystrixDashboard
@SpringBootApplication
public class WeatherApplication {

  /**
   * Main method.
   * @param args    args.
   */
  public static void main(String[] args) {
    SpringApplication.run(WeatherApplication.class, args);
  }
}
