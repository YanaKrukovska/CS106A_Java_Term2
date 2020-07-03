package ua.edu.ukma.ykrukovska.unit1;

import ua.edu.ukma.ykrukovska.unit2.Student;

public class StudentsGrades {

    private static final int STUDENTS_AMOUNT = 5;

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
            if (grades[i] >= 71 && grades[i] < 91) {
                result++;
            }
        }
        return result;
    }

    public int getStudentsSatisfying() {
        int result = 0;

        for (int i = 0; i < grades.length; i++) {
            if (grades[i] >= 60 && grades[i] < 71) {
                result++;
            }
        }
        return result;
    }

    public int getStudentsBad() {
        int result = 0;

        for (int i = 0; i < grades.length; i++) {
            if (grades[i] >= 0 && grades[i] < 60) {
                result++;
            }
        }
        return result;
    }

    public String sortGrades(int sortingOrder) {
        String result = "";
        int temporary;

        for (int i = grades.length - 1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (grades[j - 1] > grades[j]) {
                    temporary = grades[j - 1];
                    grades[j - 1] = grades[j];
                    grades[j] = temporary;
                }
            }
        }

        if (sortingOrder == 1) {
            for (int i = 0; i < grades.length; i++) {
                result += grades[i] + ", ";
            }
        } else {
            for (int i = grades.length - 1; i >= 0; i--) {
                result += grades[i] + ", ";
            }
        }
        return result;
    }

    public void sortByGradeAsc(Student[] students) {
        for (int i = students.length - 1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (students[j - 1].getAverageGrade() > students[j].getAverageGrade()) {
                    Student temporary = students[j - 1];
                    students[j - 1] = students[j];
                    students[j] = temporary;
                }
            }
        }
    }

    public void sortByGradeDesc(Student[] students) {
        for (int i = students.length - 1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (students[j - 1].getAverageGrade() < students[j].getAverageGrade()) {
                    Student temporary = students[j - 1];
                    students[j - 1] = students[j];
                    students[j] = temporary;
                }
            }
        }
    }

    public void sortByNameAsc(Student[] students) {
        for (int i = students.length - 1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (students[j - 1].getName().charAt(0) > students[j].getName().charAt(0)) {
                    Student temporary = students[j - 1];
                    students[j - 1] = students[j];
                    students[j] = temporary;
                }
            }
        }
    }

    public void sortByNameDesc(Student[] students) {
        for (int i = students.length - 1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (students[j - 1].getName().charAt(0) < students[j].getName().charAt(0)) {
                    Student temporary = students[j - 1];
                    students[j - 1] = students[j];
                    students[j] = temporary;
                }
            }
        }
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
