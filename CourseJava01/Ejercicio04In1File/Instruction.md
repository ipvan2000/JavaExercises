# Comprehensive Documentation
## Student Class

- Purpose: Represents a student with basic details, enrolled courses, and grades.
- Variables:
  - name: Stores the student's name.
  - id: Stores the student's ID.
  - enrolledCourses: A set of courses the student is enrolled in.
  - courseGrades: A map of courses and the respective grades.

- Methods:
  - getName(), setName(): Get and set the student's name.
  - getId(), setId(): Get and set the student's ID.
  - getEnrolledCourses(): Get the enrolled courses.
  - getCourseGrades(): Get the course grades.
  - enrollInCourse(Course course): Enroll the student in a course and update the course's enrolled student count.
  - assignGrade(Course course, double grade): Assign a grade to the student for a specific course.

## Course Class

- Purpose: Represents a course with basic details and enrollment information.
- Variables:
  - courseCode: Stores the course code.
  - courseName: Stores the course name.
  - maxCapacity: Stores the maximum capacity of the course.
  - enrolledStudents: Stores the current number of enrolled students.
  - totalEnrolledStudents: Static variable to track the total number of enrolled students across all courses.

- Methods:
  - getCourseCode(): Get the course code.
  - getCourseName(): Get the course name.
  - getMaxCapacity(): Get the maximum capacity of the course.
  - getEnrolledStudents(): Get the current number of enrolled students.
  - incrementEnrolledStudents(): Increment the enrolled student count for the course.
  - getTotalEnrolledStudents(): Get the total number of enrolled students across all courses.

## CourseManagement Class

- Purpose: Manages courses and student enrollments and grades.
- Variables:
  - courses: List of all courses.
  - overallGrades: Map of student IDs and their overall grades.
- Methods:
  - addCourse(String courseCode, String courseName, int maxCapacity): Add a new course.
  - enrollStudent(Student student, Course course): Enroll a student in a course.
  - assignGrade(Student student, Course course, double grade): Assign a grade to a student for a course.
  - calculateOverallGrade(Student student): Calculate the overall grade for a student.
  - getCourses(): Get the list of courses.

## AdminInterface Class

- Purpose: Provides an interactive command-line interface for administrators.
- Methods:
  - main(String[] args): Main method to run the program and display the menu.
  - showMenu(): Display the menu options.
  - addNewCourse(): Add a new course by getting input from the administrator.
  - enrollStudentInCourse(): Enroll a student in a course by getting input from the administrator.
  - assignGradeToStudent(): Assign a grade to a student by getting input from the administrator.
  - calculateStudentOverallGrade(): Calculate and display the overall grade for a student by getting input from the administrator.
  - findStudentById(String studentId): Placeholder method to find a student by ID (implementation dependent).
  - findCourseByCode(String courseCode): Find a course by its code.

# Instructions for Running the Program

1. Compile the File:
- Open a terminal or command prompt and navigate to the directory containing AdminInterface.java.
- Compile the Java file using the command:
```sh
javac AdminInterface.java
```
2. Run the Program:
- Execute the compiled class using the command:
```sh
java AdminInterface
```
3. Interacting with the Administrator Interface:
- The program will display a menu with options to add a new course, enroll students, assign grades, and calculate overall course grades.
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
Enter grade: 85
```
4. Calculate Overall Grade for a Student:
- Select option 4 and provide the student's ID.
- Example input:
```sh
Enter student ID: S12345
```
- The program will display the overall grade for the student based on the grades assigned to them.