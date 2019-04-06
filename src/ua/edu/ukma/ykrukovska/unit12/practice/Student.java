package ua.edu.ukma.ykrukovska.unit12.practice;

import java.util.Objects;

public class Student implements Comparable {

    private String name;

    public Student(String name) {
        this.name = name;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Object o) {

        Student student = (Student) o;
        return name.compareTo(student.name);


    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
}
