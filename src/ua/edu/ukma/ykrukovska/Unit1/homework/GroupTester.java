package ua.edu.ukma.ykrukovska.Unit1.homework;

import ua.edu.ukma.ykrukovska.Unit1.DataInput;

import java.io.IOException;

public class GroupTester {
    private static final int MAX_SIZE = 5;

    public static void main(String[] args) throws IOException {
        int inputCounter = 0;

        Group group = new Group();

        Student [] students = new Student[MAX_SIZE];

        System.out.println("Insert students names: ");
        do {
            String name = DataInput.getString();
            students[inputCounter++] = new Student(name);

        } while (inputCounter < MAX_SIZE);

        group.setStudents(students);

        System.out.println("All students: " + group.toString());
        System.out.println("Insert letter for filtering: ");

        char letter = DataInput.getChar();
        group.filterStudents(letter);
    }
}
