package io.stellarlink.service.impl;

import io.stellarlink.model.entity.User;
import io.stellarlink.repository.UserRepository;
import io.stellarlink.security.SecurityUser;
import io.stellarlink.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;


  @Override
  public User create(User entity) {
    return userRepository.save(entity);
  }

  @Override
  public Optional<User> getById(UUID uuid) {
    return userRepository.findById(uuid);
  }

  @Override
  public User update(UUID uuid, User updatedEntity) {
    return userRepository.findById(uuid)
        .map(existing -> {
          existing.setUsername(updatedEntity.getUsername());
          existing.setDisplayName(updatedEntity.getDisplayName());
          existing.setEmail(updatedEntity.getEmail());
          return userRepository.save(existing);
        })
        .orElseThrow(() -> new RuntimeException("User not found with id: " + uuid));
  }

  @Override
  public void delete(UUID uuid) {
    if (!userRepository.existsById(uuid)) {
      throw new RuntimeException("User not found with id: " + uuid);
    }
    userRepository.deleteById(uuid);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    return new SecurityUser(user);
  }

  @Override
  public boolean existsByUsername(String username) {
    return userRepository.existsByUsername(username);
  }
}
