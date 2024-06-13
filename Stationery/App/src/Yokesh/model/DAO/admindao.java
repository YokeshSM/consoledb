package Yokesh.model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Yokesh.controller.Passcheck;
import Yokesh.controller.admin;
import Yokesh.controller.connection;

public class admindao {
    private static Connection con;
      public static String adcheck(Passcheck p) throws Exception
    {
          con=connection.getconnection();
          int id=p.id;
          String s=p.pass;
          String v="select * from admin where id = "+id+" and password like '"+s+"' ";
          Statement st=con.createStatement();
          ResultSet rs=st.executeQuery(v);
          admin ut=new admin();
        if(rs.next())
          {
           ut.setId(rs.getInt(1));
          // System.out.print(rs.getString(2));
           ut.setName(rs.getString(2));
           ut.setPwd(rs.getString(3));
           ut.setMail(rs.getString(4));
           ut.setRole(rs.getString(5));
        //  return rs.getString(2)
          }
         // System.out.println(ut.getName()+"hAPPIEEEEEE ");
          return ut.getName();
    }
    public ArrayList<ArrayList<String>> displaypr(int tk) throws Exception
    {
      brandsdao bd=new brandsdao();
      shopdao sd=new shopdao();
      productsDAO pd=new productsDAO();
        if(tk==1)
        {
         return bd.brandisp();
        }
        if(tk==2)
        {
         return sd.prodisp();
        }
        if(tk==3)
        {
          return pd.prodisp();
        }
         return null;

    }

}
