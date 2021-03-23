package me.nalam.chatplatform.authservice.repository;

import java.util.List;
import java.util.UUID;
import me.nalam.chatplatform.authservice.model.User;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserRepository extends CassandraRepository<User, UUID> {
  @AllowFiltering
  List<User> findByActive(boolean active);

}
