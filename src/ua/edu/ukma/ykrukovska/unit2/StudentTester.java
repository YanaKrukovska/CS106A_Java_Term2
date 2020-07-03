package ua.edu.ukma.ykrukovska.unit2;

import ua.edu.ukma.ykrukovska.unit1.StudentsGrades;

public class StudentTester {

    public static void main(String[] args) {

        Student[] students = new Student[3];
        students[0] = new Student("Justin Bieber", 24);
        students[1] = new Student("Oleg Vynnyk", 97);
        students[2] = new Student("Poplavok", 50);

        StudentsGrades gradeService = new StudentsGrades();

        System.out.println();
        System.out.println("Sorted by grade ascending: ");
        gradeService.sortByGradeAsc(students);
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }

        System.out.println();
        System.out.println("Sorted by grade descending: ");
        gradeService.sortByGradeDesc(students);
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }

        System.out.println();
        System.out.println("Sorted by name ascending: ");
        gradeService.sortByNameAsc(students);
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }

        System.out.println();
        System.out.println("Sorted by name descending: ");
        gradeService.sortByNameDesc(students);
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }

}

