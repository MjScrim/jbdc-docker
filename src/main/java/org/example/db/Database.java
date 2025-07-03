package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

  private static final String url = "jdbc:postgresql://localhost:5432/jdbcDB";
  private static final String user = "root";
  private static final String pass = "root";

  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(url, user, pass);
  }

}
