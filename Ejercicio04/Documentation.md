# Documentation for Course Enrollment and Grade Management System
## Overview
This Java project implements a Course Enrollment and Grade Management System for a university. The system allows administrators to enroll students in courses, assign grades, and calculate overall course grades for students. The project demonstrates the use of static methods and variables to manage enrollment and grade-related information across multiple instances of the Student and Course classes.

## Classes and Their Purpose
1. Student Class

- Purpose: Represents a student with attributes such as name, ID, enrolled courses, and course grades.
- Private Variables:
  - String name: Stores the name of the student.
  - String id: Stores the ID of the student.
  - Set<Course> enrolledCourses: Stores the courses the student is enrolled in.
  - Map<Course, Double> courseGrades: Stores the grades for each course.
- Constructor:
  - Student(String name, String id): Initializes the student's name and ID, and sets up empty collections for courses and grades.
- Public Methods:
  - String getName(): Returns the student's name.
  - void setName(String name): Sets the student's name.
  - String getId(): Returns the student's ID.
  - void setId(String id): Sets the student's ID.
  - Set<Course> getEnrolledCourses(): Returns the set of courses the student is enrolled in.
  - Map<Course, Double> getCourseGrades(): Returns the map of course grades.
  - void enrollInCourse(Course course): Enrolls the student in the specified course.
  - void assignGrade(Course course, double grade): Assigns a grade to the student for the specified course.

2. Course Class
- Purpose: Represents a course with attributes such as course code, name, maximum capacity, and the number of enrolled students.
- Private Variables:
  - String courseCode: Stores the course code.
  - String courseName: Stores the course name.
  - int maxCapacity: Stores the maximum capacity of the course.
  - int enrolledStudents: Stores the number of students currently enrolled in the course.
  - static int totalEnrolledStudents: Tracks the total number of students enrolled across all courses.
- Constructor:
  - Course(String courseCode, String courseName, int maxCapacity): Initializes the course code, name, and maximum capacity, and sets the initial enrolled students count to 0.
- Public Methods:
  - String getCourseCode(): Returns the course code.
  - String getCourseName(): Returns the course name.
  - int getMaxCapacity(): Returns the maximum capacity of the course.
  - int getEnrolledStudents(): Returns the number of students currently enrolled in the course.
  - void incrementEnrolledStudents(): Increments the number of enrolled students for the course and the total enrolled students across all courses.
  - static int getTotalEnrolledStudents(): Returns the total number of students enrolled across all courses.

3. CourseManagement Class
- Purpose: Manages the list of courses, handles student enrollment, grade assignment, and calculates overall grades.
- Private Static Variables:
  - List<Course> courses: Stores the list of courses.
  - Map<String, Double> overallGrades: Stores the overall grades for each student.
- Public Static Methods:
  - void addCourse(String courseCode, String courseName, int maxCapacity): Adds a new course to the list of courses.
  - void enrollStudent(Student student, Course course): Enrolls a student in a course.
  - void assignGrade(Student student, Course course, double grade): Assigns a grade to a student for a course.
  - double calculateOverallGrade(Student student): Calculates the overall grade for a student based on the grades assigned.

4. AdminInterface Class
- Purpose: Provides a command-line interface for administrators to interact with the system.
- Private Variables:
  - Scanner scanner: Scanner object for reading user input.
- Public Static Methods:
  - void main(String[] args): Entry point for the program. Displays the menu and handles user choices.
- Private Static Methods:
  - void showMenu(): Displays the menu options.
  - void addNewCourse(): Prompts for course information and adds a new course.
  - void enrollStudentInCourse(): Prompts for student and course information and enrolls the student in the course.
  - void assignGradeToStudent(): Prompts for student, course, and grade information and assigns the grade.
  - void calculateStudentOverallGrade(): Prompts for student ID and calculates the student's overall grade.
  - Student findStudentById(String studentId): Placeholder method to find a student by ID (stub implementation).
  - Course findCourseByCode(String courseCode): Finds a course by its code from the list of courses.

## Static Methods and Variables Usage
- Static Variables:
  - Course.totalEnrolledStudents: Tracks the total number of students enrolled in all courses. This variable is incremented whenever a new student is enrolled in any course.
  - CourseManagement.courses: Stores all courses added to the system. This list is shared across all instances.
  - CourseManagement.overallGrades: Maps student IDs to their overall grades, ensuring consistent grade management across instances.

- Static Methods:
  - Course.getTotalEnrolledStudents(): Returns the total number of enrolled students across all courses, using the static variable totalEnrolledStudents.
  - CourseManagement.addCourse(): Adds a course to the shared list of courses.
  - CourseManagement.enrollStudent(): Enrolls a student in a course, affecting the shared list of courses.
  - CourseManagement.assignGrade(): Assigns a grade to a student for a course, maintaining grade consistency.
  - CourseManagement.calculateOverallGrade(): Calculates a student's overall grade based on all courses they are enrolled in.

## Instructions for Running the Program
1. Compile the Classes:

- Ensure all Java files (Student.java, Course.java, CourseManagement.java, AdminInterface.java) are in the same directory.
- Open a terminal or command prompt and navigate to the directory containing the files.
- Compile the Java files using the command:
  ```sh
  javac *.java
  ```
2. Run the Program:
- Execute the AdminInterface class using the command:
  ```sh
  java AdminInterface
  ```
3. Interacting with the Administrator Interface:

- The program will display a menu with the following options:
  1. Add a new course
  2. Enroll a student in a course
  3. Assign grade to a student
  4. Calculate overall grade for a student
  5. Exit
- Enter the number corresponding to the desired action and follow the prompts to input the necessary information.

## Example Usage
1. Add a New Course:
  - Select option 1 and provide the course code, name, and maximum capacity.
  - Example input:
    ```sh
    Enter course code: CS101
    Enter course name: Introduction to Computer Science
    Enter maximum capacity: 30
    ```
2. Enroll a Student in a Course:
  - Select option 2 and provide the student's name, ID, and the course code.
  - Example input:
    ```sh
    Enter student name: John Doe
    Enter student ID: S12345
    Enter course code: CS101
    ```
3. Assign Grade to a Student:
  - Select option 3 and provide the student's ID, course code, and grade.
  - Example input:
    ```sh
    Enter student ID: S12345
    Enter course code: CS101
    Enter grade: 85.5
    ```
4. Calculate Overall Grade for a Student:
  - Select option 4 and provide the student's ID.
  - Example input:
    ```sh
    Enter student ID: S12345
    ```
5. Exit the Program:

  - Select option 5 to exit the program.
  
This documentation provides a comprehensive overview of the system, including the purpose and usage of each class, method, and variable, as well as detailed instructions for running and interacting with the program.