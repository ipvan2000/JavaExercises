import java.util.Scanner;

public class AdminInterface {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addNewCourse();
                    break;
                case 2:
                    enrollStudentInCourse();
                    break;
                case 3:
                    assignGradeToStudent();
                    break;
                case 4:
                    calculateStudentOverallGrade();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to display the menu options
    private static void showMenu() {
        System.out.println("\n=== Course Enrollment and Grade Management System ===");
        System.out.println("1. Add a new course");
        System.out.println("2. Enroll a student in a course");
        System.out.println("3. Assign grade to a student");
        System.out.println("4. Calculate overall grade for a student");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    // Method to add a new course
    private static void addNewCourse() {
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter maximum capacity: ");
        int maxCapacity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        CourseManagement.addCourse(courseCode, courseName, maxCapacity);
        System.out.println("Course added successfully.");
    }

    // Method to enroll a student in a course
    private static void enrollStudentInCourse() {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        Student student = new Student(studentName, studentId);

        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();

        Course course = findCourseByCode(courseCode);
        if (course != null) {
            CourseManagement.enrollStudent(student, course);
            System.out.println("Student enrolled successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }

    // Method to assign a grade to a student for a course
    private static void assignGradeToStudent() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter grade: ");
        double grade = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Student student = findStudentById(studentId);
        Course course = findCourseByCode(courseCode);

        if (student != null && course != null) {
            CourseManagement.assignGrade(student, course, grade);
            System.out.println("Grade assigned successfully.");
        } else {
            System.out.println("Student or Course not found.");
        }
    }

    // Method to calculate the overall grade for a student
    private static void calculateStudentOverallGrade() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        Student student = findStudentById(studentId);
        if (student != null) {
            double overallGrade = CourseManagement.calculateOverallGrade(student);
            System.out.println("Overall grade for student " + student.getName() + " (ID: " + student.getId() + ") is: " + overallGrade);
        } else {
            System.out.println("Student not found.");
        }
    }

    // Helper method to find a student by ID (stub implementation)
    private static Student findStudentById(String studentId) {
        // Implementation depends on how students are stored
        // For simplicity, we will return a new student object
        // In real application, you would search for the student in a collection
        return new Student("Dummy Name", studentId);
    }

    // Helper method to find a course by code
    private static Course findCourseByCode(String courseCode) {
        for (Course course : CourseManagement.getCourses()) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
}