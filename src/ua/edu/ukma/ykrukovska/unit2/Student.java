package ua.edu.ukma.ykrukovska.unit2;

public class Student {

    private String name;
    private int averageGrade;

    public Student(String name, int grade) {
        this.name = name;
        this.averageGrade = grade;
    }

    public String getName() {
        return name;
    }

    public int getAverageGrade() {
        return averageGrade;
    }

    @Override
    public String toString() {
        return name + ": " + averageGrade;
    }
}
