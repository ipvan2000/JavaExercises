import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryCatalog<Integer> catalog = new LibraryCatalog<>();

        while (true) {
            System.out.println("\nLibrary Catalog System");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. View Catalog");
            System.out.println("4. Run Tests");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter item ID (integer): ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    catalog.addItem(new LibraryItem<>(title, author, id));
                    break;

                case 2:
                    System.out.print("Enter item ID to remove: ");
                    int removeID = scanner.nextInt();
                    catalog.removeItem(removeID);
                    break;

                case 3:
                    catalog.displayCatalog();
                    break;

                case 4:
                    System.out.println("\nRunning all tests...");
                    LibraryItem.runTests();
                    LibraryCatalog.runTests();
                    break;

                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
