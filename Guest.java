package pack3;

import java.util.Scanner;

import pack2.Admin;
import pack1.Books;

public class Guest extends Books{
    public String Gpassword;
    public String Gusername;
    public static String bkGname = " ";
    static Scanner ob = new Scanner(System.in);
    public static Guest[] Guestlist = new Guest[100];
    public static int sNum;

    public Guest() {
        System.out.println("Enter your name:");
        Gusername = ob.nextLine();
        System.out.println("Enter your password:");
        Gpassword = ob.nextLine();
        Guestlist[sNum] = this;
        sNum++;
    }

    public static void borrow() {
        System.out.println("Which book would you like to borrow ? ");
        String x = ob.nextLine();
        for (int i = 0; i < Snumber; i++) {
            if (Booklist[i].Bname.equals(x) && Booklist[i].borrowed == false) {
                Booklist[i].borrowed = true;
                bkGname = Booklist[i].Bname;
                System.out.println("You borrowed the book.");
            } else if (Booklist[i].Bname.equals(x) && Booklist[i].borrowed == true) {
                System.out.println("Book is already taken!");
            }
        }
    }

    public static void Return() {
        System.out.println("Which book would you like to return ?");
        String x = ob.nextLine();
        for (int i = 0; i < Snumber; i++) {
            if (Booklist[i].Bname.equals(x) && Booklist[i].borrowed == false) {
                System.out.println("You  did not borrow the book.");
            } else if (Booklist[i].Bname.equals(x) && Booklist[i].borrowed == true) {
                Booklist[i].borrowed = false;
                System.out.println("Book is returned !");
                bkGname = " ";
            }
        }
    }

    static {
        sNum = 0;
    }

}
