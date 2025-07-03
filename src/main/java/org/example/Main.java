package org.example;

import org.example.model.User;
import org.example.service.UserService;

public class Main {

  public static void main(String[] args) {
    UserService service = new UserService();

    service.insertUser(new User("MjScrim"));

    service.getAllUsers().forEach(u -> System.out.printf("ID: %d | Name: %s", u.getId(), u.getName()));
  }

}