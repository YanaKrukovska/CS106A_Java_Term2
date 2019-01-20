package ua.edu.ukma.ykrukovska.Unit1;

public class StudentsGrades {

    private static final int STUDENTS_AMOUNT = 10;

    private int[] grades;

    public int[] getGrades() {
        if (grades == null) {
            grades = new int[STUDENTS_AMOUNT];
        }
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }


    public int getMaxGrade() {
        int result = 0;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > result) {
                result = grades[i];
            }
        }
        return result;
    }

    public int getMinGrade() {
        int result = 100;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < result) {
                result = grades[i];
            }
        }
        return result;
    }

    public double getAverageGrade() {

        int result = 0;
        for (int i = 0; i < grades.length; i++) {
            result += grades[i];
        }
        return result / grades.length;

    }

    public int getStudentsHigherAverage() {

        int result = 0;
        double averageGrade = getAverageGrade();

        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > averageGrade) {
                result++;
            }
        }
        return result;
    }

    public int getStudentsLowerAverage() {
        int result = 0;
        double averageGrade = getAverageGrade();

        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < averageGrade) {
                result++;
            }
        }
        return result;
    }

    public int getStudentsExcellent() {
        int result = 0;

        for (int i = 0; i < grades.length; i++) {
            if (grades[i] >= 91) {
                result++;
            }
        }
        return result;
    }

    public int getStudentsGood() {
        int result = 0;

        for (int i = 0; i < grades.length; i++) {
            if (grades[i] >= 71 && grades[i] < 91 ) {
                result++;
            }
        }
        return result;
    }

    public int getStudentsSatisfying() {
        int result = 0;

        for (int i = 0; i < grades.length; i++) {
            if (grades[i] >= 60 && grades[i] < 71 ) {
                result++;
            }
        }
        return result;
    }

    public int getStudentsBad() {
        int result = 0;

        for (int i = 0; i < grades.length; i++) {
            if (grades[i] >= 0 && grades[i] < 60 ) {
                result++;
            }
        }
        return result;
    }

    @Override
    public String toString() {
    String result = "Students amount " + grades.length + ". Grades: ";
        for (int i = 0; i < grades.length; i++) {
            result += grades[i] + ", ";
        }
        return result;
    }
}
