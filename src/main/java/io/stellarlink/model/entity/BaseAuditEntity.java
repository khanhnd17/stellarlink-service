package io.stellarlink.model.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseAuditEntity extends BaseEntity {
  @Embedded
  private AuditMetadata auditMetadata;
}
