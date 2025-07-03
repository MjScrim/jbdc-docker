package org.example.service;

import org.example.db.Database;
import org.example.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {

  public void insertUser(User user) {
    String sql = "INSERT INTO users (name) VALUES (?)";

    try (Connection connection = Database.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
      stmt.setString(1, user.getName());
      stmt.executeUpdate();
    } catch (SQLException e) {
      System.err.println("Error to insert user: " + e.getMessage());
    }
  }

  public List<User> getAllUsers() {
    List<User> users = new ArrayList<>();

    String sql = "SELECT * FROM users";

    try (Connection connection = Database.getConnection();
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
