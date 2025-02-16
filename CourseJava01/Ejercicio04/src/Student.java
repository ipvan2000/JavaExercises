import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Student {
    // Private instance variables for storing student information
    private String name;
    private String id;
    private Set<Course> enrolledCourses;
    private Map<Course, Double> courseGrades;

    // Constructor to initialize student information
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.enrolledCourses = new HashSet<>();
        this.courseGrades = new HashMap<>();
    }

    // Getter and Setter methods
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

    // Method to enroll in a course
    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
        course.incrementEnrolledStudents();
    }

    // Method to assign a grade to a course
    public void assignGrade(Course course, double grade) {
        if (enrolledCourses.contains(course)) {
            courseGrades.put(course, grade);
        } else {
            System.out.println("Student not enrolled in the course.");
        }
    }
}