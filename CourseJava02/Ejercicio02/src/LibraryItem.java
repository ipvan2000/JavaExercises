public class LibraryItem<T> {
    private String title;
    private String author;
    private T itemID;

    public LibraryItem(String title, String author, T itemID) {
        this.title = title;
        this.author = author;
        this.itemID = itemID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public T getItemID() {
        return itemID;
    }

    @Override
    public String toString() {
        return "ID: " + itemID + ", Title: " + title + ", Author: " + author;
    }

    // Test method for LibraryItem class
    public static void runTests() {
        System.out.println("\n==== Running LibraryItem Tests ====");

        // Test 1: Creating a book item
        LibraryItem<Integer> book = new LibraryItem<>("The Hobbit", "J.R.R. Tolkien", 101);
        System.out.println("Test 1: Creating a LibraryItem");
        System.out.println("Expected: ID: 101, Title: The Hobbit, Author: J.R.R. Tolkien");
        System.out.println("Actual: " + book);

        // Test 2: Creating a DVD item with String ID
        LibraryItem<String> dvd = new LibraryItem<>("Inception", "Christopher Nolan", "D001");
        System.out.println("\nTest 2: Creating a DVD with String ID");
        System.out.println("Expected: ID: D001, Title: Inception, Author: Christopher Nolan");
        System.out.println("Actual: " + dvd);
    }
}
