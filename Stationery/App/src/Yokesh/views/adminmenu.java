package Yokesh.views;

import java.util.ArrayList;
import java.util.Scanner;

import Yokesh.controller.*;
import Yokesh.model.DAO.admindao;
import Yokesh.model.DAO.userDAO;

public class adminmenu {

    public void enterad() throws Exception {
        Passcheck p = display.display1();
        String name = admindao.adcheck(p);
        if (name.equals("")) {
            System.out.print("Incorrect Details");
            // App.enter();
            System.exit(200);
        } else {
            System.out.println("Welcome " + name);
            menudis();
        }
    }

    public void menudis() throws Exception {
        Scanner sc = scanner.getScanner();
        admin ad = new admin();
        System.out.println("Welcome to Admin Actions");
        System.out.println("Click 1 for View");
        System.out.println("Click 2 for Exit");
        int t = sc.nextInt();
        admindao us = new admindao();
        ArrayList<ArrayList<String>>bn;
        if (t == 1) {
            System.out.print("Welcome To our shop ");
            System.out.println("Do you want to see the products?");
            System.out.println("Enter 1 for brands");
            System.out.println("Enter 2 for shop");
            System.out.println("Enter 3 for products");
            System.out.println("Enter 4 for exit");
           int tk=sc.nextInt();
           if(tk==5)
           return;
           else
           bn=us.displaypr(tk);
           System.out.println(bn);
           }
        }

    }
}
