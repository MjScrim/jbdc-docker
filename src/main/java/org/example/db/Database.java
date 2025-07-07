package org.example.db;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Database {

  private DataSource dataSource;

  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public Connection getConnection() throws SQLException {
    return dataSource.getConnection();
  }

}
