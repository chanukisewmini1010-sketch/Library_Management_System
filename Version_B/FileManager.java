import java.io.*;
import java.util.ArrayList;

    // Handles file saving and loading
    public class FileManager {

        private static final String FILE_NAME = "books.txt";

        // Save books to file
        public static void saveBooks(ArrayList<Book> books) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
                out.writeObject(books);
                System.out.println("Data saved successfully!");
            } catch (IOException e) {
                System.out.println("Error saving file: " + e.getMessage());
            }
        }

        // Load books from file
        public static ArrayList<Book> loadBooks() {
            File file = new File(FILE_NAME);

            if (!file.exists()) {
                return new ArrayList<>();
            }

            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
                return (ArrayList<Book>) in.readObject();
            } catch (Exception e) {
                System.out.println("Error loading file. Starting fresh.");
                return new ArrayList<>();
            }
        }
    }

