package ua.edu.ukma.ykrukovska.Unit1;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentsGradesTest {

    @org.junit.Test
    public void getMaxGrade() {

        StudentsGrades gradeService = new StudentsGrades();
        int[] currentGrades = {10,40,50,33,56,75,66,99,45,20,11};
        gradeService.setGrades(currentGrades);
        assertEquals(99, gradeService.getMaxGrade());

    }

    @Test
    public void getMinGrade() {
        StudentsGrades gradeService = new StudentsGrades();
        int[] currentGrades = {10,40,50,33,56,75,66,99,45,20,11};
        gradeService.setGrades(currentGrades);
        assertEquals(10, gradeService.getMinGrade());

    }

    @Test
    public void getAverageGrade() {
        StudentsGrades gradeService = new StudentsGrades();
        int[] currentGrades = {10, 20, 30};
        gradeService.setGrades(currentGrades);
        assertEquals(20, gradeService.getAverageGrade(), 0.01);

    }

    @Test
    public void getStudentsHigherAverage() {
        StudentsGrades gradeService = new StudentsGrades();
        int[] currentGrades = {10, 20, 30, 60};
        gradeService.setGrades(currentGrades);
        assertEquals(1, gradeService.getStudentsHigherAverage());

    }

    @Test
    public void getStudentsLowerAverage() {
        StudentsGrades gradeService = new StudentsGrades();
        int[] currentGrades = {10, 20, 30, 60};
        gradeService.setGrades(currentGrades);
        assertEquals(2, gradeService.getStudentsLowerAverage());

    }

    @Test
    public void getStudentsExcellent() {
        StudentsGrades gradeService = new StudentsGrades();
        int[] currentGrades = {10, 20, 30, 60, 91, 100, 95};
        gradeService.setGrades(currentGrades);
        assertEquals(3, gradeService.getStudentsExcellent());

    }

    @Test
    public void getStudentsGood() {
        StudentsGrades gradeService = new StudentsGrades();
        int[] currentGrades = {10, 20, 30, 60, 71, 77, 90};
        gradeService.setGrades(currentGrades);
        assertEquals(3, gradeService.getStudentsGood());

    }

    @Test
    public void getStudentsSatisfying() {
        StudentsGrades gradeService = new StudentsGrades();
        int[] currentGrades = {10, 20, 30, 60, 70, 66, 68};
        gradeService.setGrades(currentGrades);
        assertEquals(4, gradeService.getStudentsSatisfying());

    }

    @Test
    public void getStudentsBad() {
        StudentsGrades gradeService = new StudentsGrades();
        int[] currentGrades = {0, 20, 30, 60, 59, 66, 68};
        gradeService.setGrades(currentGrades);
        assertEquals(4, gradeService.getStudentsBad());

    }
}