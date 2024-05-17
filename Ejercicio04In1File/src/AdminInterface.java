import java.util.*;

// Student class
class Student {
    // Private instance variables
    private String name;                       // Stores the name of the student
    private String id;                         // Stores the ID of the student
    private Set<Course> enrolledCourses;       // Stores the courses the student is enrolled in
    private Map<Course, Double> courseGrades;  // Stores the grades for each course

    // Constructor to initialize student details
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.enrolledCourses = new HashSet<>();
        this.courseGrades = new HashMap<>();
    }

    // Getter for student's name
    public String getName() {
        return name;
    }

    // Setter for student's name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for student's ID
    public String getId() {
        return id;
    }

    // Setter for student's ID
    public void setId(String id) {
        this.id = id;
    }

    // Getter for enrolled courses
    public Set<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    // Getter for course grades
    public Map<Course, Double> getCourseGrades() {
        return courseGrades;
    }

    // Method to enroll the student in a course
    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
        course.incrementEnrolledStudents();  // Increment the enrolled student count for the course
    }

    // Method to assign a grade to the student for a specific course
    public void assignGrade(Course course, double grade) {
        if (enrolledCourses.contains(course)) {
            courseGrades.put(course, grade);  // Update the grade for the course
        } else {
            System.out.println("Student not enrolled in the course.");  // Error message if student is not enrolled
        }
    }
}

// Course class
class Course {
    // Private instance variables
    private String courseCode;                 // Stores the course code
    private String courseName;                 // Stores the course name
    private int maxCapacity;                   // Stores the maximum capacity of the course
    private int enrolledStudents;              // Stores the current number of enrolled students
    private static int totalEnrolledStudents = 0; // Static variable to track total enrolled students across all courses

    // Constructor to initialize course details
    public Course(String courseCode, String courseName, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = 0;
    }

    // Getter for course code
    public String getCourseCode() {
        return courseCode;
    }

    // Getter for course name
    public String getCourseName() {
        return courseName;
    }

    // Getter for maximum capacity
    public int getMaxCapacity() {
        return maxCapacity;
    }

    // Getter for enrolled students count
    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    // Method to increment enrolled students count
    public void incrementEnrolledStudents() {
        if (enrolledStudents < maxCapacity) {
            enrolledStudents++;
            totalEnrolledStudents++;  // Increment the total enrolled students across all courses
        } else {
            System.out.println("Course capacity reached.");  // Error message if course capacity is reached
        }
    }

    // Static method to get total enrolled students across all courses
    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }
}

// CourseManagement class
class CourseManagement {
    // Private static variables
    private static List<Course> courses = new ArrayList<>();          // List to store all courses
    private static Map<String, Double> overallGrades = new HashMap<>(); // Map to store overall grades for each student by ID

    // Method to add a new course
    public static void addCourse(String courseCode, String courseName, int maxCapacity) {
        Course course = new Course(courseCode, courseName, maxCapacity);
        courses.add(course);
    }

    // Method to enroll a student in a course
    public static void enrollStudent(Student student, Course course) {
        student.enrollInCourse(course);
    }

    // Method to assign a grade to a student for a course
    public static void assignGrade(Student student, Course course, double grade) {
        student.assignGrade(course, grade);
    }

    // Method to calculate the overall grade for a student
    public static double calculateOverallGrade(Student student) {
        double totalGrades = 0;
        int count = 0;

        for (Map.Entry<Course, Double> entry : student.getCourseGrades().entrySet()) {
            totalGrades += entry.getValue();
            count++;
        }

        double overallGrade = (count == 0) ? 0 : totalGrades / count;  // Calculate the overall grade
        overallGrades.put(student.getId(), overallGrade);
        return overallGrade;
    }

    // Getter for the list of courses
    public static List<Course> getCourses() {
        return courses;
    }
}

// AdminInterface class
public class AdminInterface {
    // Scanner object for reading user input
    private static Scanner scanner = new Scanner(System.in);

    // Main method to start the program
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

    // Method to display the menu
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

    // Placeholder method to find a student by ID
    private static Student findStudentById(String studentId) {
        // Implementation depends on how students are stored
        // For simplicity, we will return a new student object
        // In a real application, you would search for the student in a collection
        return new Student("Dummy Name", studentId);
    }

    // Method to find a course by its code
    private static Course findCourseByCode(String courseCode) {
        for (Course course : CourseManagement.getCourses()) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
}
