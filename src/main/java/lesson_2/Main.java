package lesson_2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

  private static final JdbcSqliteManager dbSqliteManager = new JdbcSqliteManager();
  private static PreparedStatement prstm;
  private static final String CREATE_USERS_TABLE = "CREATE TABLE users (\n" +
    "    id         INTEGER PRIMARY KEY AUTOINCREMENT\n" +
    "                       UNIQUE\n" +
    "                       NOT NULL,\n" +
    "    first_name STRING  NOT NULL,\n" +
    "    last_name  STRING  NOT NULL,\n" +
    "    age        INTEGER\n" +
    ")";

  public static void main(String[] args) {
    dbSqliteManager.connect();

    // Create table
    dbSqliteManager.createTable(CREATE_USERS_TABLE, "USERS");

    // Insert a new record
    try {
      prstm = dbSqliteManager.getConnection().prepareStatement("insert into users (first_name, last_name, age)\n" +
        "values (?, ?, ?)");
      prstm.setString(1, "Anna");
      prstm.setString(2, "Pikhotina");
      prstm.setInt(3, 30);
      prstm.executeUpdate();

      System.out.println("User record inserted");

    }
    catch (SQLException e) {
      System.out.println("User could not be updated");
      e.printStackTrace();
    }

    // Select * records
    try {
      ResultSet result = dbSqliteManager.getStm().executeQuery("select * from users");
      System.out.println("Users found:");
      while(result.next()) {
        System.out.println(result.getString(1) + " " + result.getString(2) +" " + result.getInt(3));
      }

    }
    catch (SQLException e) {
      System.out.println("User could not be found");
      e.printStackTrace();
    }

    // Delete a specific record
    try {
      prstm = dbSqliteManager.getConnection().prepareStatement("delete from users where id = ?");
      prstm.setInt(1, 1);
      prstm.executeUpdate();

      System.out.println("User deleted");

    }
    catch (SQLException e) {
      System.out.println("User could not be deleted");
      e.printStackTrace();
    }

    // Delete the table
    try {
      dbSqliteManager.getStm().executeUpdate("drop table users");
      System.out.println("users table is deleted");
    }
    catch (SQLException e) {
      System.out.println("Users table could not be deleted");
      e.printStackTrace();
    }

  }
}
