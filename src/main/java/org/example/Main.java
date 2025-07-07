package org.example;

import org.example.db.Database;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    UserService service = context.getBean("userService", UserService.class);

    service.insertUser(new User("MjScrim"));

    service.getAllUsers().forEach(u -> System.out.printf("ID: %d | Name: %s", u.getId(), u.getName()));
  }

}