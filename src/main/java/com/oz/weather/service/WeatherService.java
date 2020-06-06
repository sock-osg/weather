package com.oz.weather.service;

import com.oz.weather.controller.response.WeatherDto;
import com.oz.weather.dao.WeatherDao;
import com.oz.weather.dao.dto.WeatherResp;
import com.oz.weather.error.CityNotFoundException;

import com.oz.weather.utils.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

/**
 * WeatherService.
 * @author sock.sqt@gmail.com
 * @since 1.0.0
 */
@Service
public class WeatherService {

  private final WeatherDao openWeatherMapDao;

  /**
   * Create a new instance of the class.
   * @param openWeatherMapDao   openWeatherMapDao.
   */
  @Autowired
  public WeatherService(
      final WeatherDao openWeatherMapDao
  ) {
    super();
    this.openWeatherMapDao = openWeatherMapDao;
  }

  /**
   * get weather by city id.
   * @param cityId    cityId.
   * @return Weather information.
   */
  public WeatherDto getWeatherByCityId(final Long cityId) {
    final WeatherResp weatherResp;
    try {
      weatherResp = this.openWeatherMapDao.byCityId(cityId);
    } catch (RestClientException restClientExc) {
      final String errorMessage = String.format("Information for city %s was not found", cityId);
      throw new CityNotFoundException(errorMessage, restClientExc);
    }

    return ResponseBuilder.toDto(weatherResp);
  }
}
