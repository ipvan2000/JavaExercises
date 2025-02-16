# Student Management System GUI Application Documentation
## Purpose
The Student Management System GUI Application is designed to facilitate efficient management of student records, course enrollment, and grades for administrators. The application provides a user-friendly interface built using Java's GUI frameworks, Swing and JavaFX. It enables administrators to perform various tasks such as adding new students, updating student information, enrolling students in courses, assigning grades, and viewing student details.

## Functionality
1. Student Management
 - Add Student: Allows administrators to add new students by entering their name and ID.
- Update Student: Enables administrators to update existing student information, including their name and ID.
2. Course Enrollment
- Enroll Student: Facilitates the enrollment of students in courses by selecting a student and a course from dropdown menus.
3. Grade Management
- Assign Grade: Provides functionality to assign grades to students for specific courses by selecting a student, course, and entering the grade.

## Components
The GUI application comprises the following components:

1. Main Menu Bar: Allows navigation between different functionalities - Student Management, Course Enrollment, and Grade Management.

2. Student Management Panel:

- Table: Displays the list of students with columns for ID and Name.
- Add Student Button: Opens a dialog to add a new student.
- Update Student Button: Opens a dialog to update existing student information.

3. Course Enrollment Panel:

- Enroll Student Button: Opens a dialog to enroll a student in a course.

4. Grade Management Panel:

- Assign Grade Button: Opens a dialog to assign a grade to a student for a specific course.

## Event Handling
- Add Student Button Click: Opens a dialog for adding a new student and updates the student list and table upon successful addition.
- Update Student Button Click: Opens a dialog for updating student information and updates the student list and table upon successful update.
- Enroll Student Button Click: Opens a dialog for enrolling a student in a course.
- Assign Grade Button Click: Opens a dialog for assigning a grade to a student for a specific course.

## Usage
1. Launching the Application:

- Execute the main method in the StudentManagementSystem class.
- The application window will appear with the main menu bar and the Student Management panel displayed by default.

2. Navigating between Panels:

- Use the main menu bar to switch between Student Management, Course Enrollment, and Grade Management functionalities.

3. Adding a Student:

- Click the "Add Student" button in the Student Management panel.
- Enter the student's name and ID in the dialog that appears.
- Click the "Add" button to add the student.

4. Updating Student Information:

- Click the "Update Student" button in the Student Management panel.
- Select the student to update from the dropdown menu.
- Enter the new name and ID for the student in the dialog that appears.
- Click the "Update" button to update the student's information.

5. Enrolling a Student:

- Click the "Enroll Student" button in the Course Enrollment panel.
- Select the student and the course from the dropdown menus in the dialog that appears.
- Click the "Enroll" button to enroll the student in the course.

6. Assigning a Grade:

- Click the "Assign Grade" button in the Grade Management panel.
- Select the student, course, and enter the grade in the dialog that appears.
- Click the "Assign" button to assign the grade to the student for the course.

## Conclusion
The Student Management System GUI Application provides a user-friendly interface for administrators to manage student records, course enrollment, and grades efficiently. With intuitive navigation and comprehensive functionality, it streamlines administrative tasks and enhances the overall management process.