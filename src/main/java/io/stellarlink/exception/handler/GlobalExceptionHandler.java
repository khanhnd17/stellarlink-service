package io.stellarlink.exception.handler;

import io.stellarlink.exception.ResourceConflictException;
import io.stellarlink.model.error.ErrorCode;
import io.stellarlink.model.error.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(ResourceConflictException.class)
  public ResponseEntity<ErrorResponse> handleConflictException(ResourceConflictException ex, HttpServletRequest request) {
    ErrorResponse error = ErrorResponse.of(
        ErrorCode.RESOURCE_CONFLICT,
        ex.getMessage(),
        request.getRequestURI()
    );
    return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
  }
}
