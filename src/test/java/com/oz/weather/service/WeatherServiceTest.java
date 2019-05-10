package com.oz.weather.service;

import com.oz.weather.controller.response.WeatherDto;
import com.oz.weather.error.CityNotFoundException;
import com.oz.weather.test.InitTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author sock.sqt@gmail.com
 * @since 1.0.0
 */
@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class WeatherServiceTest extends InitTest {

  @Autowired
  private WeatherService weatherService;

  @Test
  public void getWeatherByCityIdOk() {
    WeatherDto weatherByCityId = this.weatherService.getWeatherByCityId(3996063L);

    Assert.assertNotNull("Error processing weather in service.", weatherByCityId);
  }

  @Test(expected = CityNotFoundException.class)
  public void getWeatherByCityIdFail() {
    this.weatherService.getWeatherByCityId(123456789L);
  }
}
