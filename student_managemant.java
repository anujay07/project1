import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Grade: " + grade;
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Map<Integer, Student> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display Students");
            System.out.println("5. Quit");

            System.out.print("Enter your choice (1/2/3/4/5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(studentMap, scanner);
                    break;
                case 2:
                    updateStudent(studentMap, scanner);
                    break;
                case 3:
                    deleteStudent(studentMap, scanner);
                    break;
                case 4:
                    displayStudents(studentMap);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void addStudent(Map<Integer, Student> studentMap, Scanner scanner) {
        System.out.print("Enter student ID: ");
        int studentID = scanner.nextInt();
        System.out.print("Enter student name: ");
        String name = scanner.next();
        System.out.print("Enter student grade in cgpa or percentage: ");
        int grade = scanner.nextInt();

        Student student = new Student(name, grade);
        studentMap.put(studentID, student);
        System.out.println("Student added successfully.");
    }

    private static void updateStudent(Map<Integer, Student> studentMap, Scanner scanner) {
        System.out.print("Enter student ID to update: ");
        int studentID = scanner.nextInt();
        if (studentMap.containsKey(studentID)) {
            System.out.print("Enter updated student name: ");
            String name = scanner.next();
            System.out.print("Enter updated student grade: ");
            int grade = scanner.nextInt();
            Student student = studentMap.get(studentID);
            student.setName(name);
            student.setGrade(grade);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student with that ID not found.");
        }
    }

    private static void deleteStudent(Map<Integer, Student> studentMap, Scanner scanner) {
        System.out.print("Enter student ID to delete: ");
        int studentID = scanner.nextInt();
        if (studentMap.containsKey(studentID)) {
            studentMap.remove(studentID);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student with that ID not found.");
        }
    }

    private static void displayStudents(Map<Integer, Student> studentMap) {
        System.out.println("Student Records:");
        for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", " + entry.getValue());
        }
    }
}
