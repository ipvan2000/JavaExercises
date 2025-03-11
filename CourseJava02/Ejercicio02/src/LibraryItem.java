/**
 * The LibraryItem class represents an individual item in a library catalog.
 * This class is generic and can store different types of library items such as books, DVDs, and magazines.
 * 
 * @param <T> The type of item ID (can be Integer, String, or any other type)
 */
public class LibraryItem<T> {
    // Attributes of the library item
    private String title;  // Title of the item (book, DVD, magazine, etc.)
    private String author; // Author or creator of the item
    private T itemID;      // Unique identifier for the item, defined as a generic type T

    /**
     * Constructor for the LibraryItem class.
     * Initializes the title, author, and item ID for the library item.
     *
     * @param title  The title of the item
     * @param author The author or creator of the item
     * @param itemID The unique identifier of the item (can be Integer, String, etc.)
     */
    public LibraryItem(String title, String author, T itemID) {
        this.title = title;
        this.author = author;
        this.itemID = itemID;
    }

    /**
     * Retrieves the title of the library item.
     * 
     * @return The title of the item
     */
    public String getTitle() {
        return title;
    }

    /**
     * Retrieves the author of the library item.
     * 
     * @return The author of the item
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Retrieves the unique identifier of the library item.
     * 
     * @return The item ID (can be Integer, String, etc.)
     */
    public T getItemID() {
        return itemID;
    }

    /**
     * Overrides the default toString() method to provide a formatted string representation of the library item.
     * 
     * @return A string containing the item ID, title, and author.
     */
    @Override
    public String toString() {
        return "ID: " + itemID + ", Title: " + title + ", Author: " + author;
    }

    /**
     * Runs test cases to verify the functionality of the LibraryItem class.
     * This method tests the creation of different library items and their string representation.
     */
    public static void runTests() {
        System.out.println("\n==== Running LibraryItem Tests ====");

        // Test 1: Creating a book item with an Integer ID
        System.out.println("\nTest 1: Creating a LibraryItem (Book with Integer ID)");
        LibraryItem<Integer> book = new LibraryItem<>("The Hobbit", "J.R.R. Tolkien", 101);
        System.out.println("Expected: ID: 101, Title: The Hobbit, Author: J.R.R. Tolkien");
        System.out.println("Actual: " + book);

        // Test 2: Creating a DVD item with a String ID
        System.out.println("\nTest 2: Creating a DVD with a String ID");
        LibraryItem<String> dvd = new LibraryItem<>("Inception", "Christopher Nolan", "D001");
        System.out.println("Expected: ID: D001, Title: Inception, Author: Christopher Nolan");
        System.out.println("Actual: " + dvd);
    }
}
