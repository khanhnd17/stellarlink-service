package io.stellarlink.model.entity;

import io.stellarlink.constant.StellerLinkVersion;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Getter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

  @Serial
  private static final long serialVersionUID = StellerLinkVersion.SERIAL_VERSION_UID;

  @Id
  @UuidGenerator
  private UUID id;
}
