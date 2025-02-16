import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

// Class representing an Employee
class Employee {
    private String name;
    private int age;
    private String department;
    private double salary;

    // Constructor to initialize employee attributes
    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    // Getter methods to access employee attributes
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

public class EmployeeManagement {

    public static void main(String[] args) {
        // Sample dataset of employees
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 30, "HR", 60000),
                new Employee("Bob", 35, "Engineering", 70000),
                new Employee("Charlie", 28, "Sales", 50000),
                new Employee("David", 45, "Engineering", 80000),
                new Employee("Eve", 40, "HR", 75000)
        );

        // Define a function using the Function interface that concatenates
        // the employee's name and department
        Function<Employee, String> nameDeptConcat = employee -> employee.getName() + " - " + employee.getDepartment();

        // Use streams to generate a new collection of concatenated strings
        List<String> nameDeptList = employees.stream()
                .map(nameDeptConcat) // Apply the function to each employee
                .collect(Collectors.toList()); // Collect the results into a list

        // Print the concatenated name and department of each employee
        System.out.println("Concatenated Name and Department:");
        nameDeptList.forEach(System.out::println);

        // Calculate the average salary of all employees using stream's built-in functions
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary) // Map each employee to their salary
                .average() // Calculate the average salary
                .orElse(0.0); // Default to 0.0 if the stream is empty

        // Print the average salary
        System.out.println("Average Salary: " + averageSalary);

        // Filter employees to include only those whose age is above 30
        List<String> filteredNameDeptList = employees.stream()
                .filter(e -> e.getAge() > 30) // Filter employees by age
                .map(nameDeptConcat) // Apply the function to each filtered employee
                .collect(Collectors.toList()); // Collect the results into a list

        // Print the concatenated name and department of filtered employees
        System.out.println("Filtered (Age > 30) Concatenated Name and Department:");
        filteredNameDeptList.forEach(System.out::println);
    }
}
