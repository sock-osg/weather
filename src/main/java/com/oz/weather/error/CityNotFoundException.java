package com.oz.weather.error;

import org.springframework.http.HttpStatus;

/**
 * CityNotFoundException.
 * @author sock.sqt@gmail.com
 * @since 1.0.0
 */
public class CityNotFoundException extends ServiceException {

  private static final long serialVersionUID = -6386612904633170339L;

  /**
   * Create a new instance of the class.
   * @param message   message.
   * @param cause     cause.
   */
  public CityNotFoundException(String message, Throwable cause) {
    super(message, cause, HttpStatus.NOT_FOUND);
  }
}
