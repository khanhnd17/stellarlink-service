package io.stellarlink.security;

import io.stellarlink.model.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public record SecurityUser(User user) implements UserDetails {

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return user.getAuthorities().stream()
        .map(a -> new SimpleGrantedAuthority(
            a.getName()))
        .collect(Collectors.toList());
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getUsername();
  }
}
