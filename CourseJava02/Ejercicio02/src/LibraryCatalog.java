import java.util.*; // Importing necessary Java utilities for lists and iterators

/**
 * A generic catalog class that stores and manages library items.
 * This class can handle different types of items using generics.
 * 
 * @param <T> The type of item ID (e.g., Integer, String)
 */
public class LibraryCatalog<T> {
    // List to store library items
    private List<LibraryItem<T>> items;

    /**
     * Constructor initializes the list of library items.
     */
    public LibraryCatalog() {
        items = new ArrayList<>();
    }

    /**
     * Adds an item to the catalog.
     *
     * @param item The LibraryItem object to be added
     */
    public void addItem(LibraryItem<T> item) {
        items.add(item);
        System.out.println("Item added successfully: " + item);
    }

    /**
     * Removes an item from the catalog based on its ID.
     * If the item is not found, an error message is displayed.
     *
     * @param itemID The ID of the item to be removed
     */
    public void removeItem(T itemID) {
        Iterator<LibraryItem<T>> iterator = items.iterator();

        // Loop through the catalog to find and remove the item
        while (iterator.hasNext()) {
            LibraryItem<T> item = iterator.next();
            if (item.getItemID().equals(itemID)) {
                iterator.remove(); // Remove the item if the ID matches
                System.out.println("Item removed successfully: " + item);
                return; // Exit the method after successful removal
            }
        }
        // Display error message if item is not found
        System.out.println("Error: Item with ID " + itemID + " not found.");
    }

    /**
     * Retrieves an item from the catalog using its ID.
     *
     * @param itemID The ID of the item to retrieve
     * @return The LibraryItem object if found, otherwise null
     */
    public LibraryItem<T> getItem(T itemID) {
        for (LibraryItem<T> item : items) {
            if (item.getItemID().equals(itemID)) {
                return item; // Return the found item
            }
        }
        return null; // Return null if no matching item is found
    }

    /**
     * Displays all items currently stored in the catalog.
     * If the catalog is empty, it notifies the user.
     */
    public void displayCatalog() {
        if (items.isEmpty()) {
            System.out.println("The catalog is empty.");
        } else {
            for (LibraryItem<T> item : items) {
                System.out.println(item);
            }
        }
    }

    /**
     * Runs test cases for the LibraryCatalog class.
     * This method tests adding, retrieving, and removing items.
     */
    public static void runTests() {
        System.out.println("\n==== Running LibraryCatalog Tests ====");
        
        // Create a catalog instance for Integer IDs
        LibraryCatalog<Integer> catalog = new LibraryCatalog<>();

        // Test 1: Adding items
        System.out.println("\nTest 1: Adding items to the catalog");
        LibraryItem<Integer> book1 = new LibraryItem<>("1984", "George Orwell", 1);
        LibraryItem<Integer> book2 = new LibraryItem<>("Brave New World", "Aldous Huxley", 2);
        catalog.addItem(book1);
        catalog.addItem(book2);

        // Test 2: Retrieving an item
        System.out.println("\nTest 2: Retrieving an existing item");
        System.out.println("Expected: " + book1);
        System.out.println("Actual: " + catalog.getItem(1));

        // Test 3: Removing an existing item
        System.out.println("\nTest 3: Removing an item");
        catalog.removeItem(1);
        System.out.println("Expected: Error when retrieving ID 1 (should be null)");
        System.out.println("Actual: " + catalog.getItem(1));

        // Test 4: Attempting to remove a non-existent item
        System.out.println("\nTest 4: Attempting to remove a non-existent item");
        catalog.removeItem(99);
    }
}
