package com.example.backendairport.exception;


import com.example.backendairport.controller.HttpErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionsHandler {
 @ExceptionHandler({ResourceNotFound.class})
 @ResponseStatus(HttpStatus.NOT_FOUND)
 public HttpErrorResponse handleGenericException(ResourceNotFound exception) {
  return new HttpErrorResponse(
          404,
          exception.getMessage(),
          LocalDateTime.now()
  );
 }
 @ExceptionHandler({ServiceNotAvailable.class})
 @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
 public HttpErrorResponse handleServiceNotAvailable(ServiceNotAvailable exception) {
  return new HttpErrorResponse(
          503,
          exception.getMessage(),
          LocalDateTime.now()
  );
 }
}