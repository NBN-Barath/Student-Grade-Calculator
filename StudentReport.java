public class StudentReport {

    private static final String[] subjects = {"Tamil", "English", "Maths", "Science", "Social"};

    public static void printReport(Student s) {
        System.out.println("\n------ Student Report ------");
        System.out.println("Name     : " + s.getName());
        System.out.println("Roll No  : " + s.getRollNo());
        System.out.println("Class    : " + s.getClassroom().getClassName());

        int[] marks = s.getMarks();
        System.out.println("\nMarks:");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("  " + subjects[i] + ": " + marks[i]);
        }

        System.out.println("\nTotal    : " + GradeCalculator.totalMarks(marks));
        System.out.println("Average  : " + GradeCalculator.calculateAverage(marks));
        System.out.println("Highest  : " + GradeCalculator.highestMark(marks));
        System.out.println("Lowest   : " + GradeCalculator.lowestMark(marks));
        System.out.println("------------------------------");
    }
}
