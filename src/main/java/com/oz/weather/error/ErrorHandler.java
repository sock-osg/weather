package com.oz.weather.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * ErrorHandler.
 * @author sock.sqt@gmail.com
 * @since 1.0.0
 */
@Slf4j
@ControllerAdvice
public class ErrorHandler {

  /**
   * Handle service exceptions.
   * @param serviceException    serviceException.
   * @return Response entity.
   */
  @ExceptionHandler(ServiceException.class)
  public ResponseEntity<ServiceException.ErrorResponse> handleServiceException(
      final ServiceException serviceException) {
    log.warn("Service exception: {}", serviceException.getErrorResponse().getMessage());
    return new ResponseEntity<>(serviceException.getErrorResponse(), serviceException.getHttpStatus());
  }

  /**
   * Handle MethodArgumentTypeMismatchException exceptions.
   * @param exception    exception.
   * @return Response entity.
   */
  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<ServiceException.ErrorResponse> handleMethodArgumentTypeMismatchException(
      final MethodArgumentTypeMismatchException exception) {
    log.warn("{}: {}", exception.getName(), exception.getLocalizedMessage());

    HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
    ServiceException.ErrorResponse errorResponse =
        new ServiceException.ErrorResponse(
            httpStatus.value(),
            exception.getLocalizedMessage());

    return new ResponseEntity<>(errorResponse, httpStatus);
  }
}
