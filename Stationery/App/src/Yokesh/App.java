package Yokesh;

import java.sql.Connection;
import java.util.*;

import Yokesh.controller.Passcheck;
import Yokesh.controller.connection;
import Yokesh.controller.scanner;
import Yokesh.model.DAO.userDAO;
import Yokesh.views.adminmenu;
import Yokesh.views.display;
import Yokesh.views.usermenu;

public class App {
    public static void main(String[]args) throws Exception {
        System.out.println("Hello, World!");
        Connection con=connection.getconnection();
        Scanner sc=scanner.getScanner();
        System.out.println("Welcome to LOGIN");
        //userDAO us=new userDAO();
        System.out.println("Enter 1 for user login");
        System.out.println("Enter 2 for admin login");
         int t=sc.nextInt();
        if(t==1)
        {
         usermenu us=new usermenu();
         us.enter();
        }

        else if(t==2)
         {
           adminmenu am=new adminmenu();
           am.enterad();
         }
         else
         {
          System.out.println("Wrong credentials");
          main(args);
          System.exit(200);
         }

    }
}
