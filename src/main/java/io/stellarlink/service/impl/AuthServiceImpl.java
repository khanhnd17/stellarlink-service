package io.stellarlink.service.impl;

import io.stellarlink.exception.ResourceConflictException;
import io.stellarlink.model.entity.User;
import io.stellarlink.mapper.UserMapper;
import io.stellarlink.model.dto.auth.RegisterRequest;
import io.stellarlink.model.dto.user.UserResponse;
import io.stellarlink.model.enums.EncryptionAlgorithm;
import io.stellarlink.service.AuthService;
import io.stellarlink.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
  private final UserService userService;
  private final UserMapper userMapper;
  private final Map<EncryptionAlgorithm, PasswordEncoder> encoders;

  @Override
  public UserResponse registerUser(RegisterRequest request) throws ResourceConflictException {
    if (userService.existsByUsername(request.username())) {
      throw new ResourceConflictException("Username already exists");
    }
    EncryptionAlgorithm algorithm = Optional.ofNullable(request.algorithm())
        .orElse(EncryptionAlgorithm.BCRYPT);
    PasswordEncoder encoder = encoders.get(algorithm);

    if (encoder == null) {
      throw new ResourceConflictException("Invalid algorithm");
    }

    User newUser = userMapper.toUser(request);
    newUser.setPassword(encoder.encode(request.password()));

    newUser = userService.create(newUser);
    return userMapper.toUserResponse(newUser);
  }
}
