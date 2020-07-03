package ua.edu.ukma.ykrukovska.lab1;

public class Teacher extends Person {

    public Teacher(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Teacher. Name: " + name + ", faculty: " + getFaculty().getName() + ", academic department: " +
                getAcademicDepartment().getName();

    }
}
