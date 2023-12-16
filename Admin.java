package pack2;

import java.util.Scanner;
import pack1.*;

public class Admin extends Books{
    public String Ausername;
    public String Apassword;
    public static String bkAname = " ";
    public static int count;
    static Scanner obj3 = new Scanner(System.in);

    public static void borrow() {
        System.out.println("Which book would you like to borrow? ");
        String x = obj3.nextLine();
        for (int i = 0; i < Snumber; i++) {
            if (Booklist[i].Bname.equals(x) && !Booklist[i].borrowed) {
                Booklist[i].borrowed = true;
                bkAname = Booklist[i].Bname;
                System.out.println("You borrowed the book.");
            } else if (Booklist[i].Bname.equals(x) && Booklist[i].borrowed) {
                System.out.println("Book is already taken!");
            }
        }
    }

    public static void Return() {
        System.out.println("Which book would you like to return?");
        String x = obj3.nextLine();
        for (int i = 0; i < Snumber; i++) {
            if (Booklist[i].Bname.equals(x) && !Booklist[i].borrowed) {
                System.out.println("You did not borrow the book.");
                Booklist[i].Bname = " ";
            } else if (Booklist[i].Bname.equals(x) && Booklist[i].borrowed) {
                Booklist[i].borrowed = false;
                System.out.println("Book is returned!");
            }
        }
    }

    static Scanner obj1 = new Scanner(System.in);
    public static Admin[] admlist = new Admin[100];

    public Admin() {
        System.out.println("Enter Username: ");
        Ausername = obj1.nextLine();
        System.out.println("Enter your password: ");
        Apassword = obj1.nextLine();
        admlist[count] = this;
        count++;
    }

    static {
        count = 0;
    }
}
