package me.nalam.chatplatform.authservice.model;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable {

  @PrimaryKey private UUID id;

  @NotBlank
  @Size(min = 5, max = 15)
  private String name;

  @CreatedDate private Instant createdAt;

  @LastModifiedDate private Instant updatedAt;

  private boolean active;

  public User(User user) {
    this.id = user.id;
    this.name = user.name;
    this.createdAt = user.getCreatedAt();
    this.updatedAt = user.getUpdatedAt();
    this.active = user.active;
  }

  public User(String name) {
    var time = Instant.now();
    this.id = Uuids.timeBased();
    this.name = name;
    this.createdAt = time;
    this.updatedAt = time;
    this.active = true;
  }
}
