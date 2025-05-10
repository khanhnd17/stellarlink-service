package io.stellarlink.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class FileAttachment extends BaseEntity {

  private String fileName;

  private String fileType;

  private String url;

  @ManyToOne
  @JoinColumn(name = "message_id")
  private Message message;
}
