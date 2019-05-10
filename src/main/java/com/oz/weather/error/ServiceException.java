package com.oz.weather.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * ServiceException.
 * @author sock.sqt@gmail.com
 * @since 1.0.0
 */
class ServiceException extends RuntimeException {

  private static final long serialVersionUID = 8614231641636501612L;

  @Getter
  private final HttpStatus httpStatus;
  @Getter
  private final ErrorResponse errorResponse;

  ServiceException(String message, Throwable cause, HttpStatus httpStatus) {
    super(message, cause);
    this.httpStatus = httpStatus;
    this.errorResponse = new ErrorResponse(this.httpStatus.value(), message);
  }

  @Getter
  @AllArgsConstructor
  static class ErrorResponse implements java.io.Serializable {

    private static final long serialVersionUID = 6458720365706324078L;

    private int code;
    private String message;
  }
}
