package pack1;

import java.util.Scanner;

public class Books {
    public String Bname;
    String BRdate;
    String Genre;
    String Summary;
    public boolean borrowed = false;
    int Id;
    public static int Snumber;
    public static Books[] Booklist = new Books[100];
    static Scanner obj1 = new Scanner(System.in);

    public void createBooks() {
        System.out.println("enter the name of the book.\n");
        Bname = obj1.nextLine();
        this.Bname = Bname;
        System.out.println("When did it release ?\n");
        BRdate = obj1.nextLine();
        this.BRdate = BRdate;
        System.out.println("What is the Genre of the book ?\n");
        Genre = obj1.nextLine();
        this.Genre = Genre;
        System.out.println("Would you like to add a summary ?(yes/no)\n");
        String q1 = obj1.nextLine();
        if (q1.equals("yes")) {
            System.out.println("Enter the summary.\n");
            Summary = obj1.nextLine();
            this.Summary = Summary;
        } else if (q1.equals("no")) {
            System.out.println("you chose not to add a summary.\n");
        } else {
            System.out.println("Invalid");
        }
        Booklist[Snumber] = this;
        Snumber++;
    }

    void Display() {
        System.out.println("Name: " + this.Bname);
        System.out.println("Release Date: " + this.BRdate);
        System.out.println("Genre: " + this.Genre);
        if (this.Summary.equals(" ")) {
            System.out.println("No Summary given.");
        } else {
            System.out.println("There is no summary. ");
        }
        if (borrowed) {
            System.out.println("This book is already taken.");
        } else if (borrowed == false) {
            System.out.println("You may borrow this book.");
        }
    }

    public static void Searchinf(String a) {
        for (int i = 0; i < Snumber; i++) {
            if (Booklist[i].Bname.equals(a)) {
                Booklist[i].Display();
            }
        }
    }

    public static void Searchinf(int a) {
        for (int i = 0; i < Snumber; i++) {
            if (Booklist[i].Id == a) {
                Booklist[i].Display();
            }
        }
    }

    static {
        Snumber = 0;
    }
}
