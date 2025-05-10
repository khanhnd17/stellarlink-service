package io.stellarlink.model.entity;

import io.stellarlink.constant.StellerLinkVersion;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@Embeddable
public class AuditMetadata implements Serializable {

  @Serial
  private static final long serialVersionUID = StellerLinkVersion.SERIAL_VERSION_UID;

  private String createdBy;

  private String lastModifiedBy;

  private String flaggedDeletedBy;

  private Instant createdAt;

  private Instant lastModifiedAt;

  private Instant flaggedDeletedAt;

  private Integer version;
}
