package Yokesh.model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Yokesh.controller.Passcheck;
import Yokesh.controller.connection;
import Yokesh.controller.user;

public class userDAO {
    private static Connection con=null;
   
    public static user uscheck(Passcheck p) throws Exception
    {
          con=connection.getconnection();
          int id=p.id;
          String s=p.pass;
          String v="select * from user where userid like '"+id+"' and userpwd like '"+s+"' ";
          Statement st=con.createStatement();
          ResultSet rs=st.executeQuery(v);
          user ut=new user();
        if(rs.next())
          {
           ut.setId(rs.getInt(1));
           ut.setName(rs.getString(2));
           ut.setPwd(rs.getString(3));
           ut.setMail(rs.getString(4));
           ut.setPh(rs.getString(5));
        //  return rs.getString(2)
          }
         // System.out.println(ut.getName());
          return ut;
    }
   


}
