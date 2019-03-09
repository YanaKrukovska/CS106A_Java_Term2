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
        university.addFaculty(new Faculty("FA"));
        university.addFaculty(new Faculty("FB"));
        university.addFaculty(new Faculty("FC"));
        university.deleteFaculty("FB");
        Assert.assertEquals("FA", university.getFaculties()[0].getName());
        Assert.assertEquals("FC", university.getFaculties()[1].getName());
        Assert.assertNull(university.getFaculties()[2]);

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
    public void allStudentsOrderByCourse() {
        University university = new University();
        Faculty faculty = new Faculty("FI");
        Faculty faculty1 = new Faculty("Law");
        university.addFaculty(faculty);
        university.addFaculty(faculty1);
        AcademicDepartment academicDepartment = new AcademicDepartment("Math");
        faculty.addAcademicDepartment(academicDepartment);
        AcademicDepartment academicDepartment1 = new AcademicDepartment("Foreign Laws");
        faculty1.addAcademicDepartment(academicDepartment1);

        academicDepartment.addStudent(new Student("Justin Bieber", 1, "Math"));
        academicDepartment.addStudent(new Student("Justin Timberlake", 2, "Math"));
        academicDepartment.addStudent(new Student("Oleg Vynnyk", 1, "Math"));
        academicDepartment1.addStudent(new Student("Poplavok", 3, "Foreign Laws"));
        academicDepartment1.addStudent(new Student("Celine Dion", 1, "Foreign Laws"));

        Student[] result = university.getAllStudentOrderByCourse();
        Assert.assertEquals(1, result[0].getCourse());
        Assert.assertEquals(1, result[1].getCourse());
        Assert.assertEquals(1, result[2].getCourse());
        Assert.assertEquals(2, result[3].getCourse());
        Assert.assertEquals(3, result[4].getCourse());
    }


    @Test
    public void studentsOfFacultyByName() {
        University university = new University();
        Faculty faculty = new Faculty("FI");
        Faculty faculty1 = new Faculty("Law");
        university.addFaculty(faculty);
        university.addFaculty(faculty1);
        AcademicDepartment academicDepartment = new AcademicDepartment("Math");
        faculty.addAcademicDepartment(academicDepartment);
        AcademicDepartment academicDepartment1 = new AcademicDepartment("Foreign Laws");
        faculty1.addAcademicDepartment(academicDepartment1);

        academicDepartment.addStudent(new Student("Oleg Vynnyk", 1, "Math"));
        academicDepartment.addStudent(new Student("Justin Bieber", 1, "Math"));
        academicDepartment.addStudent(new Student("Justin Timberlake", 2, "Math"));
        academicDepartment1.addStudent(new Student("Poplavok", 3, "Foreign Laws"));
        academicDepartment1.addStudent(new Student("Celine Dion", 1, "Foreign Laws"));

        Student[] result = (Student[]) university.getStudentsOfFacultyByName("Law");
        Assert.assertEquals("Celine Dion", result[0].getName());
        Assert.assertEquals("Poplavok", result[1].getName());

        Student[] result1 = (Student[]) university.getStudentsOfFacultyByName("FI");
        Assert.assertEquals("Justin Bieber", result1[0].getName());
        Assert.assertEquals("Justin Timberlake", result1[1].getName());
        Assert.assertEquals("Oleg Vynnyk", result1[2].getName());
    }

    @Test
    public void teachersOfFacultyByName() {
        University university = new University();
        Faculty faculty = new Faculty("FI");
        Faculty faculty1 = new Faculty("Law");
        university.addFaculty(faculty);
        university.addFaculty(faculty1);
        AcademicDepartment academicDepartment = new AcademicDepartment("Math");
        faculty.addAcademicDepartment(academicDepartment);
        AcademicDepartment academicDepartment1 = new AcademicDepartment("Foreign Laws");
        faculty1.addAcademicDepartment(academicDepartment1);

        academicDepartment.addTeacher(new Teacher("Oleg Vynnyk"));
        academicDepartment.addTeacher(new Teacher("Justin Bieber"));
        academicDepartment.addTeacher(new Teacher("Britney Spears"));
        academicDepartment1.addTeacher(new Teacher("Mariah Carey"));
        academicDepartment1.addTeacher(new Teacher("Celine Dion"));

        Teacher[] result = (Teacher[]) university.getTeachersOfFacultyByName("Law");
        Assert.assertEquals("Celine Dion", result[0].getName());
        Assert.assertEquals("Mariah Carey", result[1].getName());

        Teacher[] result1 = (Teacher[]) university.getTeachersOfFacultyByName("FI");
        Assert.assertEquals("Britney Spears", result1[0].getName());
        Assert.assertEquals("Justin Bieber", result1[1].getName());
        Assert.assertEquals("Oleg Vynnyk", result1[2].getName());
    }


    @Test
    public void studentsOfDepartmentByCourse() {
        University university = new University();
        Faculty faculty = new Faculty("FI");
        Faculty faculty1 = new Faculty("Law");
        university.addFaculty(faculty);
        university.addFaculty(faculty1);
        AcademicDepartment academicDepartment = new AcademicDepartment("Math");
        faculty.addAcademicDepartment(academicDepartment);
        AcademicDepartment academicDepartment1 = new AcademicDepartment("Foreign Laws");
        faculty1.addAcademicDepartment(academicDepartment1);

        academicDepartment.addStudent(new Student("Oleg Vynnyk", 1, "Math"));
        academicDepartment.addStudent(new Student("Justin Timberlake", 2, "Math"));
        academicDepartment.addStudent(new Student("Justin Bieber", 1, "Math"));
        academicDepartment1.addStudent(new Student("Poplavok", 3, "Foreign Laws"));
        academicDepartment1.addStudent(new Student("Celine Dion", 1, "Foreign Laws"));

        Student[] result = university.getStudentsOfDepartmentOrderByCourse("Math");

        Assert.assertEquals(1, result[0].getCourse());
        Assert.assertEquals(1, result[1].getCourse());
        Assert.assertEquals(2, result[2].getCourse());

    }

    @Test
    public void studentsOfDepartmentByName() {
        University university = new University();
        Faculty faculty = new Faculty("FI");
        Faculty faculty1 = new Faculty("Law");
        university.addFaculty(faculty);
        university.addFaculty(faculty1);
        AcademicDepartment academicDepartment = new AcademicDepartment("Math");
        faculty.addAcademicDepartment(academicDepartment);
        AcademicDepartment academicDepartment1 = new AcademicDepartment("Foreign Laws");
        faculty1.addAcademicDepartment(academicDepartment1);

        academicDepartment.addStudent(new Student("Justin Timberlake", 2, "Math"));
        academicDepartment.addStudent(new Student("Oleg Vynnyk", 1, "Math"));
        academicDepartment.addStudent(new Student("Justin Bieber", 1, "Math"));
        academicDepartment1.addStudent(new Student("Poplavok", 3, "Foreign Laws"));
        academicDepartment1.addStudent(new Student("Celine Dion", 1, "Foreign Laws"));

        Student[] result = (Student[]) university.getStudentsOfDepartmentOrderByName("Foreign Laws");
        Assert.assertEquals("Celine Dion", result[0].getName());
        Assert.assertEquals("Poplavok", result[1].getName());

        Student[] result1 = (Student[]) university.getStudentsOfDepartmentOrderByName("Math");
        Assert.assertEquals("Justin Bieber", result1[0].getName());
        Assert.assertEquals("Justin Timberlake", result1[1].getName());
        Assert.assertEquals("Oleg Vynnyk", result1[2].getName());
    }

    @Test
    public void teachersOfDepartmentByName() {
        University university = new University();
        Faculty faculty = new Faculty("FI");
        Faculty faculty1 = new Faculty("Law");
        university.addFaculty(faculty);
        university.addFaculty(faculty1);
        AcademicDepartment academicDepartment = new AcademicDepartment("Math");
        faculty.addAcademicDepartment(academicDepartment);
        AcademicDepartment academicDepartment1 = new AcademicDepartment("Foreign Laws");
        faculty1.addAcademicDepartment(academicDepartment1);

        academicDepartment.addTeacher(new Teacher("Justin Timberlake"));
        academicDepartment.addTeacher(new Teacher("Oleg Vynnyk"));
        academicDepartment1.addTeacher(new Teacher("Justin Bieber"));
        academicDepartment1.addTeacher(new Teacher("Poplavok"));
        academicDepartment1.addTeacher(new Teacher("Celine Dion"));

        Teacher[] result = (Teacher[]) university.getTeachersOfDepartmentOrderByName("Foreign Laws");
        Assert.assertEquals("Celine Dion", result[0].getName());
        Assert.assertEquals("Justin Bieber", result[1].getName());
        Assert.assertEquals("Poplavok", result[2].getName());

        Teacher[] result1 = (Teacher[]) university.getTeachersOfDepartmentOrderByName("Math");
        Assert.assertEquals("Justin Timberlake", result1[0].getName());
        Assert.assertEquals("Oleg Vynnyk", result1[1].getName());
    }

    @Test
    public void studentsOfDepartmentAndCourse() {
        University university = new University();
        Faculty faculty = new Faculty("FI");
        Faculty faculty1 = new Faculty("Law");
        university.addFaculty(faculty);
        university.addFaculty(faculty1);
        AcademicDepartment academicDepartment = new AcademicDepartment("Math");
        faculty.addAcademicDepartment(academicDepartment);
        AcademicDepartment academicDepartment1 = new AcademicDepartment("Foreign Laws");
        faculty1.addAcademicDepartment(academicDepartment1);


        academicDepartment.addStudent(new Student("Justin Timberlake", 2, "Math"));
        academicDepartment.addStudent(new Student("Britney Spears", 2, "Math"));
        academicDepartment.addStudent(new Student("Oleg Vynnyk", 3, "Math"));
        academicDepartment.addStudent(new Student("Justin Bieber", 1, "Math"));
        academicDepartment.addStudent(new Student("Donald Trump", 2, "Math"));

        academicDepartment1.addStudent(new Student("Poplavok", 3, "Foreign Laws"));
        academicDepartment1.addStudent(new Student("Celine Dion", 1, "Foreign Laws"));
        academicDepartment1.addStudent(new Student("Alla Pugacheva", 1, "Foreign Laws"));

        Student[] result = (Student[]) university.getStudentsOfDepartmentAndCourse("Foreign Laws", 1);
        Assert.assertEquals("Celine Dion", result[0].getName());
        Assert.assertEquals("Alla Pugacheva", result[1].getName());

        Student[] result1 = (Student[]) university.getStudentsOfDepartmentAndCourse("Math", 2);
        Assert.assertEquals("Justin Timberlake", result1[0].getName());
        Assert.assertEquals("Britney Spears", result1[1].getName());
        Assert.assertEquals("Donald Trump", result1[2].getName());

    }

    @Test
    public void studentsOfDepartmentAndCourseByName() {
        University university = new University();
        Faculty faculty = new Faculty("FI");
        Faculty faculty1 = new Faculty("Law");
        university.addFaculty(faculty);
        university.addFaculty(faculty1);
        AcademicDepartment academicDepartment = new AcademicDepartment("Math");
        faculty.addAcademicDepartment(academicDepartment);
        AcademicDepartment academicDepartment1 = new AcademicDepartment("Foreign Laws");
        faculty1.addAcademicDepartment(academicDepartment1);


        academicDepartment.addStudent(new Student("Justin Timberlake", 2, "Math"));
        academicDepartment.addStudent(new Student("Britney Spears", 2, "Math"));
        academicDepartment.addStudent(new Student("Oleg Vynnyk", 3, "Math"));
        academicDepartment.addStudent(new Student("Justin Bieber", 1, "Math"));
        academicDepartment.addStudent(new Student("Donald Trump", 2, "Math"));

        academicDepartment1.addStudent(new Student("Poplavok", 3, "Foreign Laws"));
        academicDepartment1.addStudent(new Student("Celine Dion", 1, "Foreign Laws"));
        academicDepartment1.addStudent(new Student("Alla Pugacheva", 1, "Foreign Laws"));

        Student[] result = (Student[]) university.getStudentsOfDepartmentAndCourseOrderByName("Foreign Laws", 1);
        Assert.assertEquals("Alla Pugacheva", result[0].getName());
        Assert.assertEquals("Celine Dion", result[1].getName());

        Student[] result1 = (Student[]) university.getStudentsOfDepartmentAndCourseOrderByName("Math", 2);
        Assert.assertEquals("Britney Spears", result1[0].getName());
        Assert.assertEquals("Donald Trump", result1[1].getName());
        Assert.assertEquals("Justin Timberlake", result1[2].getName());

    }

}