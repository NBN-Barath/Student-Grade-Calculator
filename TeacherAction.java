import java.util.Scanner;

public class TeacherAction {

    public static void teacherMenu(Scanner sc, Classroom classroom) {
        while (true) {
            System.out.println("\n--- Teacher Menu (" + classroom.getClassName() + ") ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. View Student by Roll No");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input.");
                continue;
            }

            switch (choice) {
                case 1:
                    addStudent(sc, classroom);
                    break;
                case 2:
                    viewAllStudents(classroom);
                    break;
                case 3:
                    System.out.print("Enter Roll No: ");
                    String roll = sc.nextLine();
                    viewStudentByRollNo(classroom, roll);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addStudent(Scanner sc, Classroom classroom) {
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Roll No: ");
        String rollNo = sc.next();  // Make sure it's String

        int[] marks = new int[5];
        String[] subjects = {"Tamil", "English", "Maths", "Science", "Social"};

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter marks for " + subjects[i] + ": ");
            marks[i] = sc.nextInt();
        }

        Student s = new Student(name, rollNo, classroom, marks);
        classroom.addStudent(s);
        System.out.println("Student added to " + classroom.getClassName());
    }


    public static void viewAllStudents(Classroom classroom) {
        for (Student s : classroom.getStudents()) {
            StudentReport.printReport(s);
        }
    }

    public static void viewStudentByRollNo(Classroom classroom, String roll) {
        Student s = classroom.findStudentByRollNo(roll);
        if (s != null) {
            StudentReport.printReport(s);
        } else {
            System.out.println("Student not found in class " + classroom.getClassName());
        }
    }
}
