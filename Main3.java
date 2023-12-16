import java.util.Scanner;

import pack1.Books;
import pack2.Admin;
import pack3.Guest;

public class Main3 {

    static void access() {
        Scanner obj1 = new Scanner(System.in);
        System.out.println("Are you an admin or guest ? \n");
        String q1 = obj1.nextLine();
        if (q1.equals("admin")) {
            System.out.println("Would you like to login or register ?");
            String q10 = obj1.nextLine();
            if (q10.equals("register")) {
                Admin adm = new Admin();
                Main3.access();
            } else if (q10.equals("login")) {
                System.out.println("Enter your Username.");
                String Uname = obj1.nextLine();
                System.out.println("Enter your password");
                String pword = obj1.nextLine();

                for (int i = 0; i < Admin.count; i++) {

                    if (Uname.equals(Admin.admlist[i].Ausername) && pword.equals(Admin.admlist[i].Apassword)) {
                        System.out.println("What would you like to do ?");
                        System.out.println("1:add a book");
                        System.out.println("2:Display data of a book.");
                        System.out.println("3:Borrow a book");
                        System.out.println("4:Return a book");
                        System.out.println("5:Go back to the main menu.");
                        System.out.println("6:Commit Changes ?");
                        String q2 = obj1.nextLine();
                        if (q2.equals("1")) {
                            System.out.println("How many books would you like to add ?");
                            int q3 = obj1.nextInt();
                            for (i = 0; i < q3; i++) {
                                Books bk = new Books();
                                bk.createBooks();
                            }
                            Main3.access();
                        } else if (q2.equals("2")) {
                            System.out.println("Enter the name of the book you would like to see. \n");
                            String q4 = obj1.nextLine();
                            Books.Searchinf(q4);
                            Main3.access();
                        } else if (q2.equals("5")) {
                            Main3.access();
                        } else if (q2.equals("3")) {
                            Admin.borrow();
                            Main3.access();
                        } else if (q2.equals("4")) {
                            Admin.Return();
                            Main3.access();
                        }
                    } else {
                        System.out.println("you are not a admin");
                        Main3.access();
                    }
                }

            }
        } else if (q1.equals("guest")) {
            System.out.println("Would you like to login or register ?");
            String q12 = obj1.nextLine();
            if (q12.equals("register")) {
                Guest gst = new Guest();
                Main3.access();
            } else if (q12.equals("login")) {
                System.out.println("Enter your username");
                String uname = obj1.nextLine();
                System.out.println("Enter your password");
                String Pword = obj1.nextLine();

                for (int j = 0; j < Guest.sNum; j++) {

                    System.out.println(Guest.Guestlist[0].Gusername);
                    if (uname.equals(Guest.Guestlist[j].Gusername) && Pword.equals(Guest.Guestlist[j].Gpassword)) {
                        System.out.println("1:Borrow a book.");
                        System.out.println("2:Return a book");
                        System.out.println("3:Check info on book");
                        System.out.println("4:To go back to main menu");
                        System.out.println("5:Commit changes");
                        String q13 = obj1.nextLine();
                        if (q13.equals("3")) {
                            System.out.println("Enter the name of the book you would like to see. \n");
                            String q11 = obj1.nextLine();
                            Books.Searchinf(q11);
                            Main3.access();
                        } else if (q13.equals("1")) {
                            Guest.borrow();
                            Main3.access();
                        } else if (q13.equals("2")) {
                            Guest.Return();
                            Main3.access();
                        } else if (q13.equals("5")) {
                        } else if (q13.equals("4")) {
                            Main3.access();
                        }
                    } else {
                        System.out.println("Password is incorrect");
                        Main3.access();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Main3.access();
    }
}