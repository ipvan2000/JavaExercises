import java.util.Scanner; // Importing Scanner to handle user input

/**
 * The LibraryManagement class serves as the main entry point for the Library Catalog System.
 * It provides a simple **command-line interface (CLI)** that allows users to:
 *  - Add items to the catalog
 *  - Remove items from the catalog
 *  - View the current catalog
 *  - Run built-in tests
 *  - Exit the application
 */
public class LibraryManagement {
    public static void main(String[] args) {
        // Create a Scanner object to read user input from the console
        Scanner scanner = new Scanner(System.in);

        // Create a LibraryCatalog instance to store books (IDs as Integer)
        LibraryCatalog<Integer> catalog = new LibraryCatalog<>();

        // Infinite loop to keep the program running until the user chooses to exit
        while (true) {
            // Display the menu options
            System.out.println("\nLibrary Catalog System");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. View Catalog");
            System.out.println("4. Run Tests");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            // Read the user's choice
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character to avoid input issues

            // Perform the corresponding action based on the user's choice
            switch (choice) {
                case 1:
                    // Option 1: Add a new item to the catalog
                    System.out.print("Enter item ID (integer): ");
                    int id = scanner.nextInt(); // Read item ID
                    scanner.nextLine(); // Consume newline character

                    System.out.print("Enter title: ");
                    String title = scanner.nextLine(); // Read title

                    System.out.print("Enter author: ");
                    String author = scanner.nextLine(); // Read author

                    // Create a new LibraryItem and add it to the catalog
                    catalog.addItem(new LibraryItem<>(title, author, id));
                    break;

                case 2:
                    // Option 2: Remove an item from the catalog
                    System.out.print("Enter item ID to remove: ");
                    int removeID = scanner.nextInt(); // Read ID of item to remove

                    // Remove the item from the catalog
                    catalog.removeItem(removeID);
                    break;

                case 3:
                    // Option 3: Display all items currently stored in the catalog
                    catalog.displayCatalog();
                    break;

                case 4:
                    // Option 4: Run built-in tests for LibraryItem and LibraryCatalog
                    System.out.println("\nRunning all tests...");
                    LibraryItem.runTests(); // Test LibraryItem class
                    LibraryCatalog.runTests(); // Test LibraryCatalog class
                    break;

                case 5:
                    // Option 5: Exit the program
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close(); // Close the Scanner object to prevent resource leaks
                    return; // Exit the main method and stop the program

                default:
                    // If the user enters an invalid option, display an error message
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}