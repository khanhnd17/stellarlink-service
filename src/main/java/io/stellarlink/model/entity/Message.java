package io.stellarlink.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Message extends BaseAuditEntity {
  @Lob
  private String content;

  @ManyToOne
  @JoinColumn(name = "sender_id")
  private User sender;

  @ManyToOne
  @JoinColumn(name = "conversation_id")
  private Conversation conversation;

  @OneToMany(mappedBy = "message", cascade = CascadeType.ALL)
  private List<FileAttachment> attachments = new ArrayList<>();
}
