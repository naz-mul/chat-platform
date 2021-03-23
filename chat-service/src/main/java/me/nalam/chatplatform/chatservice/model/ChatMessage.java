package me.nalam.chatplatform.chatservice.model;

import java.time.Instant;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import me.nalam.chatplatform.chatservice.constants.MessageStatus;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table
public class ChatMessage {
  @PrimaryKey
  private UUID id;
  private String chatId;
  private String senderId;
  private String recipientId;
  private String senderName;
  private String recipientName;
  private String content;
  private Instant timestamp;
  private MessageStatus status;
}