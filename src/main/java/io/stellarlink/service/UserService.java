package io.stellarlink.service;

import io.stellarlink.model.entity.User;
import io.stellarlink.security.SecurityUser;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.UUID;

public interface UserService extends BaseService<User, UUID>, UserDetailsService {
  boolean existsByUsername(String username);
}
