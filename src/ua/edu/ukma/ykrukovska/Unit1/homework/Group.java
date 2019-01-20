package ua.edu.ukma.ykrukovska.Unit1.homework;

public class Group {


    private Student[] students;

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    @Override
    public String toString() {
        String result = "Students amount: " + students.length + ". Names: ";
        for (int i = 0; i < students.length; i++) {
            result += students[i].toString() + ", ";
        }
        return result;
    }

    public void filterStudents(char letter) {


        for (int i = 0; i < students.length; i++) {
            if (students[i].getName().charAt(0) == letter) {
                System.out.println(students[i].toString());
            }
        }

    }
}
