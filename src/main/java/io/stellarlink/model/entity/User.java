package io.stellarlink.model.entity;

import io.stellarlink.model.enums.EncryptionAlgorithm;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseAuditEntity {

  @Column(nullable = false, unique = true)
  private String username;

  private String password;

  @Enumerated(EnumType.STRING)
  private EncryptionAlgorithm algorithm;

  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
  private List<Authority> authorities;

  private String displayName;

  private String email;

  private String phone;

  @Enumerated(EnumType.STRING)
  private Status status;

  public enum Status {
    ONLINE,
    OFFLINE,
    AWAY,
    BUSY
  }
}
