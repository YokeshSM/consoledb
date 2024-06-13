package Yokesh.views;

import java.util.Scanner;

import Yokesh.controller.Passcheck;
import Yokesh.controller.scanner;

public class display {
    public static Passcheck display1() throws Exception{
       Scanner sc=scanner.getScanner();
           System.out.println("Enter id");
           int a=sc.nextInt();
           System.out.println("Enter Password");
           sc.nextLine();
           String b=sc.nextLine();
           Passcheck p =new Passcheck(a, b);
           return p;
    }
}
