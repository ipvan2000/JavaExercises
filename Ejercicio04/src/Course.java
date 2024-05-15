public class Course {
  // Private instance variables for storing course information
  private String courseCode;
  private String courseName;
  private int maxCapacity;
  private int enrolledStudents;
  private static int totalEnrolledStudents = 0; // Static variable to track total enrolled students across all courses

  // Constructor to initialize course information
  public Course(String courseCode, String courseName, int maxCapacity) {
      this.courseCode = courseCode;
      this.courseName = courseName;
      this.maxCapacity = maxCapacity;
      this.enrolledStudents = 0;
  }

  // Getter methods
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

  // Method to increment enrolled students and total enrolled students
  public void incrementEnrolledStudents() {
      if (enrolledStudents < maxCapacity) {
          enrolledStudents++;
          totalEnrolledStudents++;
      } else {
          System.out.println("Course capacity reached.");
      }
  }

  // Static method to get total enrolled students across all courses
  public static int getTotalEnrolledStudents() {
      return totalEnrolledStudents;
  }
}