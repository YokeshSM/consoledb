package Yokesh.views;

import java.util.Scanner;

import Yokesh.controller.Passcheck;
import Yokesh.controller.admin;
import Yokesh.controller.scanner;
import Yokesh.controller.user;
import Yokesh.model.DAO.admindao;
import Yokesh.model.DAO.billsdao;
import Yokesh.model.DAO.brandsdao;
import Yokesh.model.DAO.productsDAO;
import Yokesh.model.DAO.shopdao;
import Yokesh.model.DAO.userDAO;

public class usermenu {
    public static int sum=0;
    public static int id=0;
    public static user ad;
    public void enter() throws Exception{
        Passcheck p=display.display1();
        id=p.id;
         ad=userDAO.uscheck(p);
        String name=ad.getName();
        if(name == null)
        {
        System.out.print("Incorrect Details");
        //App.enter();
        System.exit(200);
        }
        else
        {
            menudis();
       // System.out.println("Welcome "+name ); 
        } 
    }
    public void menudis() throws Exception
    {
        Scanner sc=scanner.getScanner();
        System.out.println("Welcome to User Actions");
        System.out.println("Click 1 for View");
        System.out.println("Click 2 for buy");
        System.out.println("Click 3 for Billing");
        System.out.println("Click 4 for Exit");
        int t=sc.nextInt();
        if(t==1)
        {
           System.out.print("Welcome To our shop ");
           brandsdao bd=new brandsdao();
           productsDAO pd=new productsDAO();
           System.out.println("Welcome to See our brands");
           System.out.println(bd.brandisp());
           System.out.println("Welcome to See our products");
           System.out.println(pd.prodisp());
           menudis();
        }
        if(t==2)
        {
            System.out.println("Enter the Value of the brand ID and products ID you need");
            int v=sc.nextInt(); //brand id
            int p=sc.nextInt(); //product id
            String m=brandsdao.setget(v);
            String h=productsDAO.setget(p);
            if(m.equals("null")||h.equals("null"))
            {
                System.out.println("Enter the Data and id Correctly by seeing the console");
                menudis();
            }
            else{
                //System.out.println(h+"    "+m);
                boolean f=shopdao.ispre(v,p);
                if(f)
                {
                    System.out.print("Yes We can buy  ");
                    System.out.print("Enter how much of "+h+" "+m+" you need?");
                    int count=sc.nextInt();
                    shopdao sm=new shopdao();
                    int c=sm.checkcount(v, p);
                  
                    int price=sm.price();
                    int tv=count*price;
                    sum=sum+(price*count);
                    if(c<count||c==-1)
                    {
                    System.out.print("we have no appropriate stock so please come after few days");
                    }
                    else
                    {
                        System.out.println("Can we proceed for shopping?");
                        int tp=sm.shop(v, p, count,id);
                        System.out.print(tp);
                        if(tp>0)
                        {
                            System.out.print("Do you want to continue shopping enter Y or N?");
                            if(sc.next().equals("Y"))
                            {
                                billsdao bd=new billsdao();
                                bd.generate(ad,p,count,tv,m+" "+h);
                                menudis();
                            }

                         else
                         {

                            billsdao bd=new billsdao();
                            bd.generate(ad,p,count,tv,m+" "+h);
                            menudis();
                         }
                        }
                        else
                        {
                             menudis();
                        }
          
                    }
                }
                else
                {
                    System.out.println("there is no such product here ,you can reach us after few days");
                    menudis();
                }
            }
        }
        if(t==3)
        {
                            billsdao bd=new billsdao();
                          //  System.out.println(ad.getId());
                            int am=bd.calc(ad.getId());
                            System.out.println("tot:"+am);
                            System.out.println(sum);
                          //  int amt=sc.nextInt();
                            if(am==sum)
                            {
                               if(bd.update(ad.getId())>=1)
                               {
                               System.out.println("You have completed your payment");
                               System.out.println("Payment Successful");
                               }
                            }
                            System.out.print("Thank You for Shopping");
       //   return;
        }
        if(t==4)
        return;
    }
}
