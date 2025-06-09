import java.util.*;

public class Classroom {
    private String className;
    private Teacher teacherUser;
    private List<Student> students = new ArrayList<>();

    public Classroom(String className, Teacher teacherUser) {
        this.className = className;
        this.teacherUser = teacherUser;
    }

    public String getClassName() {
        return className;
    }

    public Teacher getTeacherUser() {
        return teacherUser;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    // Find student by roll number (String)
    public Student findStudentByRollNo(String rollNo) {
        for (Student s : students) {
            if (s.getRollNo().equals(rollNo)) {
                return s;
            }
        }
        return null;
    }
}
