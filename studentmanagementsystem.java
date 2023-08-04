import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ConsoleStudentManagement {
    private static StudentManagementSystem system = new StudentManagementSystem();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student's roll number: ");
                    String rollNumber = scanner.nextLine();
                    System.out.print("Enter student's grade: ");
                    String grade = scanner.nextLine();

                    if (!name.isEmpty() && !rollNumber.isEmpty() && !grade.isEmpty()) {
                        Student student = new Student(name, rollNumber, grade);
                        system.addStudent(student);
                        System.out.println("Student added successfully!");
                    } else {
                        System.out.println("Please fill in all fields.");
                    }
                    break;

                case 2:
                    System.out.print("Enter student's roll number to remove: ");
                    String rollToRemove = scanner.nextLine();
                    system.removeStudent(rollToRemove);
                    System.out.println("Student removed successfully!");
                    break;

                case 3:
                    System.out.print("Enter student's roll number to search: ");
                    String rollToSearch = scanner.nextLine();
                    Student searchedStudent = system.searchStudent(rollToSearch);
                    if (searchedStudent != null) {
                        System.out.println("Student Found:");
                        System.out.println("Name: " + searchedStudent.getName());
                        System.out.println("Roll Number: " + searchedStudent.getRollNumber());
                        System.out.println("Grade: " + searchedStudent.getGrade());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.println("All Students:");
                    List<Student> students = system.getAllStudents();
                    for (Student student : students) {
                        System.out.println("Name: " + student.getName() +
                                ", Roll Number: " + student.getRollNumber() +
                                ", Grade: " + student.getGrade());
                    }
                    break;

                case 5:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

class Student {
    private String name;
    private String rollNumber;
    private String grade;

    public Student(String name, String rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String rollNumber) {
        students.removeIf(student -> student.getRollNumber().equals(rollNumber));
    }

    public Student searchStudent(String rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber().equals(rollNumber)) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return students;
    }
}
