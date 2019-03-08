package ua.edu.ukma.ykrukovska.lab1;

import org.junit.Assert;
import org.junit.Test;


public class UniversityTest {


    @Test
    public void addOneFaculty() {
        University university = new University();
        university.addFaculty(new Faculty("FI"));
        Assert.assertNotNull(university.getFaculty("FI"));

    }

    @Test
    public void findNoneExistentFaculty() {
        University university = new University();
        university.addFaculty(new Faculty("FI"));
        Assert.assertNull(university.getFaculty("FF"));

    }

    @Test
    public void deleteFaculty() {
        University university = new University();
        university.addFaculty(new Faculty("FI"));
        Assert.assertNotNull(university.getFaculty("FI"));
        university.deleteFaculty("FI");
        Assert.assertNull(university.getFaculty("FI"));

    }

    @Test
    public void editFaculty() {
        University university = new University();
        university.addFaculty(new Faculty("FI"));
        Assert.assertNotNull(university.getFaculty("FI"));
        university.editFaculty("FI", "FA");
        Assert.assertNull(university.getFaculty("FI"));
        Assert.assertNotNull(university.getFaculty("FA"));

    }

    @Test
    public void findOneStudentByName() {
        University university = new University();
        Faculty faculty = new Faculty("FI");
        university.addFaculty(faculty);
        AcademicDepartment academicDepartment = new AcademicDepartment("Math");
        faculty.addAcademicDepartment(academicDepartment);
        academicDepartment.addStudent(new Student("Justin Bieber", 1, "AA"));
        academicDepartment.addStudent(new Student("Justin Timberlake", 2, "AA"));
        academicDepartment.addStudent(new Student("Oleg Vynnyk", 1, "AA"));
        academicDepartment.addStudent(new Student("Oleg Vynnyk", 2, "AA"));
        Assert.assertNotNull(university.findStudentByName("Oleg Vynnyk"));
        Assert.assertEquals("Oleg Vynnyk", university.findStudentByName("Oleg Vynnyk")[0].getName());


    }

    @Test
    public void findOneStudentByCourse() {
        University university = new University();
        Faculty faculty = new Faculty("FI");
        university.addFaculty(faculty);
        AcademicDepartment academicDepartment = new AcademicDepartment("Math");
        faculty.addAcademicDepartment(academicDepartment);
        academicDepartment.addStudent(new Student("Justin Bieber", 1, "AA"));
        academicDepartment.addStudent(new Student("Justin Timberlake", 2, "AA"));
        academicDepartment.addStudent(new Student("Oleg Vynnyk", 1, "AA"));
        Assert.assertEquals("Justin Bieber", university.findStudentByCourse(1)[0].getName());
        Assert.assertEquals("Oleg Vynnyk", university.findStudentByCourse(1)[1].getName());


    }

    @Test
    public void findStudentsByGroup() {
        University university = new University();
        Faculty faculty = new Faculty("FI");
        university.addFaculty(faculty);
        AcademicDepartment academicDepartment = new AcademicDepartment("Math");
        faculty.addAcademicDepartment(academicDepartment);
        academicDepartment.addStudent(new Student("Justin Bieber", 1, "AA"));
        academicDepartment.addStudent(new Student("Justin Timberlake", 2, "AA"));
        academicDepartment.addStudent(new Student("Oleg Vynnyk", 1, "FA"));
        Assert.assertEquals("Justin Bieber", university.findStudentByGroup("AA")[0].getName());
        Assert.assertEquals("Justin Timberlake", university.findStudentByGroup("AA")[1].getName());


    }

    @Test
    public void findTeacherByName() {
        University university = new University();
        Faculty faculty = new Faculty("FI");
        university.addFaculty(faculty);
        AcademicDepartment academicDepartment = new AcademicDepartment("Math");
        faculty.addAcademicDepartment(academicDepartment);
        academicDepartment.addTeacher(new Teacher("Celine Dion"));
        academicDepartment.addTeacher(new Teacher("Britney Spears"));
        academicDepartment.addTeacher(new Teacher("Mariah Carey"));
        academicDepartment.addTeacher(new Teacher("Celine Dion"));
        Assert.assertEquals("Celine Dion", university.findTeacherByName("Celine Dion")[0].getName());
        Assert.assertEquals("Celine Dion", university.findTeacherByName("Celine Dion")[1].getName());


    }

    @Test
    public void addOneStudent() {
       /* University university = new University();
        university.getFaculty("FI").add(new Student("Justin Bieber", 1, "A42"));
        Assert.assertEquals("Justin Bieber", university.getFaculty("FI").getStudent("Justin Bieber").getName());
*/

    }
}