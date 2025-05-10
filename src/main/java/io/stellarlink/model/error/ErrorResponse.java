package io.stellarlink.model.error;

import java.time.Instant;

public record ErrorResponse(
    String code,
    String message,
    String path,
    Instant timestamp
) {
  public static ErrorResponse of(ErrorCode code, String message, String path) {
    return new ErrorResponse(code.getCode(), message, path, Instant.now());
  }
}