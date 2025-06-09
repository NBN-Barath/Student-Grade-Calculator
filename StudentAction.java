import java.util.Scanner;

public class StudentAction {

    public static void handle(Scanner sc) {
        System.out.print("Enter your roll number: ");
        String rollNo = sc.next();

        for (Classroom c : AdminMenu.getClassrooms().values()) {
            Student s = c.findStudentByRollNo(rollNo);
            if (s != null) {
                StudentReport.printReport(s);
                return;
            }
        }
        System.out.println("Student with roll number " + rollNo + " not found.");
    }
}
