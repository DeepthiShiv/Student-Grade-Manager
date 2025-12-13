import java.util.*;
class Student{
    int stuId;
    String studentName;
    int studentMarks;
    
    Student(int stuId, String studentName, int studentMarks){
        this.stuId= stuId;
        this.studentName=studentName;
        this.studentMarks= studentMarks;
    }
    
    char calculateGrade(){
        if(studentMarks>=90) return 'A';
        else if (studentMarks>=75)  return 'B';
        else if (studentMarks>=60) return 'C';
        else if (studentMarks>=40) return 'D';
        else return 'F';
    }
}
public class studentGradeManager{
    static Scanner sc= new Scanner(System.in);
    static ArrayList<Student> students= new ArrayList<>();
    
    public static void main(String[] args){
        while(true){
            System.out.println("--Student Grade Manager--");
            System.out.println("1. Add Student");
            System.out.println("2. Update Stduent Marks");
            System.out.println("3. Display All Students");
            System.out.println("4. Find Topper");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            
            int choice= sc.nextInt();
            
            switch(choice){
                case 1: addStudent(); break;
                case 2: updateMarks(); break;
                case 3: displayStudents(); break;
                case 4: findTopper(); break;
                case 5: System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }
    static void addStudent(){
        System.out.print("Enter StudentId: ");
        int id= sc.nextInt();
        sc.nextLine();
        
        System.out.print("Enter Student Name: ");
        String name= sc.nextLine();
        
        System.out.print("Enter Marks: ");
        int marks= sc.nextInt();
        
        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }
    static void updateMarks(){
        System.out.print("Enter StudentId: ");
        int id= sc.nextInt();
        for(Student s: students){
            if(s.stuId==id){
            System.out.print("Enter new marks: ");
            s.studentMarks= sc.nextInt();
            System.out.println("Marks Updated!");
            return;
            }
            
        }
        System.out.println("Student Not Found!");
    }
    static void displayStudents() {
        System.out.println("\nID  Name   Marks  Grade");
        for (Student s : students) {
            System.out.println(s.stuId + "  " + s.studentName + "   " + s.studentMarks + "     " + s.calculateGrade());
        }
    }
    static void findTopper() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        Student topper = students.get(0);
        for (Student s : students) {
            if (s.studentMarks > topper.studentMarks)
                topper = s;
        }

        System.out.println("Topper: " + topper.studentName + " | Marks: " + topper.studentMarks);
    }
}
