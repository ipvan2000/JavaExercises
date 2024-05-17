import java.util.*;

// Student class
class Student {
    private String name;
    private String id;
    private Set<Course> enrolledCourses;
    private Map<Course, Double> courseGrades;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.enrolledCourses = new HashSet<>();
        this.courseGrades = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public Map<Course, Double> getCourseGrades() {
        return courseGrades;
    }

    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
        course.incrementEnrolledStudents();
    }

    public void assignGrade(Course course, double grade) {
        if (enrolledCourses.contains(course)) {
            courseGrades.put(course, grade);
        } else {
            System.out.println("Student not enrolled in the course.");
        }
    }
}

// Course class
class Course {
    private String courseCode;
    private String courseName;
    private int maxCapacity;
    private int enrolledStudents;
    private static int totalEnrolledStudents = 0;

    public Course(String courseCode, String courseName, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = 0;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public void incrementEnrolledStudents() {
        if (enrolledStudents < maxCapacity) {
            enrolledStudents++;
            totalEnrolledStudents++;
        } else {
            System.out.println("Course capacity reached.");
        }
    }

    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }
}

// CourseManagement class
class CourseManagement {
    private static List<Course> courses = new ArrayList<>();
    private static Map<String, Double> overallGrades = new HashMap<>();

    public static void addCourse(String courseCode, String courseName, int maxCapacity) {
        Course course = new Course(courseCode, courseName, maxCapacity);
        courses.add(course);
    }

    public static void enrollStudent(Student student, Course course) {
        student.enrollInCourse(course);
    }

    public static void assignGrade(Student student, Course course, double grade) {
        student.assignGrade(course, grade);
    }

    public static double calculateOverallGrade(Student student) {
        double totalGrades = 0;
        int count = 0;

        for (Map.Entry<Course, Double> entry : student.getCourseGrades().entrySet()) {
            totalGrades += entry.getValue();
            count++;
        }

        double overallGrade = (count == 0) ? 0 : totalGrades / count;
        overallGrades.put(student.getId(), overallGrade);
        return overallGrade;
    }

    public static List<Course> getCourses() {
        return courses;
    }
}

// AdminInterface class
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

    private static void showMenu() {
        System.out.println("\n=== Course Enrollment and Grade Management System ===");
        System.out.println("1. Add a new course");
        System.out.println("2. Enroll a student in a course");
        System.out.println("3. Assign grade to a student");
        System.out.println("4. Calculate overall grade for a student");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

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

    private static Student findStudentById(String studentId) {
        // Implementation depends on how students are stored
        // For simplicity, we will return a new student object
        // In real application, you would search for the student in a collection
        return new Student("Dummy Name", studentId);
    }

    private static Course findCourseByCode(String courseCode) {
        for (Course course : CourseManagement.getCourses()) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
}
