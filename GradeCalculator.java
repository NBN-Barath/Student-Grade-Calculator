public class GradeCalculator {

    public static int totalMarks(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    public static double calculateAverage(int[] marks) {
        return (double) totalMarks(marks) / marks.length;
    }

    public static int highestMark(int[] marks) {
        int max = marks[0];
        for (int mark : marks) {
            if (mark > max) max = mark;
        }
        return max;
    }

    public static int lowestMark(int[] marks) {
        int min = marks[0];
        for (int mark : marks) {
            if (mark < min) min = mark;
        }
        return min;
    }
}
