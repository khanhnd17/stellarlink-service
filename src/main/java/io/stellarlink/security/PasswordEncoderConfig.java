package io.stellarlink.security;

import io.stellarlink.model.enums.EncryptionAlgorithm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PasswordEncoderConfig {
  @Bean
  public PasswordEncoder bcryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public PasswordEncoder scryptPasswordEncoder() {
    return new SCryptPasswordEncoder(16384, 8, 1, 32, 64);
  }

  @Bean
  public Map<EncryptionAlgorithm, PasswordEncoder> passwordEncoders(
      @Qualifier("bcryptPasswordEncoder") PasswordEncoder bcrypt,
      @Qualifier("scryptPasswordEncoder") PasswordEncoder scrypt
  ) {
    Map<EncryptionAlgorithm, PasswordEncoder> encoders = new HashMap<>();
    encoders.put(EncryptionAlgorithm.BCRYPT, bcrypt);
    encoders.put(EncryptionAlgorithm.SCRYPT, scrypt);
    return encoders;
  }
}
