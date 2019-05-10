package com.oz.weather.controller.response;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * WeatherDto.
 * @author sock.sqt@gmail.com
 * @since 1.0.0
 */
@Setter
@Getter
public class WeatherDto implements java.io.Serializable {

  private static final long serialVersionUID = 1464193375224757242L;

  private Date date;
  private String cityName;
  private String description;
  private Double temperatureCelsius;
  private Double temperatureFahrenheit;
  private Date sunrise;
  private Date sunset;
}
