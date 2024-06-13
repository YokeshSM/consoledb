package Yokesh.model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import Yokesh.controller.connection;
import Yokesh.controller.scanner;

public class productsDAO {
    public static Connection con;
    public static Scanner sc;
    public static ArrayList<ArrayList<String>> prodisp() throws Exception {
       con=connection.getconnection();
       sc=scanner.getScanner();
       ArrayList<ArrayList<String>> g=new ArrayList<>();
       String s="select * from productlist";
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery(s);
       while(rs.next())
       {
           ArrayList<String>p=new ArrayList<>();
        // System.out.println("id is "+rs.getInt(1)+" to Select "+rs.getString(2));
        p.add(String.valueOf(rs.getInt(1)));
        p.add(rs.getString(2));
        g.add(p);
       }  
       return g;
    }
    public static String setget(int id) throws Exception
    {
        con=connection.getconnection();
       sc=scanner.getScanner();
       String s="select pr_name from productlist where id like '"+id+"'";
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
