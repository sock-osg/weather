package com.oz.weather.utils;

import java.net.URI;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @author samuel.quintana@globant.com
 * @author sock.sqt@gmail.com
 * @since 1.0.0
 */
public class PathsBuilderTest {

  private static final String QP_ID_CITY = "id";
  private static final String QP_APP_ID = "APPID";

  private static final String BASE_URL = "http://api.openweathermap.org";
  private static final String ENDPOINT_METHOD = "/data/2.5/weather";

  private static final String EXPECTED_PATH = "http://api.openweathermap.org/data/2.5/weather?APPID=0123456789&id=5000000";

  @Test
  public void buildPathAsUriOk() {
    MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
    queryParams.add(QP_APP_ID, "0123456789");
    queryParams.add(QP_ID_CITY, "5000000");

    URI uri = PathsBuilder.buildPathAsUri(BASE_URL, ENDPOINT_METHOD, queryParams);

    Assert.assertEquals("Error with buildPathAsUri method.", EXPECTED_PATH, uri.toString());
  }
}
