# Library Catalog System

## Overview
This project implements a **generic library catalog system** in Java, allowing users to manage different types of library items such as books, DVDs, and magazines. The implementation utilizes **generics** to provide flexibility and **code reusability**.

The system consists of three main components:
1. **LibraryItem<T>**: A generic class representing a library item.
2. **LibraryCatalog<T>**: A generic catalog class that manages library items.
3. **LibraryManagement**: A command-line interface for user interaction.

## Features
✔ **Generic Classes**: LibraryItem and LibraryCatalog use generics to handle multiple data types.  
✔ **CRUD Operations**: Users can add, remove, and view items in the catalog.  
✔ **Exception Handling**: Prevents errors when removing non-existent items.  
✔ **Command-Line Interface**: Interactive menu for user interaction.  
✔ **Built-in Tests**: Runs simple tests without requiring JUnit.  

---

## 1. Implementation Details

### **LibraryItem<T> Class**
The `LibraryItem<T>` class represents an item in the catalog. It has the following attributes:
- `title`: The title of the item.
- `author`: The author of the item.
- `itemID`: A generic ID to support different data types.

#### **Code Implementation:**
```java
public class LibraryItem<T> {
    private String title;
    private String author;
    private T itemID;

    public LibraryItem(String title, String author, T itemID) {
        this.title = title;
        this.author = author;
        this.itemID = itemID;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public T getItemID() { return itemID; }

    @Override
    public String toString() {
        return "ID: " + itemID + ", Title: " + title + ", Author: " + author;
    }
}
```

---

### **LibraryCatalog<T> Class**
The `LibraryCatalog<T>` class acts as a **generic catalog**, storing and managing library items.

#### **Implemented Methods:**
- `addItem(LibraryItem<T> item)`: Adds an item to the catalog.
- `removeItem(T itemID)`: Removes an item by its ID.
- `getItem(T itemID)`: Retrieves an item by its ID.
- `displayCatalog()`: Displays all items in the catalog.

#### **Code Implementation:**
```java
import java.util.*;

public class LibraryCatalog<T> {
    private List<LibraryItem<T>> items;

    public LibraryCatalog() { items = new ArrayList<>(); }

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
            if (item.getItemID().equals(itemID)) return item;
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
}
```

---

### **LibraryManagement Class (CLI Interface)**
The `LibraryManagement` class provides a **menu-driven command-line interface** for users.

#### **User Options:**
1. **Add Item**: Adds an item to the catalog.
2. **Remove Item**: Deletes an item by ID.
3. **View Catalog**: Displays all catalog items.
4. **Run Tests**: Runs built-in test cases.
5. **Exit**: Closes the program.

#### **Code Implementation:**
```java
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
```

---

## **2. Compilation & Execution**

### **Step 1: Compile the Program**
Run the following command to compile all `.java` files:
```sh
javac LibraryItem.java LibraryCatalog.java LibraryManagement.java
```

### **Step 2: Run the Program**
```sh
java LibraryManagement
```

---

## **3. Testing the System**
The program includes **built-in tests** that check core functionalities.

### **Test Scenarios**
✅ **Adding Items**  
✅ **Removing Items**  
✅ **Handling Non-Existent Items**  
✅ **Retrieving Items**  
✅ **Displaying the Catalog**  

### **Running Tests**
From the menu, select option **4 (Run Tests)** to execute all tests.

---

## **4. Summary**
- **Modular Design**: The system is divided into classes for better code organization.
- **Generic Programming**: Uses `<T>` to allow different item types.
- **Exception Handling**: Prevents crashes when removing missing items.
- **Command-Line Interface**: Simple and interactive.

🚀 **Ready to use and extend!**  
