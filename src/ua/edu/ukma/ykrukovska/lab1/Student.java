package ua.edu.ukma.ykrukovska.lab1;

public class Student extends Person {

    private int course;
    private String group;

    public Student(String name, int course, String group) {
        super(name);
        this.course = course;
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "Student. Name: " + name + ", faculty: " + getFaculty().getName() + ", academic department: " +
                getAcademicDepartment().getName() + ", course: " + course + ", group: " + group;

    }
}
