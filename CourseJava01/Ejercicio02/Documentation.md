# Student Record Management System Documentation
## Overview
The Student Record Management System is a Java program designed to empower administrators with efficient tools for handling student records. It provides functionalities such as adding new students, updating student information, and viewing student details.

## Features
- Student Data Storage: Individual variables store student information, including name, ID, age, and grade.
- Student Management: A set of logically separated methods/functions within a dedicated classless structure manages student data, employing static variables for storing the total number of students and the student list.
- Administrator Interface: An interactive menu allows administrators to perform operations such as adding a new student, updating student information, and viewing student details.
- Error Handling: The system implements error handling to manage cases where the student ID is not found or invalid inputs are provided.

## Running the Program
To run the Student Record Management System, follow these steps:

1. Compile the Java Files: Compile the StudentRecordManagementSystem.java file using a Java compiler. You can do this by executing the following command in your terminal or command prompt:

```java
javac StudentRecordManagementSystem.java
```
2. Run the Program: Run the compiled Java program using the java command:

```java
java StudentRecordManagementSystem
```

## Interacting with the Administrator Interface
Once the program is running, you will be presented with the following menu options:

1. Add New Student: Allows you to add a new student to the system. You will be prompted to enter the student's name, ID, age, and grade.
2. Update Student Information: Allows you to update the information of an existing student. You need to provide the student ID whose information you want to update, and then enter the new name, age, and grade.
3. View Student Details: Enables you to view the details of a specific student by providing their ID.
4. Exit: Exits the program.

Follow the on-screen prompts to navigate through the menu and perform the desired operations.

## Error Handling
- If you enter an invalid menu option, the program will display an error message and prompt you to enter a valid option.
- If you try to update or view the details of a student with an invalid ID or a non-existent ID, the program will inform you that the student was not found.