import java.util.*;

class Student {
    int id;
    String name;
    HashMap<String, Integer> subjectMarks;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
        subjectMarks = new HashMap<>();
    }

    void addOrUpdateSubject(String subject, int marks) {
        subjectMarks.put(subject, marks);
    }

    int getTotal() {
        int total = 0;
        for (int marks : subjectMarks.values()) {
            total += marks;
        }
        return total;
    }

    double getAverage() {
        return (double) getTotal() / subjectMarks.size();
    }

    boolean hasFailedSubject() {
        for (int marks : subjectMarks.values()) {
            if (marks < 40) return true;
        }
        return false;
    }

    char calculateGrade() {
        if (hasFailedSubject()) return 'F';

        double avg = getAverage();
        if (avg >= 90) return 'A';
        else if (avg >= 75) return 'B';
        else if (avg >= 60) return 'C';
        else if (avg >= 40) return 'D';
        else return 'F';
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Subjects & Marks: " + subjectMarks);
        System.out.println("Total: " + getTotal());
        System.out.println("Average: " + String.format("%.2f", getAverage()));
        System.out.println("Grade: " + calculateGrade());
        System.out.println("---------------------------");
    }
}

public class StudentManager {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- STUDENT GRADE MANAGER ---");
            System.out.println("1. Add Student");
            System.out.println("2. Update Subject Marks");
            System.out.println("3. Display All Students");
            System.out.println("4. Find Topper");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: updateMarks(); break;
                case 3: displayStudents(); break;
                case 4: findTopper(); break;
                case 5: System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        Student student = new Student(id, name);

        System.out.print("Enter number of subjects: ");
        int count = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= count; i++) {
            System.out.print("Enter subject name: ");
            String subject = sc.nextLine();

            System.out.print("Enter marks: ");
            int marks = sc.nextInt();
            sc.nextLine();

            student.addOrUpdateSubject(subject, marks);
        }

        students.add(student);
        System.out.println("Student added successfully!");
    }

    static void updateMarks() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.id == id) {
                System.out.print("Enter subject name to update: ");
                String subject = sc.nextLine();

                System.out.print("Enter new marks: ");
                int marks = sc.nextInt();

                s.addOrUpdateSubject(subject, marks);
                System.out.println("Marks updated successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    static void findTopper() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        Student topper = students.get(0);

        for (Student s : students) {
            if (s.getAverage() > topper.getAverage()) {
                topper = s;
            }
        }

        System.out.println("\n--- TOPPER ---");
        topper.display();
    }
}
