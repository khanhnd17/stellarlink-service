package io.stellarlink.security;

import io.stellarlink.model.enums.EncryptionAlgorithm;
import io.stellarlink.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Map;

@RequiredArgsConstructor
@Component
public class DatabaseAuthenticationProvider implements AuthenticationProvider {

  private final UserDetailsService userDetailsService;
  private final Map<EncryptionAlgorithm, PasswordEncoder> encoders;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username = authentication.getName();
    String rawPassword = authentication.getCredentials().toString();

    UserDetails userDetails = userDetailsService.loadUserByUsername(username);

    if (!(userDetails instanceof SecurityUser securityUser)) {
      throw new InternalAuthenticationServiceException("Invalid user type returned");
    }

    EncryptionAlgorithm algorithm = securityUser.user().getAlgorithm();
    PasswordEncoder encoder = encoders.get(algorithm);

    if (encoder == null) {
      throw new InternalAuthenticationServiceException("No PasswordEncoder configured for algorithm: " + algorithm);
    }

    if (!encoder.matches(rawPassword, securityUser.getPassword())) {
      throw new BadCredentialsException("Invalid username or password");
    }

    return new UsernamePasswordAuthenticationToken(
        securityUser,
        null,
        securityUser.getAuthorities()
    );
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
  }
}
