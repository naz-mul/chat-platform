package me.nalam.chatplatform.chatservice.service;

import java.util.Optional;
import me.nalam.chatplatform.chatservice.model.ChatRoom;
import me.nalam.chatplatform.chatservice.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatRoomService {
  @Autowired
  private ChatRoomRepository chatRoomRepository;

  public Optional<String> getChatId(
      String senderId, String recipientId, boolean createIfNotExist) {

    return chatRoomRepository
        .findBySenderIdAndRecipientId(senderId, recipientId)
        .map(ChatRoom::getChatId)
        .or(() -> {
          if(!createIfNotExist) {
            return  Optional.empty();
          }
          var chatId =
              String.format("%s_%s", senderId, recipientId);

          ChatRoom senderRecipient = ChatRoom
              .builder()
              .chatId(chatId)
              .senderId(senderId)
              .recipientId(recipientId)
              .build();

          ChatRoom recipientSender = ChatRoom
              .builder()
              .chatId(chatId)
              .senderId(recipientId)
              .recipientId(senderId)
              .build();
          chatRoomRepository.save(senderRecipient);
          chatRoomRepository.save(recipientSender);

          return Optional.of(chatId);
        });
  }
}
