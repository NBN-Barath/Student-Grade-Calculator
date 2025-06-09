import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdminMenu {

    public static void show(Scanner sc, Admin admin) {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Create Classroom");
            System.out.println("2. Delete Classroom");
            System.out.println("3. View Classrooms");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createClassroom(sc);
                    break;
                case 2:
                    deleteClassroom(sc);
                    break;
                case 3:
                    viewClassrooms();
                    break;
                case 4:
                    return; // Go back to main menu
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void createClassroom(Scanner sc) {
        System.out.print("Enter Classroom Name: ");
        String className = sc.next();
        System.out.print("Enter Teacher ID: ");
        String teacherId = sc.next();
        System.out.print("Enter Teacher Username: ");
        String username = sc.next();
        System.out.print("Enter Teacher Password: ");
        String password = sc.next();

        if (LoginSystem.classroomExists(className)) {
            System.out.println("Classroom already exists.");
            return;
        }

        LoginSystem.registerClassroom(className, teacherId, username, password);
        System.out.println("Classroom " + className + " created successfully.");
    }

    private static void deleteClassroom(Scanner sc) {
        System.out.print("Enter Classroom Name to delete: ");
        String className = sc.next();

        if (!LoginSystem.classroomExists(className)) {
            System.out.println("Classroom not found.");
            return;
        }

        LoginSystem.removeClassroom(className);
        System.out.println("Classroom " + className + " deleted.");
    }

    private static void viewClassrooms() {
        System.out.println("\n--- Registered Classrooms ---");
        for (Classroom c : LoginSystem.getAllClassrooms()) {
            System.out.println("Class: " + c.getClassName() + " | Teacher ID: " + c.getTeacherUser().getTeacherId());
        }
    }
    public static Map<String, Classroom> getClassrooms() {
        Map<String, Classroom> map = new HashMap<>();
        for (Classroom c : LoginSystem.getAllClassrooms()) {
            map.put(c.getClassName(), c);
        }
        return map;
    }
}
