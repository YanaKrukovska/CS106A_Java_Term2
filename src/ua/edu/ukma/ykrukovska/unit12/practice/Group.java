package ua.edu.ukma.ykrukovska.unit12.practice;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Group {

    private String name;
    private Set<Student> students = new TreeSet<>();

    public Group(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void printStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void deleteStudent(Student student) {
        students.remove(student);
    }

    public void deleteStudentByName(String name) {
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getName().equals(name)) {
                iterator.remove();
            }
        }

    }

    @Override
    public String toString() {
        String studentsList = "";
        int counter = 1;
       for (Student student : students){
           studentsList += counter++ + ". " + student + System.lineSeparator();
       }
        return "Group " + name + ": " + System.lineSeparator() + studentsList;
    }
}
