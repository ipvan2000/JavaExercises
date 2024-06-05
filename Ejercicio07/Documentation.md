# Documentation for Employee Management Program
## Overview
This Java program demonstrates the usage of the Function interface and streams to efficiently manipulate a dataset of employees. The program performs various operations, such as concatenating employee names and departments, calculating average salaries, and filtering employees based on age.

## Features
1. Read and Store Dataset: The program reads a predefined dataset of employees and stores it in a collection.
2. Function Interface: A function using the Function interface concatenates the employee's name and department.
3. Stream Operations:
  - Generates a new collection containing concatenated strings of employee names and departments.
  - Calculates the average salary of all employees.
  - Filters employees based on age (e.g., age > 30) and generates concatenated strings for filtered employees.
4. Output: Prints the results of the operations to the console.

## Code Structure
1. Employee Class: Represents an employee with attributes name, age, department, and salary.
2. Main Program (EmployeeManagement Class):
  - Defines the dataset of employees.
  - Implements the Function interface for concatenating employee names and departments.
  - Uses streams to perform various operations on the dataset.
  - Prints the results of the operations to the console.

## How to Run the Program
1. Steps to Run:
  - Step 1: Copy the code into a new Java file named EmployeeManagement.java.
  - Step 2: Open a terminal or command prompt.
  - Step 3: Navigate to the directory where EmployeeManagement.java is saved.
  - Step 4: Compile the Java file using the command:
```bash
javac EmployeeManagement.java
```
  - Step 5: Run the compiled program using the command:
```bash
java EmployeeManagement
```
3. Expected Output:
The program will print the following to the console:
- Concatenated name and department of each employee.
- The average salary of all employees.
- Concatenated name and department of employees aged above 30.

## Explanation of Core Concepts

1. Function Interface:
- The Function interface is used to create a function that takes an Employee object as input and returns a concatenated string of the employee's name and department.
- This function is then applied to each employee in the dataset using the map method of the stream.

2. Streams:

- Stream Creation: A stream is created from the list of employees.
- Mapping: The map method applies the nameDeptConcat function to each employee, transforming them into concatenated strings.
- Collecting: The collect method gathers the transformed data into a new list.
- Filtering: The filter method is used to include only employees whose age is above a specified threshold (30 years).
- Average Calculation: The mapToDouble method extracts salaries, and the average method computes the average salary.