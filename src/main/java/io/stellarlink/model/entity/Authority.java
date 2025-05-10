package io.stellarlink.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Authority extends BaseAuditEntity {
  private String name;

  @ManyToOne
  @JoinColumn(name = "user")
  private User user;
}
