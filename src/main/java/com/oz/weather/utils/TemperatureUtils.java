package com.oz.weather.utils;

import java.util.Objects;

/**
 * TemperatureUtils.
 * @author sock.sqt@gmail.com
 * @since 1.0.0
 */
public class TemperatureUtils {

  private TemperatureUtils() {
    super();
  }

  /**
   * Convert Kelvin degrees to Celsius.
   * @param kelvinDegrees   Kelvin degrees.
   * @return Celsius degrees.
   */
  public static Double kelvinToCelsius(final Double kelvinDegrees) {
    if (Objects.isNull(kelvinDegrees)) {
      return null;
    }

    return kelvinDegrees - 273.15;
  }

  /**
   * Convert Kelvin degrees to Fahrenheit.
   * @param kelvinDegrees   Kelvin degrees.
   * @return Fahrenheit degrees.
   */
  public static Double kelvinToFahrenheit(final Double kelvinDegrees) {
    if (Objects.isNull(kelvinDegrees)) {
      return null;
    }

    return kelvinToCelsius(kelvinDegrees) * 9 / 5 + 32;
  }
}
