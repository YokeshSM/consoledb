package Yokesh.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
public  class connection {
    private static String url="jdbc:mysql://localhost:3306/stationary";
    private  static  String username="root";
    private static	String password="1234567";
    // Class.forName("com.mysql.jdbc.Driver");
    public static Connection getconnection() throws Exception{
      Connection con =DriverManager.getConnection(url,username,password);
     // java.sql.Statement st=con.createStatement();
     return con;
    }
}
