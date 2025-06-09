import java.util.Scanner;

public class SystemStarter {

    public static void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Student Marks System");

        Admin admin = null;  // Declare outside loop

        while (true) {
            System.out.println("\nSelect User Type:");
            System.out.println("1. Admin");
            System.out.println("2. Teacher");
            System.out.println("3. Student");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    admin = LoginSystem.loginAdmin(sc);
                    if (admin != null) {
                        AdminMenu.show(sc, admin);
                    } else {
                        System.out.println("Invalid Admin credentials.");
                    }
                    break;

                case 2:
                    LoginSystem.loginTeacher(sc);
                    break;

                case 3:
                        StudentAction.handle(sc);
                    break;

                case 4:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
