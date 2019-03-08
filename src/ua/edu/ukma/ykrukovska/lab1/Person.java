package ua.edu.ukma.ykrukovska.lab1;

public class Person {

    public String name;
    private Faculty faculty;
    private AcademicDepartment academicDepartment;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public AcademicDepartment getAcademicDepartment() {
        return academicDepartment;
    }

    public void setAcademicDepartment(AcademicDepartment academicDepartment) {
        this.academicDepartment = academicDepartment;
    }
}
