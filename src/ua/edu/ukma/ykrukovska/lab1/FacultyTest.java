package ua.edu.ukma.ykrukovska.lab1;

import org.junit.Assert;
import org.junit.Test;

public class FacultyTest {

    @Test
    public void addAcademicDepartment() {

        Faculty faculty = new Faculty("FI");
        faculty.addAcademicDepartment( new AcademicDepartment("Math"));
        Assert.assertNotNull(faculty.getAcademicDepartment( "Math"));

    }


    @Test
    public void deleteAcademicDepartment() {

        Faculty faculty = new Faculty("FI");
        faculty.addAcademicDepartment( new AcademicDepartment("Math"));
        faculty.addAcademicDepartment( new AcademicDepartment("Models"));
        faculty.addAcademicDepartment( new AcademicDepartment("Algorithms"));
        faculty.deleteAcademicDepartment("Models");
        Assert.assertNotNull(faculty.getAcademicDepartment( "Math"));
        Assert.assertNull(faculty.getAcademicDepartment( "Models"));
        Assert.assertNotNull(faculty.getAcademicDepartment( "Algorithms"));

    }

    @Test
    public void editAcademicDepartment() {

        Faculty faculty = new Faculty("FI");
        faculty.addAcademicDepartment( new AcademicDepartment("Math"));
        faculty.addAcademicDepartment( new AcademicDepartment("Models"));
        faculty.addAcademicDepartment( new AcademicDepartment("Algorithms"));
        faculty.editAcademicDepartment("Models", "Networks");
        Assert.assertNotNull(faculty.getAcademicDepartment( "Math"));
        Assert.assertNull(faculty.getAcademicDepartment( "Models"));
        Assert.assertNotNull(faculty.getAcademicDepartment( "Networks"));
        Assert.assertNotNull(faculty.getAcademicDepartment( "Algorithms"));

    }
}