import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseManagement {
    // Static variables to store the list of courses and overall grades for students
    private static List<Course> courses = new ArrayList<>();
    private static Map<String, Double> overallGrades = new HashMap<>();

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

        double overallGrade = (count == 0) ? 0 : totalGrades / count;
        overallGrades.put(student.getId(), overallGrade);
        return overallGrade;
    }

    // Getter method for the list of courses (added for admin interface)
    public static List<Course> getCourses() {
        return courses;
    }
}