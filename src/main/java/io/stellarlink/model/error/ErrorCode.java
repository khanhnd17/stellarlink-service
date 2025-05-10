package io.stellarlink.model.error;

public enum ErrorCode {

  // Generic
  INTERNAL_ERROR,
  VALIDATION_ERROR,
  BAD_REQUEST,

  // Auth-related
  UNAUTHORIZED,
  FORBIDDEN,
  TOKEN_EXPIRED,
  INVALID_CREDENTIALS,

  // User-related
  USERNAME_DUPLICATE,
  EMAIL_DUPLICATE,
  USER_NOT_FOUND,

  // Message-related
  MESSAGE_NOT_FOUND,
  MESSAGE_SEND_FAILED,

  // Conversation-related
  CONVERSATION_NOT_FOUND,

  // File-related
  FILE_UPLOAD_FAILED,
  FILE_NOT_FOUND,

  // Resource-related
  RESOURCE_CONFLICT,
  RESOURCE_NOT_FOUND;

  public String getCode() {
    return name();
  }
}
