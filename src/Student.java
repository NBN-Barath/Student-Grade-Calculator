import java.util.Arrays;

public class Student {
    String name;
    int [] marks = new int[5];
    char[] grade = new char[5];

    public  Student(String name, int[] marks){
        this.name = name;
        this.marks = marks;
        gradeCalculator();
    }

    public int totalMarkCalculator() {
        int total = 0;
        for (int i = 0; i < 5; i++) {
            total += marks[i];
        }
        return total;
    }


    public float percentageCalculator(int totalMark) {
        return (float) totalMark / 500 * 100;
    }


    public void gradeCalculator(){
        char [] grading = new char[5];
        for (int i = 0 ; i < 5 ; i++){
            if (marks[i] >= 90 && marks[i] <= 100){
                grading[i] = 'A';
            }else if (marks[i] >= 70 && marks[i] <= 89){
                grading[i] = 'B';
            }else if (marks[i] >= 50 && marks[i] <= 69){
                grading[i] = 'C';
            }else if (marks[i] >= 40 && marks[i] <= 49){
                grading[i] = 'A';
            }else if (marks[i] < 40){
                grading[i] = 'F';
            }
        }
        this.grade = grading;
    }

    public String getName() {
        return name;
    }

    public int getMarks(int index) {
        return marks[index];
    }

    public char getGrade(int index) {
        return grade[index];
    }
}
