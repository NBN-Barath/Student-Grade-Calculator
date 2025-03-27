import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println(" 1. Add student\n 2. View students");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter the student name: ");
                String name = sc.next();
                int[] marks = new int[5];
                for (int i = 0; i < 5; i++) {
                    System.out.print("Enter the mark of Subject" + (i + 1) + ": ");
                    int mark = sc.nextInt();
                    if (mark <= 100 && mark >= 0) {
                        marks[i] = mark;
                    } else {
                        i--;
                        System.out.println("Enter a valid mark");
                    }
                }
                Student student = new Student(name, marks);
                students.add(student);
            } else if (choice == 2) {
                int noOfFails = 0;
                System.out.print("Enter the name of student to view: ");
                String name = sc.next();

                for (Student stud : students) {
                    if (stud.getName().equalsIgnoreCase(name)) {
                        StringBuilder report = new StringBuilder();
                        report.append(String.format("Name: %s\n", stud.getName()));
                        report.append("Marks\n");

                        for (int i = 0; i < 5; i++) {
                            report.append(String.format("Subject%d \t %d \t %c\n", i + 1, stud.getMarks(i), stud.getGrade(i)));
                        }

                        report.append("_____________________________________________________________\n");
                        report.append(String.format("Total \t %d\n", stud.totalMarkCalculator()));
                        report.append("-------------------------------------------------------------\n");

                        for (int j = 0; j < 5; j++) {
                            if (stud.getGrade(j) == 'F') {
                                noOfFails++;
                            }
                        }

                        if (noOfFails == 0) {
                            report.append(String.format("Percentage: %.2f\n", stud.percentageCalculator(stud.totalMarkCalculator())));
                        } else {
                            report.append(String.format("You have failed in %d subject(s) so no percentage.\n", noOfFails));
                        }

                        System.out.println(report);
                        return;
                    }
                }
            }
        }
    }
}
