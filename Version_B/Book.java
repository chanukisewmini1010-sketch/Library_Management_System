import java.io.Serializable;

    // Book class represents a library book
    public class Book implements Serializable {

        private String id;
        private String title;
        private String author;
        private boolean issued;

        // Constructor
        public Book(String id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.issued = false;
        }

        // Getters
        public String getId() { return id; }
        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        public boolean isIssued() { return issued; }

        // Setters
        public void setTitle(String title) { this.title = title; }
        public void setAuthor(String author) { this.author = author; }
        public void setIssued(boolean issued) { this.issued = issued; }

        @Override
        public String toString() {
            return id + " | " + title + " | " + author +
                    " | " + (issued ? "Issued" : "Available");
        }
    }

