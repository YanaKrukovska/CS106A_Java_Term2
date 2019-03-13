package ua.edu.ukma.ykrukovska.unit9.practice;

public class Student {

    private String name;
    private double averageMark;
    private String address;

    public Student(String name, double averageMark, String address) {
        this.name = name;
        this.averageMark = averageMark;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverageMark() {
        return averageMark;
    }


    @Override
    public String toString() {
        return "Name: " + name + ". Address: " + address + ". Average mark: " + averageMark;
    }
}
