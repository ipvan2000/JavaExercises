import java.util.Scanner;

public class StudentRecordManagementSystem {

    static int totalStudents = 0; // Variable to store the total number of students
    static Student[] students = new Student[100]; // Array to store student objects (assuming a maximum of 100 students)
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        // Main menu loop
        do {
            System.out.println("Welcome to Student Record Management System");
            System.out.println("1. Add New Student");
            System.out.println("2. Update Student Information");
            System.out.println("3. View Student Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    addNewStudent(scanner);
                    break;
                case 2:
                    updateStudentInformation(scanner);
                    break;
                case 3:
                    viewStudentDetails(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);
        
        scanner.close();
    }
    
    // Method to add a new student
    public static void addNewStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.next();
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        System.out.print("Enter student grade: ");
        int grade = scanner.nextInt();
        
        // Create a new Student object and add it to the array
        students[totalStudents++] = new Student(name, id, age, grade);
        System.out.println("Student added successfully!");
    }
    
    // Method to update student information
    public static void updateStudentInformation(Scanner scanner) {
        System.out.print("Enter student ID to update information: ");
        int id = scanner.nextInt();
        
        // Search for the student with the given ID
        for (int i = 0; i < totalStudents; i++) {
            if (students[i].getId() == id) {
                System.out.print("Enter new name: ");
                students[i].setName(scanner.next());
                System.out.print("Enter new age: ");
                students[i].setAge(scanner.nextInt());
                System.out.print("Enter new grade: ");
                students[i].setGrade(scanner.nextInt());
                System.out.println("Student information updated successfully!");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }
    
    // Method to view student details
    public static void viewStudentDetails(Scanner scanner) {
        System.out.print("Enter student ID to view details: ");
        int id = scanner.nextInt();
        
        // Search for the student with the given ID
        for (int i = 0; i < totalStudents; i++) {
            if (students[i].getId() == id) {
                System.out.println("Student Details:");
                System.out.println("Name: " + students[i].getName());
                System.out.println("ID: " + students[i].getId());
                System.out.println("Age: " + students[i].getAge());
                System.out.println("Grade: " + students[i].getGrade());
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }
}

// Student class to store student information
class Student {
    private String name;
    private int id;
    private int age;
    private int grade;
    
    // Constructor
    public Student(String name, int id, int age, int grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grade = grade;
    }
    
    // Getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
