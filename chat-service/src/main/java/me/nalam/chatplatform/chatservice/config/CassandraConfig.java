package me.nalam.chatplatform.chatservice.config;

import java.util.Set;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraEntityClassScanner;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = {"me.nalam.chatplatform.chatservice.repository"})
public class CassandraConfig extends AbstractCassandraConfiguration {

  @Value("${spring.data.cassandra.contact-points:127.0.0.1}")
  private String contactPoints;

  @Value("${spring.data.cassandra.port:9042}")
  private int port;

  @Value("${spring.data.cassandra.keyspace:chatplatform}")
  private String keySpace;

  @Value("${spring.data.cassandra.schema-action}")
  private String schemaAction;

  @Override
  protected String getKeyspaceName() {
    return keySpace;
  }

  @Override
  protected String getContactPoints() {
    return contactPoints;
  }

  @Override
  protected int getPort() {
    return port;
  }

  @Override
  public SchemaAction getSchemaAction() {
    return SchemaAction.valueOf(schemaAction);
  }

  @Override
  public String[] getEntityBasePackages() {
    return new String[] {"me.nalam.chatplatform.chatservice.model"};
  }

  @Override
  protected Set<Class<?>> getInitialEntitySet() throws ClassNotFoundException {
    return CassandraEntityClassScanner.scan(getEntityBasePackages());
  }
}
