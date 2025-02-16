import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class StudentManagementSystem {
    private JFrame frame;
    private DefaultTableModel studentTableModel;
    private JTable studentTable;
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>(); // Initialize the student list

        // Create the main application frame
        frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Create the main panel with a CardLayout to switch between different functionalities
        JPanel mainPanel = new JPanel(new CardLayout());

        // Add panels for each functionality to the main panel
        mainPanel.add(createStudentManagementPanel(), "StudentManagement");
        mainPanel.add(createCourseEnrollmentPanel(), "CourseEnrollment");
        mainPanel.add(createGradeManagementPanel(), "GradeManagement");

        // Add the main panel to the frame
        frame.add(mainPanel, BorderLayout.CENTER);

        // Create and set up the menu bar
        frame.setJMenuBar(createMenuBar(mainPanel));

        // Make the frame visible
        frame.setVisible(true);
    }

    private JMenuBar createMenuBar(JPanel mainPanel) {
        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        // Create menu items and add action listeners to switch between panels
        JMenuItem studentManagement = new JMenuItem("Student Management");
        studentManagement.addActionListener(e -> {
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "StudentManagement");
        });

        JMenuItem courseEnrollment = new JMenuItem("Course Enrollment");
        courseEnrollment.addActionListener(e -> {
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "CourseEnrollment");
        });

        JMenuItem gradeManagement = new JMenuItem("Grade Management");
        gradeManagement.addActionListener(e -> {
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "GradeManagement");
        });

        // Add menu items to the menu and add the menu to the menu bar
        menu.add(studentManagement);
        menu.add(courseEnrollment);
        menu.add(gradeManagement);
        menuBar.add(menu);

        return menuBar;
    }

    private JPanel createStudentManagementPanel() {
        // Create the student management panel
        JPanel panel = new JPanel(new BorderLayout());

        // Table to display student information
        studentTableModel = new DefaultTableModel(new Object[]{"ID", "Name"}, 0);
        studentTable = new JTable(studentTableModel);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(studentTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Panel for the buttons
        JPanel buttonPanel = new JPanel();
        JButton addStudentButton = new JButton("Add Student");
        addStudentButton.addActionListener(e -> showAddStudentDialog());
        buttonPanel.add(addStudentButton);

        JButton updateStudentButton = new JButton("Update Student");
        updateStudentButton.addActionListener(e -> showUpdateStudentDialog());
        buttonPanel.add(updateStudentButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private void showAddStudentDialog() {
        // Create a dialog for adding a new student
        JDialog dialog = new JDialog(frame, "Add Student", true);
        dialog.setLayout(new GridLayout(4, 2));

        // Add components to the dialog
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel idLabel = new JLabel("ID:");
        JTextField idField = new JTextField();
        JButton addButton = new JButton("Add");

        // Action listener for the add button
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String id = idField.getText();
            if (!name.isEmpty() && !id.isEmpty()) {
                // Add student to the list and table
                Student student = new Student(id, name);
                students.add(student);
                studentTableModel.addRow(new Object[]{id, name});
                JOptionPane.showMessageDialog(dialog, "Student added successfully!");
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, "Please enter both ID and Name.");
            }
        });

        // Add components to the dialog
        dialog.add(nameLabel);
        dialog.add(nameField);
        dialog.add(idLabel);
        dialog.add(idField);
        dialog.add(new JLabel());
        dialog.add(addButton);

        dialog.pack();
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }

    private void showUpdateStudentDialog() {
        // Create a dialog for updating student information
        JDialog dialog = new JDialog(frame, "Update Student", true);
        dialog.setLayout(new GridLayout(4, 2));

        // Add components to the dialog
        JLabel selectLabel = new JLabel("Select Student:");
        JComboBox<String> studentComboBox = new JComboBox<>(students.stream().map(Student::getName).toArray(String[]::new));
        JLabel nameLabel = new JLabel("New Name:");
        JTextField nameField = new JTextField();
        JLabel idLabel = new JLabel("New ID:");
        JTextField idField = new JTextField();
        JButton updateButton = new JButton("Update");

        // Action listener for the update button
        updateButton.addActionListener(e -> {
            String selectedStudentName = (String) studentComboBox.getSelectedItem();
            String newName = nameField.getText();
            String newId = idField.getText();
            if (selectedStudentName != null && !newName.isEmpty() && !newId.isEmpty()) {
                // Find the student to update
                for (Student student : students) {
                    if (student.getName().equals(selectedStudentName)) {
                        student.setName(newName);
                        student.setId(newId);
                        // Update the table
                        int row = students.indexOf(student);
                        studentTableModel.setValueAt(newId, row, 0);
                        studentTableModel.setValueAt(newName, row, 1);
                        JOptionPane.showMessageDialog(dialog, "Student information updated successfully!");
                        break;
                    }
                }
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, "Please enter new ID, Name, and select a student.");
            }
        });

        // Add components to the dialog
        dialog.add(selectLabel);
        dialog.add(studentComboBox);
        dialog.add(nameLabel);
        dialog.add(nameField);
        dialog.add(idLabel);
        dialog.add(idField);
        dialog.add(new JLabel());
        dialog.add(updateButton);

        dialog.pack();
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }

    private JPanel createCourseEnrollmentPanel() {
        // Create the course enrollment panel
        JPanel panel = new JPanel();
        panel.add(new JLabel("Course Enrollment Panel"));

        // Add button for enrolling a student and its action listener
        JButton enrollStudentButton = new JButton("Enroll Student");
        enrollStudentButton.addActionListener(e -> showEnrollStudentDialog());
        panel.add(enrollStudentButton);

        // You can add more components and functionality here as needed

        return panel;
    }

    private void showEnrollStudentDialog() {
        // Create a dialog for enrolling a student in a course
        JDialog dialog = new JDialog(frame, "Enroll Student", true);
        dialog.setLayout(new GridLayout(3, 2));

        // Add components to the dialog
        JLabel courseLabel = new JLabel("Course:");
        JComboBox<String> courseComboBox = new JComboBox<>(new String[]{"Course1", "Course2"}); // Populate dynamically
        JLabel studentLabel = new JLabel("Student:");
        JComboBox<String> studentComboBox = new JComboBox<>(students.stream().map(Student::getName).toArray(String[]::new));

        JButton enrollButton = new JButton("Enroll");

        // Action listener for the enroll button
        enrollButton.addActionListener(e -> {
            String course = (String) courseComboBox.getSelectedItem();
            String studentName = (String) studentComboBox.getSelectedItem();
            if (course != null && studentName != null) {
                // Enroll student in course (implement this)
                // Currently, just display a message for demonstration
                JOptionPane.showMessageDialog(dialog, studentName + " enrolled in " + course + " successfully!");
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, "Please select both a course and a student.");
            }
        });

        // Add components to the dialog
        dialog.add(courseLabel);
        dialog.add(courseComboBox);
        dialog.add(studentLabel);
        dialog.add(studentComboBox);
        dialog.add(new JLabel());
        dialog.add(enrollButton);

        dialog.pack();
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }

    private JPanel createGradeManagementPanel() {
        // Create the grade management panel
        JPanel panel = new JPanel();
        panel.add(new JLabel("Grade Management Panel"));

        // Add button for assigning a grade and its action listener
        JButton assignGradeButton = new JButton("Assign Grade");
        assignGradeButton.addActionListener(e -> showAssignGradeDialog());
        panel.add(assignGradeButton);

        // You can add more components and functionality here as needed

        return panel;
    }

    private void showAssignGradeDialog() {
        // Create a dialog for assigning a grade to a student
        JDialog dialog = new JDialog(frame, "Assign Grade", true);
        dialog.setLayout(new GridLayout(4, 2));

        // Add components to the dialog
        JLabel studentLabel = new JLabel("Student:");
        JComboBox<String> studentComboBox = new JComboBox<>(students.stream().map(Student::getName).toArray(String[]::new));
        JLabel courseLabel = new JLabel("Course:");
        JComboBox<String> courseComboBox = new JComboBox<>(new String[]{"Course1", "Course2"});
        JLabel gradeLabel = new JLabel("Grade:");
        JTextField gradeField = new JTextField();
        JButton assignButton = new JButton("Assign");

        // Action listener for the assign button
        assignButton.addActionListener(e -> {
            String studentName = (String) studentComboBox.getSelectedItem();
            String course = (String) courseComboBox.getSelectedItem();
            String grade = gradeField.getText();
            if (studentName != null && course != null && !grade.isEmpty()) {
                // Assign grade (implement this)
                // Currently, just display a message for demonstration
                JOptionPane.showMessageDialog(dialog, "Assigned grade " + grade + " to " + studentName + " for " + course);
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, "Please select a student, course, and enter a grade.");
            }
        });

        // Add components to the dialog
        dialog.add(studentLabel);
        dialog.add(studentComboBox);
        dialog.add(courseLabel);
        dialog.add(courseComboBox);
        dialog.add(gradeLabel);
        dialog.add(gradeField);
        dialog.add(new JLabel());
        dialog.add(assignButton);

        dialog.pack();
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        // Run the application on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(StudentManagementSystem::new);
    }
}

// Simple Student class to store student information
class Student {
    private String id;
    private String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}

