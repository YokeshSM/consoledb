package Yokesh.model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import Yokesh.controller.connection;
import Yokesh.controller.scanner;

public class brandsdao {
    public static Connection con;
    public static Scanner sc;
    public static ArrayList<ArrayList<String>> brandisp() throws Exception {
       con=connection.getconnection();
       ArrayList<ArrayList<String>>b=new ArrayList<>();
       sc=scanner.getScanner();
       String s="Select * from brand";
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery(s);
       while(rs.next())
       {
        ArrayList<String>m=new ArrayList<String>();
       m.add(String.valueOf(rs.getInt(1)));
       m.add(rs.getString(2));
       b.add(m);
        // System.out.println("id is "+rs.getInt(1)+" to Select "+rs.getString(2));
       }  
       return b;
    }
    public static String setget(int id) throws Exception
    {
        con=connection.getconnection();
       sc=scanner.getScanner();
       String s="select brand_name from brand where b_id like '"+id+"'";
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery(s);
       if(rs.next())
       {
        return rs.getString(1);
       }
       else
       return "null";
    }
    
}
