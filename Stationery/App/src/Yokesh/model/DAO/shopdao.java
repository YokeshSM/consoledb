package Yokesh.model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import Yokesh.controller.Passcheck;
import Yokesh.controller.connection;
import Yokesh.controller.scanner;
import Yokesh.controller.shop;
import Yokesh.controller.user;

public class shopdao {
  public static Connection con;
  public static Scanner sc;
  public static shop sd;
  public static boolean ispre(int id1, int id2) {
    try {
      con = connection.getconnection();
      sc = scanner.getScanner();
      String v = "select br_id,pr_id from products where exists (select br_id,pr_id from products where br_id like '"
          + id1 + "' and pr_id like '" + id2 + "' and count not like '0')";
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(v);
      if (rs.next()) {
        // System.out.println(rs.getInt(2));
        return true;
      }

      return false;
    } catch (Exception e) {
      System.out.println(e);
    }
    return false;
  }

  public int checkcount(int id1, int id2) throws SQLException {
    String h = "select count from products where pr_id like '" + id2 + "' and br_id like '" + id1 + "'";
    Statement st = con.createStatement();

    sd = new shop();
    String p = "select * from products where pr_id like '" + id2 + "' and br_id like '" + id1 + "'";
    ResultSet rt = st.executeQuery(p);
    if (rt.next()) {
      sd.setId(rt.getInt(1));
      sd.setPr_id(rt.getInt(2));
      sd.setB_id(rt.getInt(3));
      sd.setCount(rt.getInt(4));
      sd.setPrice(rt.getInt(5));
    }
    ResultSet rs = st.executeQuery(h);
    if (rs.next()) {
      return rs.getInt(1);
    } else
      return -1;

  }

  public int price() throws Exception {
    int s = sd.getPrice();
    return s;
  }

  public int shop(int id1, int id2, int c,int usid) throws Exception {
    int cnt=sd.getCount();
 //   System.out.print("count"+cnt);
  //  System.out.println(id1+" "+id2);
    int up=cnt-c;
  if(cnt==0)
  {
   return 0;
  }
  String s="update products set count='"+up+"' where pr_id ='"+id2+"' and br_id='"+id1+"'";
   Statement st=con.createStatement();
   int rs=st.executeUpdate(s);
  // System.out.print("st"+rs);
  //String upbills="insert into bills values(0,)"
   if(rs>=1)
   {
    return 1;
   }
   return 0;

  }
   public static ArrayList<ArrayList<String>> prodisp() throws Exception {
       con=connection.getconnection();
       ArrayList<ArrayList<String>>b=new ArrayList<>();
       sc=scanner.getScanner();
       String s="Select * from products WHERE count>0";
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery(s);
       while(rs.next())
       {
        ArrayList<String>m=new ArrayList<String>();
       m.add(String.valueOf(rs.getInt(1)));
       m.add(String.valueOf(rs.getInt(2)));
       m.add(String.valueOf(rs.getInt(3)));
       m.add(String.valueOf(rs.getInt(4)));
       m.add(String.valueOf(rs.getInt(5)));
      // m.add(rs.getString(2));
       b.add(m);
        // System.out.println("id is "+rs.getInt(1)+" to Select "+rs.getString(2));
       }  
       return b;
}
}
