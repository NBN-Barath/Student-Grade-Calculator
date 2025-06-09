public class Student {
    private String name;
    private String rollNo;
    private Classroom classroom;
    private int[] marks;

    public Student(String name, String rollNo, Classroom classroom, int[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.classroom = classroom;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public int[] getMarks() {
        return marks;
    }
}
