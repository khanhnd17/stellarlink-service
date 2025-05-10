package io.stellarlink.service;

import io.stellarlink.model.entity.Conversation;
import io.stellarlink.model.entity.User;

import java.util.List;
import java.util.UUID;

public interface ConversationService {
  Conversation createConversation(List<User> participants, String name, boolean isGroup);

  List<Conversation> findByUserId(UUID userId);

  Conversation getById(UUID id);

  void deleteConversation(UUID id);
}
