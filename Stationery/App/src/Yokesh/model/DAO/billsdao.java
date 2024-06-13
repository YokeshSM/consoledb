package Yokesh.model.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Yokesh.controller.connection;
import Yokesh.controller.user;

public class billsdao {
    public static Connection con;
    public static ArrayList<String>bill=new ArrayList<String>();
    public static void generate (user us,int id,int count,int tot,String prname) throws Exception
    {
      con=connection.getconnection();
      String s="insert into bills values(0,'"+us.getId()+"','"+prname+"','"+count+"','"+tot+"','not paid')";
      Statement st=con.createStatement();
      st.executeUpdate(s);
    }
    public static int calc(int id)throws Exception{
      String h=String.valueOf(id);
      int sum=0;
       con=connection.getconnection();
       String se="select price from bills where name='"+h+"' and paid='not paid'";
       Statement st1=con.createStatement();
       ResultSet rs=st1.executeQuery(se);
       while(rs.next())
       {
            sum=sum+rs.getInt(1);
       }
   //    System.out.println(sum);
       return sum;
    }

    public static int update(int id)throws Exception
    {
        String h=String.valueOf(id);
        con=connection.getconnection();
      String s="update bills set paid='paid' where name='"+h+"'";
      Statement st=con.createStatement();
     // System.out.println(st.executeQuery(s)+" tabs");
      return st.executeUpdate(s);
    }
}
