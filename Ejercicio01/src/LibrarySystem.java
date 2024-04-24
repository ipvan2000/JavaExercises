import java.util.*;

// Book class representing a book with title, author, and quantity
class Book {
    String title;
    String author;
    int quantity;

    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }
}

public class LibrarySystem {
    private static Map<String, Book> library = new HashMap<>(); // Map to store books
    private static Scanner scanner = new Scanner(System.in); // Scanner for user input

    public static void main(String[] args) {
        while (true) {
            displayMenu(); // Display menu options
            int choice = getChoice(); // Get user choice
            switch (choice) {
                case 1:
                    addBooks(); // Add books option
                    break;
                case 2:
                    borrowBooks(); // Borrow books option
                    break;
                case 3:
                    returnBooks(); // Return books option
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!"); // Exit program option
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4."); // Invalid choice
            }
        }
    }

    // Display menu options
    private static void displayMenu() {
        System.out.println("Library System Menu:");
        System.out.println("1. Add Books");
        System.out.println("2. Borrow Books");
        System.out.println("3. Return Books");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    // Get user choice
    private static int getChoice() {
        return scanner.nextInt();
    }

    // Add books to the library
    private static void addBooks() {
        scanner.nextLine(); // consume newline
        Book book = createBook(); // Create book object from user input
        library.put(book.title, book); // Add book to library
        System.out.println("Book added successfully: " + book.title);
    }

    // Create a new book object from user input
    private static Book createBook() {
        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the author: ");
        String author = scanner.nextLine();
        System.out.print("Enter the quantity: ");
        int quantity = scanner.nextInt();
        return new Book(title, author, quantity); // Return new book object
    }

    // Borrow books from the library
    private static void borrowBooks() {
        scanner.nextLine(); // consume newline
        String title = getBookTitle(); // Get book title from user
        int quantity = getBookQuantity(); // Get quantity from user
        Book book = library.get(title); // Retrieve book from library
        if (book == null) {
            System.out.println("Book not found in the library.");
            return;
        }
        if (book.quantity >= quantity) {
            book.quantity -= quantity;
            System.out.println("Books borrowed successfully: " + title);
        } else {
            System.out.println("Insufficient quantity. Requested quantity not available.");
        }
    }

    // Get book title from user
    private static String getBookTitle() {
        System.out.print("Enter the book title: ");
        return scanner.nextLine();
    }

    // Get quantity of books from user
    private static int getBookQuantity() {
        System.out.print("Enter the number of books to borrow: ");
        return scanner.nextInt();
    }

    // Return books to the library
    private static void returnBooks() {
        scanner.nextLine(); // consume newline
        String title = getBookTitle(); // Get book title from user
        int quantity = getBookQuantity(); // Get quantity from user
        Book book = library.get(title); // Retrieve book from library
        if (book == null) {
            System.out.println("Book not found in the library.");
            return;
        }
        book.quantity += quantity;
        System.out.println("Books returned successfully: " + title);
    }
}