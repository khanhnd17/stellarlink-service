package io.stellarlink.controller;

import io.stellarlink.model.entity.User;
import io.stellarlink.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService;

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable UUID id) {
    return userService.getById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }


  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody User user) {
    return ResponseEntity.ok(userService.create(user));
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> updateUser(@PathVariable UUID id, @RequestBody User user) {
    return ResponseEntity.ok(userService.update(id, user));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
    userService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
