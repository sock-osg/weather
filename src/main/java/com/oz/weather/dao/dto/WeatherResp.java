package com.oz.weather.dao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * WeatherResp.
 * @author sock.sqt@gmail.com
 * @since 1.0.0
 */
@Setter
@Getter
public class WeatherResp {

  private List<Weather> weather;
  private Main main;
  @JsonProperty("sys")
  private System system;
  @JsonProperty("dt")
  private Long datetime;
  private String name;

  @Setter
  @Getter
  public static class Weather {

    private String description;
  }

  @Setter
  @Getter
  public static class Main {

    private Double temp;
  }

  @Setter
  @Getter
  public static class System {

    private Long sunrise;
    private Long sunset;
  }
}
