import java.util.*;

public class LoginSystem {

    private static List<Teacher> teachers = new ArrayList<>();
    private static Map<String, Classroom> classroomMap = new HashMap<>();
    private static List<Admin> admins = new ArrayList<>();

    // Static block to initialize default admin
    static {
        Admin defaultAdmin = new Admin("admin", "admin123");
        admins.add(defaultAdmin);
    }

    // === ADMIN METHODS ===
    public static Admin loginAdmin(Scanner sc) {
        System.out.print("Enter Admin ID: ");
        String adminId = sc.next();
        System.out.print("Enter Password: ");
        String adminPass = sc.next();
        for (Admin admin : admins) {
            if (admin.getAdminId().equals(adminId) && admin.authenticate(adminPass)) {
                return admin;
            }
        }
        return null;
    }
    public static void loginTeacher(Scanner sc) {
        System.out.print("Enter teacher ID: ");
        String teacherId = sc.next();
        System.out.print("Enter password: ");
        String password = sc.next();

        Classroom classroom = null;
        for (Classroom c : AdminMenu.getClassrooms().values()) {
            Teacher teacher = c.getTeacherUser();
            if (teacher.getTeacherId().equals(teacherId) && teacher.authenticate(password)
            ) {
                classroom = c;
                break;
            }
        }

        if (classroom == null) {
            System.out.println("Invalid teacher ID or password.");
            return;
        }

        System.out.println("Login successful.");
        TeacherAction.teacherMenu(sc, classroom);
    }

    // === TEACHER METHODS ===
    public static void registerClassroom(String className, String teacherId, String username, String password) {
        Teacher teacher = new Teacher(username, password, teacherId);
        teachers.add(teacher);
        Classroom classroom = new Classroom(className, teacher);
        classroomMap.put(className, classroom);
    }

    public static void removeClassroom(String className) {
        Classroom removed = classroomMap.remove(className);
        if (removed != null) {
            teachers.remove(removed.getTeacherUser());
        }
    }


    public static Collection<Classroom> getAllClassrooms() {
        return classroomMap.values();
    }

    public static boolean classroomExists(String className) {
        return classroomMap.containsKey(className);
    }
}
