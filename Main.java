import java.util.InputMismatchException;
import java.util.Scanner;
import pack1.Books;
import pack2.Admin;
import pack3.Guest;

public class Main {

    static void Start() {
        Scanner obj = new Scanner(System.in);
        System.out.println("WELCOME TO THE MAIN MENU");
        System.out.println("WOULD YOU LIKE TO LOGIN AS: \n PRESS 1) ADMIN \n PRESS 2) GUEST ");
        String q1 = obj.nextLine();
        if (q1.equals("1")) {
            Main.Ad();
        } else if (q1.equals("2")) {
            Main.Gt();
        } else {
            System.out.println("INVALID INPUT \n PLEASE TYPE (1) or (2) \n");
            Main.Start();
        }
    }

    static void Ad() {
        Scanner obj = new Scanner(System.in);
        System.out.println("WOULD YOU LIKE TO: \n PRESS 1) LOGIN \n PRESS 2) REGISTER \n PRESS 3) GO BACK TO START");
        String q2 = obj.nextLine();
        if (q2.equals("1")) {
            System.out.println("ENTER YOUR USERNAME.");
            String Uname = obj.nextLine();
            System.out.println("ENTER YOUR PASSWORD");
            String pword = obj.nextLine();
            if (Admin.count == 0) {
                System.out.println("YOU DIDNT CREATE A USER FIRST");
                Main.Ad();
            } else {
                for (int b = 0; b < Admin.count; b++) {
                    if (Uname.equalsIgnoreCase(Admin.admlist[b].Ausername) && pword.equalsIgnoreCase(Admin.admlist[b].Apassword)) {
                        System.out.println("CONGRATS YOU HAVE LOGGED IN");
                        Main.Adlog();
                    } else {
                        System.out.println(
                                "INCORRECT PASSWORD OR LOGIN (TRY AGAIN) ");
                        Main.Ad();
                    }
                }
            }
        }
        if (q2.equals("2")) {
            Admin adm = new Admin();
            Main.Adlog();
        }
    }

    static void Adlog() {
        Scanner obj = new Scanner(System.in);
        System.out.println("WHAT WOULD YOU LIKE TO DO ?");
        System.out.println("1:ADD A BOOK");
        System.out.println("2:DISPLAY DATA OF A BOOK.");
        System.out.println("3:BORROW A BOOK");
        System.out.println("4:RETURN A BOOK");
        System.out.println("5:GO BACK TO THE PREVIOUS MENU.");
        System.out.println("6:GO BACK TO MAIN MENU");
        String q2 = obj.nextLine();
        if (q2.equals("1")) {
            int q10 = -1;
            while (true) {
                System.out.println("HOW MANY BOOKS WOULD YOU LIKE TO ADD ?");

                try {
                    q10 = obj.nextInt();
                    obj.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("PLEASE ENTER A NUMBER");
                    obj.nextLine();
                }
            }

            for (int i = 0; i < q10; i++) {
                Books bk = new Books();
                bk.createBooks();
            }
            Main.Adlog();
        } else if (q2.equals("2")) {
            System.out.println("ENTER THE NAME OF THE BOOK YOU WOULD LIKE TO SEE. \n");
            String q4 = obj.nextLine();
            Books.Searchinf(q4);
            Main.Adlog();
        } else if (q2.equals("5")) {
            Main.Ad();
        } else if (q2.equals("3")) {
            Admin.borrow();
            Main.Ad();
        } else if (q2.equals("4")) {
            Admin.Return();
            Main.Adlog();
        } else if (q2.equals("6")) {
            Main.Start();
        } 
        else {
            System.out.println("TRY TYPING ONE OF THE NUMBERS");
            Main.Adlog();
        }
    }

    static void Gt() {
        Scanner obj = new Scanner(System.in);
        System.out.println("WOULD YOU LIKE TO: \n PRESS 1) LOGIN \n PRESS 2) REGISTER \n PRESS 3) GO BACK TO START");
        String q3 = obj.nextLine();
        if (q3.equals("1")) {
            System.out.println("ENTER YOUR USERNAME");
            String uname = obj.nextLine();
            System.out.println("ENTER YOUR PASSWORD");
            String Pword = obj.nextLine();
            if (Guest.sNum == 0) {
                System.out.println("TRY CREATING AN ACCOUNT FIRST");
                Main.Gt();
            } else {
                for (int j = 0; j < Guest.sNum; j++) {
                    if (uname.equalsIgnoreCase(Guest.Guestlist[j].Gusername) && Pword.equalsIgnoreCase(Guest.Guestlist[j].Gpassword)) {
                        System.out.println("CONGRATS YOU LOGGED IN");
                        Main.Gtlog();
                    } else {
                        System.out.println("USERNAME OR PASSWORD IS INCORRECT TRY AGAIN");
                        Main.Gt();
                    }
                }
            }
        } else if (q3.equals("2")) {
            Guest gst = new Guest();
            Main.Gtlog();
        }
    }

    static void Gtlog() {
        Scanner obj = new Scanner(System.in);
        System.out.println("1:BORROW A BOOK.");
        System.out.println("2:RETURN A BOOK");
        System.out.println("3:CHECK INFO ON A BOOK");
        System.out.println("4:GO BACK TO THE PREVIOUS MENU");
        System.out.println("5:GO BACK TO THE MAIN MENU");
        String q13 = obj.nextLine();
        if (q13.equals("3")) {
            System.out.println("ENTER THE NAME OF THE BOOK YOU WOULD LIKE TO SEE. \n");
            String q11 = obj.nextLine();
            Books.Searchinf(q11);
            Main.Gtlog();
        } else if (q13.equals("1")) {
            Guest.borrow();
            Main.Gtlog();
        } else if (q13.equals("2")) {
            Guest.Return();
            Main.Gtlog();
        } else if (q13.equals("5")) {
            Main.Start();
        } else if (q13.equals("4")) {
            Main.Gt();
        }
    }

    public static void main(String[] args) {
        System.out.println("______________________________________________________");
        System.out.println("|WELCOME TO A LIBRARY SYSTEM IMPLEMENTING OBJECT ARRAY|");
        System.out.println("______________________________________________________");
        Main.Start();
    }
}