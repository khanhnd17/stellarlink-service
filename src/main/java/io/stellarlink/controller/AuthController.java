package io.stellarlink.controller;

import io.stellarlink.model.dto.auth.RegisterRequest;
import io.stellarlink.model.dto.user.UserResponse;
import io.stellarlink.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

  private final AuthService authService;

  @PostMapping("/register")
  public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest registerRequest) {
    UserResponse user = authService.registerUser(registerRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(user);
  }
}
