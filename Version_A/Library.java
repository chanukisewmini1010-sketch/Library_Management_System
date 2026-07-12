import java.util.ArrayList;

class Library {
    ArrayList<Book> books = new ArrayList<>();
    void addBook(Book b) {
        books.add(b);
    }
    void showBooks() {
        for (Book b : books) {
            System.out.println(b.id + " " + b.name +
                    (b.issued ? " (Issued)" : " (Available)"));
        }
    }
    void issueBook(int id) {
        for (Book b : books) {
            if (b.id == id && !b.issued) {
                b.issued = true;
                System.out.println("Book Issued");
                return;
            }
        }
        System.out.println("Book Not Available");
    }
    void returnBook(int id) {
        for (Book b : books) {
            if (b.id == id && b.issued) {
                b.issued = false;
                System.out.println("Book Returned");
                return;
            }
        }
        System.out.println("Invalid Return");
    }
}
