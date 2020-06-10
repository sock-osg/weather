package com.oz.weather.dao;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.oz.weather.dao.dto.WeatherResp;
import com.oz.weather.utils.PathsBuilder;

import java.net.URI;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * OpenWeatherMapDao.
 * @author sock.sqt@gmail.com
 * @since 1.0.0
 */
@Component
public class OpenWeatherMapDao implements WeatherDao {

  private final String applicationId;

  private final String baseUrl;
  private final String getWeatherByIdPath;

  private static final String QP_ID_CITY = "id";
  private static final String QP_APP_ID = "APPID";

  private final RestTemplate restTemplate;

  /**
   * Create a new instance of the class.
   * @param applicationId   applicationId.
   * @param restTemplate    restTemplate.
   */
  @Autowired
  public OpenWeatherMapDao(
      @Value("${openWeatherMap.applicationId}") final String applicationId,
      @Value("${app.externalServices.rest.openWeatherMap.baseUrl}") final String baseUrl,
      @Value("${app.externalServices.rest.openWeatherMap.getWeatherByIdPath}") final String getWeatherByIdPath,
      RestTemplate restTemplate
  ) {
    super();
    this.applicationId = applicationId;
    this.baseUrl = baseUrl;
    this.getWeatherByIdPath = getWeatherByIdPath;
    this.restTemplate = restTemplate;
  }

  @HystrixCommand
  @Override
  public WeatherResp byCityId(@NotNull final Long cityId) {
    MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
    queryParams.add(QP_APP_ID, this.applicationId);
    queryParams.add(QP_ID_CITY, cityId.toString());

    URI uri = PathsBuilder.buildPathAsUri(this.baseUrl, this.getWeatherByIdPath, queryParams);

    return this.restTemplate.getForObject(uri, WeatherResp.class);
  }
}
