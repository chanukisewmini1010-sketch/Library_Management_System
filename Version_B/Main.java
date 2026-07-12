import java.util.ArrayList;
import java.util.Scanner;

    // Main class (menu + login system)
    public class Main {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            Library library = new Library();

            ArrayList<User> users = new ArrayList<>();

            // Load saved books
            library.setBooks(FileManager.loadBooks());

            while (true) {

                System.out.println("\n==== LOGIN SYSTEM ====");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");

                int choice;

                try {
                    choice = Integer.parseInt(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Invalid input!");
                    continue;
                }

                // REGISTER
                if (choice == 1) {
                    System.out.print("Username: ");
                    String u = sc.nextLine();
                    System.out.print("Password: ");
                    String p = sc.nextLine();

                    users.add(new User(u, p));
                    System.out.println("Registered successfully!");
                }

                // LOGIN
                else if (choice == 2) {

                    System.out.print("Username: ");
                    String u = sc.nextLine();
                    System.out.print("Password: ");
                    String p = sc.nextLine();

                    boolean login = false;

                    for (User user : users) {
                        if (user.getUsername().equals(u) &&
                                user.getPassword().equals(p)) {
                            login = true;
                            System.out.println("Login successful!");

                            // LIBRARY MENU
                            while (true) {

                                System.out.println("\n==== LIBRARY MENU ====");
                                System.out.println("1. Add Book");
                                System.out.println("2. Search Book");
                                System.out.println("3. Update Book");
                                System.out.println("4. Delete Book");
                                System.out.println("5. Display Books");
                                System.out.println("6. Issue Book");
                                System.out.println("7. Return Book");
                                System.out.println("8. Save & Logout");

                                int c;

                                try {
                                    c = Integer.parseInt(sc.nextLine());
                                } catch (Exception e) {
                                    System.out.println("Invalid input!");
                                    continue;
                                }

                                if (c == 1) {
                                    System.out.print("ID: ");
                                    String id = sc.nextLine();
                                    System.out.print("Title: ");
                                    String title = sc.nextLine();
                                    System.out.print("Author: ");
                                    String author = sc.nextLine();

                                    library.addBook(new Book(id, title, author));
                                }

                                else if (c == 2) {
                                    System.out.print("Enter ID: ");
                                    Book b = library.searchBook(sc.nextLine());
                                    System.out.println(b != null ? b : "Not found");
                                }

                                else if (c == 3) {
                                    System.out.print("ID: ");
                                    String id = sc.nextLine();
                                    System.out.print("New Title: ");
                                    String t = sc.nextLine();
                                    System.out.print("New Author: ");
                                    String a = sc.nextLine();

                                    library.updateBook(id, t, a);
                                }

                                else if (c == 4) {
                                    System.out.print("ID: ");
                                    library.deleteBook(sc.nextLine());
                                }

                                else if (c == 5) {
                                    library.displayBooks();
                                }

                                else if (c == 6) {
                                    System.out.print("ID: ");
                                    library.issueBook(sc.nextLine());
                                }

                                else if (c == 7) {
                                    System.out.print("ID: ");
                                    library.returnBook(sc.nextLine());
                                }

                                else if (c == 8) {
                                    FileManager.saveBooks(library.getBooks());
                                    System.out.println("Logged out...");
                                    break;
                                }
                            }
                        }
                    }

                    if (!login) {
                        System.out.println("Invalid login!");
                    }
                }

                else if (choice == 3) {
                    System.out.println("Exiting system...");
                    break;
                }
            }

            sc.close();
        }
    }

