package com.oz.weather.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author sock.sqt@gmail.com
 * @since 1.0.0
 */
public class TemperatureUtilsTest {

  @Test
  public void kelvinToCelsiusOk() {
    Double celsiusDegrees = TemperatureUtils.kelvinToCelsius(290.0D);
    Assert.assertEquals("Error in kelvinToCelsius method.", 16.85D, celsiusDegrees, 0.1D);
  }

  @Test
  public void kelvinToCelsiusNull() {
    Double celsiusDegrees = TemperatureUtils.kelvinToCelsius(null);
    Assert.assertEquals("Error in kelvinToCelsius method.", null, celsiusDegrees);
  }

  @Test
  public void kelvinToFahrenheitOk() {
    Double fahrenheitDegrees = TemperatureUtils.kelvinToFahrenheit(290.0D);
    Assert.assertEquals("Error in kelvinToFahrenheit method.", 62.33, fahrenheitDegrees, 0.1D);
  }

  @Test
  public void kelvinToFahrenheitNull() {
    Double fahrenheitDegrees = TemperatureUtils.kelvinToFahrenheit(null);
    Assert.assertEquals("Error in kelvinToFahrenheit method.", null, fahrenheitDegrees);
  }
}
