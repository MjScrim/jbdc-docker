package org.example;

import org.example.config.DatabaseConfig;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class);

    UserService service = context.getBean(UserService.class);

    service.insertUser(new User("MjScrim"));

    service.getAllUsers().forEach(u -> System.out.printf("ID: %d | Name: %s", u.getId(), u.getName()));
  }

}