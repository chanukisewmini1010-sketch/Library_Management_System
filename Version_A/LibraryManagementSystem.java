import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<User> users = new ArrayList<>();
        Library library = new Library();

        library.addBook(new Book(1, "Harry potter"));
        library.addBook(new Book(2, "Fairy tales"));

        while (true) {
            System.out.println("1.Register");
            System.out.println("2.Login");
            System.out.println("3.Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Username: ");
                String u = sc.next();
                System.out.print("Password: ");
                String p = sc.next();

                users.add(new User(u, p));
                System.out.println("Registered!");
            } else if (choice == 2) {
                System.out.print("Username: ");
                String u = sc.next();
                System.out.print("Password: ");
                String p = sc.next();

                boolean login = false;
                for (User user : users) {
                    if (user.username.equals(u) && user.password.equals(p)) {
                        login = true;
                        System.out.println("Login Success!");
                        while (true) {
                            System.out.println("\n--- Library Menu ---");
                            System.out.println("1.Add Book");
                            System.out.println("2.Show Books");
                            System.out.println("3.Issue Book");
                            System.out.println("4.Return Book");
                            System.out.println("5.Logout");

                            int c = sc.nextInt();

                            if (c == 1) {
                                System.out.print("Book ID: ");
                                int id = sc.nextInt();
                                System.out.print("Book Name: ");
                                String name = sc.next();

                                library.addBook(new Book(id, name));
                            }

                            else if (c == 2) {
                                library.showBooks();
                            }

                            else if (c == 3) {
                                System.out.print("Enter Book ID: ");
                                library.issueBook(sc.nextInt());
                            }

                            else if (c == 4) {
                                System.out.print("Enter Book ID: ");
                                library.returnBook(sc.nextInt());
                            }

                            else if (c == 5) {
                                break;
                            }
                        }
                    }
                }
                if (!login) {
                    System.out.println("Invalid Login!");
                }
            }
            else if (choice == 3) {
                break;
            }
        }
        sc.close();
    }
}