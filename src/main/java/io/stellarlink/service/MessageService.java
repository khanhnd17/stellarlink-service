package io.stellarlink.service;

import io.stellarlink.model.entity.Message;

import java.util.List;
import java.util.UUID;

public interface MessageService extends BaseService<Message, UUID> {

  List<Message> getMessagesBySenderId(UUID senderId);

  List<Message> getMessagesByConversationId(UUID conversationId);
}
