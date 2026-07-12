import java.util.ArrayList;

    // Library class handles all book operations
    public class Library {

        private ArrayList<Book> books = new ArrayList<>();

        // Add book
        public void addBook(Book book) {
            books.add(book);
            System.out.println("Book added successfully!");
        }

        // Search book
        public Book searchBook(String id) {
            for (Book b : books) {
                if (b.getId().equalsIgnoreCase(id)) {
                    return b;
                }
            }
            return null;
        }

        // Update book
        public void updateBook(String id, String title, String author) {
            Book b = searchBook(id);
            if (b != null) {
                b.setTitle(title);
                b.setAuthor(author);
                System.out.println("Book updated successfully!");
            } else {
                System.out.println("Book not found!");
            }
        }

        // Delete book
        public void deleteBook(String id) {
            Book b = searchBook(id);
            if (b != null) {
                books.remove(b);
                System.out.println("Book deleted successfully!");
            } else {
                System.out.println("Book not found!");
            }
        }

        // Issue book
        public void issueBook(String id) {
            Book b = searchBook(id);
            if (b != null && !b.isIssued()) {
                b.setIssued(true);
                System.out.println("Book issued successfully!");
            } else {
                System.out.println("Book not available!");
            }
        }

        // Return book
        public void returnBook(String id) {
            Book b = searchBook(id);
            if (b != null && b.isIssued()) {
                b.setIssued(false);
                System.out.println("Book returned successfully!");
            } else {
                System.out.println("Invalid return!");
            }
        }

        // Display books
        public void displayBooks() {
            if (books.isEmpty()) {
                System.out.println("No books available.");
                return;
            }

            for (Book b : books) {
                System.out.println(b);
            }
        }

        public ArrayList<Book> getBooks() {
            return books;
        }

        public void setBooks(ArrayList<Book> books) {
            this.books = books;
        }
    }

