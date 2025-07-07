package org.example.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.example.repository.Database;
import org.example.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig {

  @Bean(destroyMethod = "close")
  public DataSource dataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl("jdbc:postgresql://db:5432/jdbcDB");
    dataSource.setUsername("root");
    dataSource.setPassword("root");

    return dataSource;
  }

  @Bean
  public Database database(DataSource dataSource) {
      return new Database(dataSource);
  }

}
