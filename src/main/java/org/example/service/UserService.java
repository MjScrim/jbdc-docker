package org.example.service;

import org.example.database.Database;
import org.example.model.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

  @Autowired
  private final Database database;

  public UserService(Database database) {
    this.database = database;
  }

  public void insertUser(User user) {
    String sql = "INSERT INTO users (name) VALUES (?)";

    try (Connection connection = database.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
      stmt.setString(1, user.getName());
      stmt.executeUpdate();
    } catch (SQLException e) {
      System.err.println("Error to insert user: " + e.getMessage());
    }
  }

  public List<User> getAllUsers() {
    List<User> users = new ArrayList<>();

    String sql = "SELECT * FROM users";

    try (Connection connection = database.getConnection();
         Statement stmt = connection.createStatement();
         ResultSet result = stmt.executeQuery(sql)) {

      while (result.next()) {
        User user = new User(
          result.getInt("id"),
          result.getString("name")
        );

        users.add(user);
      }
    } catch (SQLException e) {
      System.err.println("Error when listing users: " + e.getMessage());
    }

    return users;
  }

}
