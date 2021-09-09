package lesson_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSqliteManager {

  private Connection connection;
  private Statement stm;
  private PreparedStatement prstm;
  private String URL = "jdbc:sqlite:main.db";

  public void connect() {
    try {
      Class.forName("org.sqlite.JDBC");
      connection = DriverManager.getConnection(URL);
      stm = connection.createStatement();
    }
    catch (ClassNotFoundException | SQLException e) {
      System.out.printf("Connection to database with URL %s refused\n", URL);
      e.printStackTrace();
    }
  }

  public void disconnect() {
    try {
      connection.close();
    }
    catch (SQLException e) {
      System.out.println("Connection to database cannot be cosed");
      e.printStackTrace();
    }
  }

  public void createTable(String sql, String tableName) {
    try {
      stm.executeUpdate(sql);
      System.out.printf("%s table created\n", tableName);
    }
    catch (SQLException e) {
      System.out.printf("%s table could not be created\n", tableName);
      e.printStackTrace();
    }
  }


  public Statement getStm() {
    return stm;
  }

  public Connection getConnection() {
    return connection;
  }
}
