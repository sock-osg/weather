package com.oz.weather.utils;

import com.oz.weather.controller.response.WeatherDto;
import com.oz.weather.dao.dto.WeatherResp;

import java.util.Date;

/**
 * ResponseBuilder.
 * @author sock.sqt@gmail.com
 * @since 1.0.0
 */
public class ResponseBuilder {

  private static final Long EPOCH = 1000L;
  private static final int INDEX_ZERO = 0;

  private ResponseBuilder() {
    super();
  }

  /**
   * Convert dao response to dto one.
   * @param weatherResp   Dao response.
   * @return Sto response.
   */
  public static WeatherDto toDto(WeatherResp weatherResp) {
    WeatherDto weatherDto = new WeatherDto();

    weatherDto.setCityName(weatherResp.getName());
    weatherDto.setDate(new Date(weatherResp.getDatetime() * EPOCH));
    weatherDto.setDescription(weatherResp.getWeather().get(INDEX_ZERO).getDescription());
    weatherDto.setSunrise(new Date(weatherResp.getSystem().getSunrise() * EPOCH));
    weatherDto.setSunset(new Date(weatherResp.getSystem().getSunset() * EPOCH));
    weatherDto.setTemperatureFahrenheit(TemperatureUtils.kelvinToFahrenheit(weatherResp.getMain().getTemp()));
    weatherDto.setTemperatureCelsius(TemperatureUtils.kelvinToCelsius(weatherResp.getMain().getTemp()));

    return weatherDto;
  }
}
