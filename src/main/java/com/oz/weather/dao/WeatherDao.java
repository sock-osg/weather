package com.oz.weather.dao;

import com.oz.weather.dao.dto.WeatherResp;

/**
 * WeatherDao.
 * @author sock.sqt@gmail.com
 * @since 1.0.0
 */
public interface WeatherDao {

  /**
   * Get weather information by city id.
   * @param cityId    cityId.
   * @return Weather information.
   */
  WeatherResp byCityId(Long cityId);
}
