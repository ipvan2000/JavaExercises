import java.util.*;

public class LibraryCatalog<T> {
    private List<LibraryItem<T>> items;

    public LibraryCatalog() {
        items = new ArrayList<>();
    }

    public void addItem(LibraryItem<T> item) {
        items.add(item);
        System.out.println("Item added successfully: " + item);
    }

    public void removeItem(T itemID) {
        Iterator<LibraryItem<T>> iterator = items.iterator();
        while (iterator.hasNext()) {
            LibraryItem<T> item = iterator.next();
            if (item.getItemID().equals(itemID)) {
                iterator.remove();
                System.out.println("Item removed successfully: " + item);
                return;
            }
        }
        System.out.println("Error: Item with ID " + itemID + " not found.");
    }

    public LibraryItem<T> getItem(T itemID) {
        for (LibraryItem<T> item : items) {
            if (item.getItemID().equals(itemID)) {
                return item;
            }
        }
        return null;
    }

    public void displayCatalog() {
        if (items.isEmpty()) {
            System.out.println("The catalog is empty.");
        } else {
            for (LibraryItem<T> item : items) {
                System.out.println(item);
            }
        }
    }

    // Test method for LibraryCatalog class
    public static void runTests() {
        System.out.println("\n==== Running LibraryCatalog Tests ====");
        
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
