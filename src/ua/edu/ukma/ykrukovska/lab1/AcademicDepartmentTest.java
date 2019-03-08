package ua.edu.ukma.ykrukovska.lab1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AcademicDepartmentTest {

    @Test
    public void addStudent() {

        AcademicDepartment academicDepartment = new AcademicDepartment("Math");
        academicDepartment.addStudent( new Student("Justin Bieber", 1, "A42"));
        Assert.assertNotNull(academicDepartment.getStudent( "Justin Bieber"));

    }

    @Test
    public void deleteStudent() {

        AcademicDepartment academicDepartment = new AcademicDepartment("Math");
        academicDepartment.addStudent( new Student("Justin Bieber", 1, "A42"));
        academicDepartment.addStudent( new Student("Oleg Vynnyk", 3, "AA5"));
        academicDepartment.addStudent( new Student("Mykhailo Poplavskyi", 6, "AAA"));
        academicDepartment.deleteStudent("Mykhailo Poplavskyi");
        Assert.assertNotNull(academicDepartment.getStudent( "Justin Bieber"));
        Assert.assertNotNull(academicDepartment.getStudent( "Oleg Vynnyk"));
        Assert.assertNull(academicDepartment.getStudent( "Mykhailo Poplavskyi"));

    }

    @Test
    public void editStudent() {

        AcademicDepartment academicDepartment = new AcademicDepartment("Math");
        academicDepartment.addStudent( new Student("Justin Bieber", 1, "A42"));
        academicDepartment.addStudent( new Student("Oleg Vynnyk", 3, "AA5"));
        academicDepartment.addStudent( new Student("Mykhailo Poplavskyi", 6, "AAA"));
       academicDepartment.editStudent("Oleg Vynnyk", "Olezhka Vynnyk");
        Assert.assertNotNull(academicDepartment.getStudent( "Justin Bieber"));
        Assert.assertNull(academicDepartment.getStudent( "Oleg Vynnyk"));
        Assert.assertNotNull(academicDepartment.getStudent( "Olezhka Vynnyk"));
        Assert.assertNotNull(academicDepartment.getStudent( "Mykhailo Poplavskyi"));


    }

    @Test
    public void addTeacher() {

        AcademicDepartment academicDepartment = new AcademicDepartment("Math");
        academicDepartment.addTeacher( new Teacher("Justin Timberlake"));
        Assert.assertNotNull(academicDepartment.getTeacher( "Justin Timberlake"));

    }

    @Test
    public void deleteTeacher() {

        AcademicDepartment academicDepartment = new AcademicDepartment("Math");
        academicDepartment.addTeacher( new Teacher("Mariah Carey"));
        academicDepartment.addTeacher( new Teacher("Justin Timberlake"));
        academicDepartment.addTeacher( new Teacher("Britney Spears"));
        academicDepartment.deleteTeacher("Mariah Carey");
        Assert.assertNull(academicDepartment.getTeacher( "Mariah Carey"));
        Assert.assertNotNull(academicDepartment.getTeacher( "Justin Timberlake"));
        Assert.assertNotNull(academicDepartment.getTeacher( "Britney Spears"));

    }

    @Test
    public void editTeacher() {

        AcademicDepartment academicDepartment = new AcademicDepartment("Math");
        academicDepartment.addTeacher( new Teacher("Mariah Carey"));
        academicDepartment.addTeacher( new Teacher("Justin Timberlake"));
        academicDepartment.addTeacher( new Teacher("Britney Spears"));

        academicDepartment.editTeacher("Mariah Carey", "Celine Dion");

        Assert.assertNull(academicDepartment.getTeacher( "Mariah Carey"));
        Assert.assertNotNull(academicDepartment.getTeacher( "Justin Timberlake"));
        Assert.assertNotNull(academicDepartment.getTeacher( "Britney Spears"));
        Assert.assertNotNull(academicDepartment.getTeacher( "Celine Dion"));


    }
}