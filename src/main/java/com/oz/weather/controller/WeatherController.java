package com.oz.weather.controller;

import com.oz.weather.controller.response.WeatherDto;
import com.oz.weather.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * WeatherController.
 * @author sock.sqt@gmail.com
 * @since 1.0.0
 */
@RestController
@Api(tags = "weather")
@RequestMapping("/weather")
public class WeatherController {

  private final WeatherService weatherService;

  /**
   * Create a new instance of the class.
   * @param weatherService    weatherService.
   */
  @Autowired
  public WeatherController(
      WeatherService weatherService
  ) {
    super();
    this.weatherService = weatherService;
  }

  /**
   * get weather by city id.
   * @param cityId    cityId.
   * @return Weather information.
   */
  @GetMapping(value = "/{cityId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ApiOperation(value = "Retrieves weather information for specific city id.",
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ApiImplicitParams({
      @ApiImplicitParam(name = "cityId", value = "City ID", dataType = "int", paramType = "path", required = true,
          example = "1819729"),
      })
  @ResponseStatus(HttpStatus.OK)
  public WeatherDto getWeatherByCityId(@PathVariable("cityId") Long cityId) {
    return this.weatherService.getWeatherByCityId(cityId);
  }
}
