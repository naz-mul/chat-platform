package me.nalam.chatplatform.chatservice.repository;

import java.util.List;
import java.util.UUID;
import me.nalam.chatplatform.chatservice.constants.MessageStatus;
import me.nalam.chatplatform.chatservice.model.ChatMessage;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ChatMessageRepository extends CassandraRepository<ChatMessage, UUID> {
  @AllowFiltering
  long countBySenderIdAndRecipientIdAndStatus(
      String senderId, String recipientId, MessageStatus status);

  @AllowFiltering
  List<ChatMessage> findByChatId(String chatId);
}
