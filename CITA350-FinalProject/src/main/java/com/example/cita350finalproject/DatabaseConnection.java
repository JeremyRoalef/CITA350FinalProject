
package com.example.cita350finalproject;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
   public  static Connection createConnection() {
      try {
         String DATABASE_URL = "jdbc:mysql://localhost:3306/ordermenu";
         String user ="root";
         String pWord = "1234";
         Connection conn = DriverManager.getConnection(DATABASE_URL, user, pWord);
         return conn;
      } catch (Exception except) {
         except.printStackTrace();
         return null;
      }
   }
}
