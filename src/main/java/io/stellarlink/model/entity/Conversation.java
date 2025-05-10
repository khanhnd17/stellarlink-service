package io.stellarlink.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Conversation extends BaseAuditEntity {
  private String name;
  private Boolean isGroup;

  @ManyToMany
  @JoinTable(
      name = "conversation_participants",
      joinColumns = @JoinColumn(name = "conversation_id"),
      inverseJoinColumns = @JoinColumn(name = "user_id")
  )
  private List<User> users = new ArrayList<>();

  @OneToMany(mappedBy = "conversation", cascade = CascadeType.ALL)
  private List<Message> messages = new ArrayList<>();
}
