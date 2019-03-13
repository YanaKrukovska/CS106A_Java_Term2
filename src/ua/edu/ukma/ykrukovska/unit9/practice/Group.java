package ua.edu.ukma.ykrukovska.unit9.practice;

public class Group {


    private int studentsCounter = 0;

    private Student[] students = new Student[GroupTester.MAX_AMOUNT_OF_STUDENTS];

    public void addStudent(Student student) {
        students[studentsCounter++] = student;

    }

    public Student getBest() {
        Student result = null;

        double max = 0.;

        for (int i = 0; i < studentsCounter; i++) {
            if (students[i].getAverageMark() > max) {
                max = students[i].getAverageMark();
                result = students[i];
            }
        }
        return result;
    }


    public Student getWorst() {

        Student result = null;

        double min = 100.0;

        for (int i = 0; i < studentsCounter; i++) {
            if (students[i].getAverageMark() < min) {
                min = students[i].getAverageMark();
                result = students[i];
            }
        }
        return result; }

}
