package me.nalam.chatplatform.chatservice.repository;

import java.util.Optional;
import java.util.UUID;
import me.nalam.chatplatform.chatservice.model.ChatRoom;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ChatRoomRepository extends CassandraRepository<ChatRoom, UUID> {
  @AllowFiltering
  Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);

}
