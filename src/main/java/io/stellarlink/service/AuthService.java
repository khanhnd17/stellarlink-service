package io.stellarlink.service;

import io.stellarlink.exception.ResourceConflictException;
import io.stellarlink.model.dto.auth.RegisterRequest;
import io.stellarlink.model.dto.user.UserResponse;

public interface AuthService {
  UserResponse registerUser(RegisterRequest request) throws ResourceConflictException;
}
