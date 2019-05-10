package com.oz.weather.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oz.weather.dao.dto.WeatherResp;
import com.oz.weather.utils.PathsBuilder;
import org.junit.Before;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.Resource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;

/**
 * @author sock.sqt@gmail.com
 * @since 1.0.0
 */
public abstract class InitTest {

  private static final String QP_ID_CITY = "id";
  private static final String QP_APP_ID = "APPID";

  @Value("${openWeatherMap.applicationId}")
  private String applicationId;
  @Value("${app.externalServices.rest.openWeatherMap.baseUrl}")
  private String baseUrl;
  @Value("${app.externalServices.rest.openWeatherMap.getWeatherByIdPath}")
  private String getWeatherByIdPath;

  @Autowired
  private ObjectMapper objectMapper;

  @Value("classpath:json/owm-get-by-id-ok.json")
  private Resource getByIdOkJson;

  @MockBean
  private RestTemplate mockRestTemplate;

  @Before
  public void init() throws IOException {
    WeatherResp getByIdOkResponse = this.objectMapper.readValue(getByIdOkJson.getFile(), WeatherResp.class);

    MultiValueMap<String, String> queryParamsOk = new LinkedMultiValueMap<>();
    queryParamsOk.add(QP_APP_ID, this.applicationId);
    queryParamsOk.add(QP_ID_CITY, "3996063");

    URI uriOk = PathsBuilder.buildPathAsUri(this.baseUrl, this.getWeatherByIdPath, queryParamsOk);

    Mockito.when(this.mockRestTemplate.getForObject(uriOk, WeatherResp.class)).thenReturn(getByIdOkResponse);

    MultiValueMap<String, String> queryParamsNotFound = new LinkedMultiValueMap<>();
    queryParamsNotFound.add(QP_APP_ID, this.applicationId);
    queryParamsNotFound.add(QP_ID_CITY, "123456789");

    URI uriNotFound = PathsBuilder.buildPathAsUri(this.baseUrl, this.getWeatherByIdPath, queryParamsNotFound);

    Mockito.when(this.mockRestTemplate.getForObject(uriNotFound, WeatherResp.class)).thenThrow(new RestClientException("Not Found"));
  }
}
